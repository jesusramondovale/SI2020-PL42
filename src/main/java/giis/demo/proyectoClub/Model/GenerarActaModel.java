package giis.demo.proyectoClub.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import giis.demo.proyectoClub.DTO.GenerarActaDTO;
import giis.demo.util.Database;

public class GenerarActaModel {

	private Database db=new Database();
	
	
	
	private static String SQL_ORDEN_DIA = 
								"SELECT ordenDia "
								+ "FROM asambleas "
								+ "WHERE idAsamblea =?";
			
	
	public String obtenerOrdenDia(int id){
		
		List<GenerarActaDTO> DTOs = db.executeQueryPojo(GenerarActaDTO.class, SQL_ORDEN_DIA, id);
		
		if (!DTOs.isEmpty()){
			
			
			return DTOs.get(0).getOrdenDia();
		}
		
		else {
			return "No existe ninguna asamblea con el ID proporcionado!";
		}
			
	} 
	
	public void generarActa(int id, String ordenDia, 
									Map<String, List<Integer>> propuestasFavor, 
									Map<String, List<Integer>> propuestasContra ){

		
		

		
		
		
		Document document = new Document();
		
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Acta_"+ id + ".pdf"));
		} catch (FileNotFoundException e) {
			System.err.println("Error creando el documento PDF");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.err.println("Error creando el documento PDF");
			e.printStackTrace();
		}
		
		document.open();
		
		Font font1 = FontFactory.getFont(FontFactory.TIMES_ITALIC, 36, BaseColor.BLACK);
		Chunk chunk1 = new Chunk("Acta de Asamblea #" + id, font1);
		
		try {
			document.add(new Paragraph("\n\n"));
			document.add(chunk1);
			
		} catch (DocumentException e1) {
			System.err.println("Error editando el documento PDF");
			e1.printStackTrace();
		}
		
		Font font2 = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
		Font font3 = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk2 = new Chunk("Orden del día de la Asamblea: ",font2);
		Chunk chunk3 = new Chunk(ordenDia,font3);
		
		try {
			document.add(new Paragraph("\n\n"));
			document.add(chunk2);
			document.add(new Paragraph("\n\n"));
			document.add(chunk3);
			
		} catch (DocumentException e1) {
			System.err.println("Error editando el documento PDF");
			e1.printStackTrace();
		}
		
		Chunk chunk4 = new Chunk("Propuestas y resultados de la votación: ");
		try {
			document.add(new Paragraph("\n\n"));
			document.add(chunk4);
		} catch (DocumentException e) {
			System.err.println("Error editando el documento PDF");
			e.printStackTrace();
		}
		
		PdfPTable tablaPropuestas = new PdfPTable(3);
		cabecera(tablaPropuestas);
		
		for (Map.Entry<String, List<Integer>> prop : propuestasFavor.entrySet()) {
		    
			int votosFavor = 0;
			int votosContra = 0;
			
			Chunk chunk5 = new Chunk(prop.getKey());
			
			PdfPCell cell = new PdfPCell();
			cell.addElement(chunk5);
			
			tablaPropuestas.addCell(cell);
			
			int i = 0;		
			for (@SuppressWarnings("unused") Integer x : prop.getValue()){ i++; }
			
			votosFavor = i;
			
			Chunk chunk6 = new Chunk(Integer.toString(votosFavor));
			PdfPCell cell2 = new PdfPCell();
			cell2.addElement(chunk6);
			tablaPropuestas.addCell(cell2);
			
			
			i = 0;		
			List<Integer> propContra = propuestasContra.get(prop.getKey());
			
			for (@SuppressWarnings("unused") Integer y : propContra){
				i++;
			}
			
			votosContra = i;
			
			Chunk chunk7 = new Chunk(Integer.toString(votosContra));
			PdfPCell cell3 = new PdfPCell();
			cell3.addElement(chunk7);
			tablaPropuestas.addCell(cell3);
			
		}
		
		try {
			document.add(tablaPropuestas);
			
		} catch (DocumentException e) {
			System.err.println("Error editando el documento PDF");
			e.printStackTrace();
		}
		document.close();	
	}
	

	private void cabecera(PdfPTable table) {
		Stream.of("Propuesta" , "Votos a Favor", "Votos en Contra")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(3);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}
	
	
	
	

	
} // GenerarActaModel


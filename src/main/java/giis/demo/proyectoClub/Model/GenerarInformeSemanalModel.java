package giis.demo.proyectoClub.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.Date;
import java.util.List;
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


import giis.demo.proyectoClub.DTO.GenerarInformeSemanalDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class GenerarInformeSemanalModel {

	private Database db=new Database();

	//Fecha actual para comprobaciones 
	private Date hoy = new Date(System.currentTimeMillis());		

	
	
	// Revisar !!!
	private static final String SQL_RESERVADOR=
			"SELECT a.idSocio , a.grupoBurbuja , a.correo, b.fechaReserva , b.horaInicio , b.horaFin "
					+ "FROM socio AS a "
					+ "INNER JOIN reservas AS b "
					+ "ON a.idSocio = b.idSocio "
					+ "WHERE b.fechaReserva<=? "
					+ "AND b.fechaReserva>?";


	private static final String SQL_GRUPOS= 
			"SELECT grupoBurbuja, correo "
					+"FROM socio "
					+"WHERE grupoBurbuja==?";



	/*
	 *  La función sólo recibe un parámetro (fecha seleccionada) 
	 *  se deberá calcular cual es la fecha 7 días 
	 */
	public void generarInforme(Date dateIni , Date dateFin){

		validateFechaSeleccionada(dateIni);
		validateFechaSeleccionada(dateFin);
		
		
		/*
		 * La variable SOCIOS contendrá una lista de objetos DTO de socios que HAN REALIZADO LA RESERVA
		 */
		List<GenerarInformeSemanalDTO> socios = db.executeQueryPojo(GenerarInformeSemanalDTO.class, SQL_RESERVADOR, Util.dateToIsoString(dateFin), Util.dateToIsoString(dateIni));
		
		//System.out.printf(Util.dateToIsoString(dateIni) + "<->" + Util.dateToIsoString(dateFin) + "\n");
		
		/*
		
		for (GenerarInformeSemanalDTO socio : socios){
		
			
			System.out.printf("ID : " + socio.getIdSocio() + "\n" +
							   "Nombre : " + socio.getNombreSocio() + "\n" + 
			                   "Hora ini : " + socio.getHoraIni() + "\n" + 
			                   "Hora fin : " + socio.getHoraFin() + "\n"); 
			          
			                                                
		}
		*/
		
		// Creamos un documento PDF
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Usuario/Desktop/Informe_["+ Util.dateToIsoString(dateIni) + "]_[" + Util.dateToIsoString(dateFin) + "].pdf"));
		} catch (FileNotFoundException e) {
			System.err.println("Error creando el documento PDF");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.err.println("Error creando el documento PDF");
			e.printStackTrace();
		}

		
		document.open();

		Font font1 = FontFactory.getFont(FontFactory.TIMES_ITALIC, 36, BaseColor.BLACK);
		Chunk chunk1 = new Chunk("INFORME SEMANAL", font1);
		
		try {
			document.add(new Paragraph("\n\n"));
			document.add(chunk1);
			
		} catch (DocumentException e1) {
			System.err.println("Error editando el documento PDF");
			e1.printStackTrace();
		}

		Font fontFecha = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
		Font font2 = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
		Chunk chunkfecha1 = new Chunk("Fecha de inicio del informe : " + (Util.dateToIsoString(dateIni)),fontFecha);
		Chunk chunkfecha2 = new Chunk("Fecha de final del informe : " + (Util.dateToIsoString(dateFin)),fontFecha);
		
		try {
			document.add(new Paragraph("\n\n"));
			document.add(chunkfecha1);
			document.add(new Paragraph("\n\n"));
			document.add(chunkfecha2);
			document.add(new Paragraph("\n\n"));
		} catch (DocumentException e1) {
			System.err.println("Error editando el documento PDF");
			e1.printStackTrace();
		}
		
		
		
		Chunk chunk2 = new Chunk("--  Tabla de Socios que realizaron las reservas --", font2);
		try {
			document.add(chunk2);
			document.add(new Paragraph("\n\n"));
			document.add(new Paragraph("\n\n"));
		} catch (DocumentException e1) {
			System.err.println("Error editando el documento PDF");
			e1.printStackTrace();
		}

		//Crea la tabla para los socios que realizaron las reservas
		PdfPTable tablaReservadores = new PdfPTable(6);
		
		float[] widths = new float[] { 30f , 45f, 100f, 65f, 40f, 40f };
		try {
			tablaReservadores.setWidths(widths);
		} catch (DocumentException e2) {
			System.err.println("Error editando el documento PDF");
			e2.printStackTrace();
		}
		

		
		
		//Inserta la cabecera para la tabla 
		cabeceraReservadores(tablaReservadores);

		// Inserta los datos de los socios reservadores
		insertarFilas(tablaReservadores,socios);

		// Añade la tabla al documento PDF
		try {
			
			document.add(tablaReservadores);
			document.add(new Paragraph("\n\n"));
			document.add(new Paragraph("\n\n"));
	        
		} catch (DocumentException e) {
			System.err.println("Error editando el documento PDF");
			e.printStackTrace();
		}


		Chunk chunk3 = new Chunk("--  Tabla de Compañeros de Grupo Burbuja --", font2);
		try {
			document.add(chunk3);
			document.add(new Paragraph("\n\n"));
			document.add(new Paragraph("\n\n"));
	        
		} catch (DocumentException e1) {
			System.err.println("Error editando el documento PDF");
			e1.printStackTrace();
		}

		//Crea la tabla para los socios compañeros de grupo burbuja
		PdfPTable tablaCompañeros = new PdfPTable(2);

		// Inserta la cabecera para la tabla de compañeros
		cabeceraCompañeros(tablaCompañeros);

		/*
		 * Para cada socio reservador que se devuelva, hay que buscar el contacto de todos los socios
		 * de su mismo grupo burbuja.
		 */

		for (GenerarInformeSemanalDTO socio : socios){

			/* La variable socios_grupo contendrá la información de contacto de cada uno de los 
			 * compañeros de grupo burbuja del socio actual		 
			 */
			List<GenerarInformeSemanalDTO> socios_grupo = 
					db.executeQueryPojo(GenerarInformeSemanalDTO.class, SQL_GRUPOS, socio.getGrupoBurbuja());

			for (GenerarInformeSemanalDTO compa : socios_grupo){
				tablaCompañeros.addCell(Integer.toString(compa.getGrupoBurbuja()));
				tablaCompañeros.addCell(compa.getCorreo());
			}
		}

		// Añadimos la tabla de los compañeros
		try {
			document.add(tablaCompañeros);
		} catch (DocumentException e) {
			System.err.println("Error añadiendo tabla de compañeros al documento PDF");
			e.printStackTrace();
		}
		
		document.close();

	} // end generarInforme

	private void cabeceraCompañeros(PdfPTable table) {
		Stream.of("Grupo Burbuja", "Contacto (e-mail)")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void cabeceraReservadores(PdfPTable table) {
		Stream.of("ID de Socio", "Grupo Burbuja", "Correo electrónico", "Fecha de la reserva" , "Hora de inicio de la reserva" , "Hora de fin de la reserva")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void insertarFilas(PdfPTable table, List<GenerarInformeSemanalDTO> datos) {

		for (GenerarInformeSemanalDTO socio : datos){

			Chunk chunk1 = new Chunk(Integer.toString(socio.getIdSocio()));
			Chunk chunk2 = new Chunk(Integer.toString(socio.getGrupoBurbuja()));
			Chunk chunk3 = new Chunk(socio.getCorreo());
			Chunk chunk4 = new Chunk(socio.getFechaReserva());
			Chunk chunk5 = new Chunk(socio.getHoraInicio());
			Chunk chunk6 = new Chunk(socio.getHoraFin());
			
			
			
			PdfPCell celda1 = new PdfPCell();
			PdfPCell celda2 = new PdfPCell();
			PdfPCell celda3 = new PdfPCell();
			PdfPCell celda4 = new PdfPCell();
			PdfPCell celda5 = new PdfPCell();
			PdfPCell celda6 = new PdfPCell();
			
			celda1.addElement(chunk1);
			celda2.addElement(chunk2);
			celda3.addElement(chunk3);
			celda4.addElement(chunk4);
			celda5.addElement(chunk5);
			celda6.addElement(chunk6);

			
				
					
			table.addCell(celda1);
			table.addCell(celda2);
			table.addCell(celda3);
			table.addCell(celda4);
			table.addCell(celda5);
			table.addCell(celda6);

			

		}

	}


	/* Compara la fecha introducida con la fecha actual para que no se puedan seleccionar fechas futuras*/ 	
	private void validateFechaSeleccionada(Date date){
		//System.out.println("\n Fecha seleccionada : " + date.toString());
		//System.out.println("\n Fecha de hoy : " + hoy.toString());
		validateCondition(date.compareTo(hoy)<0,"La fecha seleccionada no puede ser posterior a la de hoy!");

	}

	/* Función interna para validar condición*/
	private void validateCondition(boolean cond, String msg) {

		if (!cond){
			throw new ApplicationException(msg);
		}

	}



}

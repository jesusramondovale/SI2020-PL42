package giis.demo.proyectoClub.Model;

import java.util.List;
import java.util.Map;

import com.itextpdf.text.Document;

import giis.demo.proyectoClub.DTO.GenerarActaDTO;
import giis.demo.util.Database;

public class GenerarActaModel {

	private Database db=new Database();
	
	private Map<String, List<Integer>> propuestas;
	private List<Integer> sociosFavor;
	private List<Integer> sociosContra;
	
	private static String SQL_ORDEN_DIA = 
								"SELECT ordenDia "
								+ "FROM asambleas "
								+ "WHERE idAsamblea =?";
			
	
	// Cuando se pulse OK
	public String obtenerOrdenDia(int id){
		
		List<GenerarActaDTO> DTOs = db.executeQueryPojo(GenerarActaDTO.class, SQL_ORDEN_DIA, id);
		
		if (!DTOs.isEmpty()){
			
			
			return DTOs.get(0).getOrdenDia();
		}
		else {
			return "No existe ninguna Asamblea con el ID especificado";
		}
			
	} 
	
	
	
	public void insertarSocio(List<Integer> socios , int id){
		socios.add(id);
	}
	
	
	
	// Cuando se pulse CREAR ACTA
	public void addPropuesta(String propuesta, List<Integer> socios){
		
		this.propuestas.put(propuesta, socios);
		
	}
	
	
	
	// Cuando se pulse CREAR ACTA
	public void generarActa(int id, Map<String, List<Integer>> propuestas){
		
		Document document = new Document();
		
		/*
		 * 
		    Por hacer  
		 *
		 */
		
	
		document.close();	
	}
	
	
	
	
	public List<Integer> getSociosFavor() {
		return sociosFavor;
	}



	public void setSociosFavor(List<Integer> sociosFavor) {
		this.sociosFavor = sociosFavor;
	}



	public List<Integer> getSociosContra() {
		return sociosContra;
	}



	public void setSociosContra(List<Integer> sociosContra) {
		this.sociosContra = sociosContra;
	}

	
} // GenerarActaModel


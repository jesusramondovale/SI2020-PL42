package giis.demo.proyectoClub.model;

import java.util.List;

import giis.demo.proyectoClub.DTO.LicenciaDTO;
import giis.demo.util.Database;

public class ValidarPagoModel {
	
	public Database db = new Database();

	public List<LicenciaDTO> getLicencias() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM licencia";
		return db.executeQueryPojo(LicenciaDTO.class, sql);
	}
	

}

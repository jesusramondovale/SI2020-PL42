package giis.demo.proyectoClub.model;

import java.util.List;

import giis.demo.proyectoClub.DTO.LicenciaDisplayDTO;
import giis.demo.util.Database;

public class ValidarPagoModel {
	
	public Database db = new Database();

	public List<LicenciaDisplayDTO> getLicencias() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM licencia";
		return db.executeQueryPojo(LicenciaDisplayDTO.class, sql);
	}
	
	public void editarLicencia(String numLicencia, String estado) {
		String sql = "UPDATE licencia SET estadoLicencia='Pagada' where numLicencia=? and estado=?";
		db.executeUpdate(sql, numLicencia, estado);
	}
	
	public void tramitarLicencias(String Pagada) {
		String sql = "UPDATE licencia SET estadoLicencia='Tramitada' where estadoLicencia=?";
		db.executeUpdate(sql, Pagada);
	}
}
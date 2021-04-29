package giis.demo.proyectoClub.model;

import java.util.List;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.proyectoClub.DTO.LicenciaDisplayDTO;
import giis.demo.util.Database;

public class ReservaBurbujaModel {

	public Database db = new Database();

	public List<InstalacionDisplayDTO> getInstalacion() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombreInstalacion from instalacion";
		return db.executeQueryPojo(InstalacionDisplayDTO.class, sql);
	}
	
	public List<InstalacionDisplayDTO> getnLicencia(String numLicencia) {
		String sql = "SELECT idLicencia from licencia where numLicencia=?";
		return db.executeQueryPojo(InstalacionDisplayDTO.class, sql);
	}
	
	public List<LicenciaDisplayDTO> getLicencias() {
		String sql = "SELECT numLicencia from licencia";
		return db.executeQueryPojo(LicenciaDisplayDTO.class, sql);
	}
	
	public List<Object[]> getSocio(String nombre, String apellido1, String apellido2) {
		// TODO Auto-generated method stub
		String sql = "SELECT idSocio from socio where nombreSocio=? AND apellido1socio=? AND apellido2socio=?";
		return db.executeQueryArray(sql, nombre, apellido1, apellido2);
	}

}

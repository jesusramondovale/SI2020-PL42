package giis.demo.proyectoClub.model;

import java.sql.Date;
import java.util.List;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.proyectoClub.DTO.LicenciaDisplayDTO;
import giis.demo.proyectoClub.DTO.SocioDisplayDTO;
import giis.demo.util.Database;
import giis.demo.util.Util;

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
	
	public List<Object[]> getReservasInstalacion(String instalacion, java.util.Date fecha, String hinicio){
		String sql = "SELECT instalacion from reservas where instalacion=? AND fechaReserva=? AND horaInicio=?";
		return db.executeQueryArray(sql, instalacion, fecha, hinicio);
	}
	
	public List<SocioDisplayDTO> getFechaNac(String numLicencia){
		String sql = "SELECT fechaNacimiento FROM socio WHERE numLicencia=?";
		return db.executeQueryPojo(SocioDisplayDTO.class, sql, numLicencia);
	}
	
	public List<SocioDisplayDTO> getGrupos(){
		String sql = "SELECT grupoBurbuja FROM socio GROUP BY grupoBurbuja HAVING COUNT (*) >= 1";
		return db.executeQueryPojo(SocioDisplayDTO.class, sql);
	}
	
	public List<SocioDisplayDTO> getLicenciaGrupo(){
		String sql = "SELECT numlicencia FROM socio GROUP BY numlicencia HAVING COUNT(grupoburbuja) >= 1";
		return db.executeQueryPojo(SocioDisplayDTO.class, sql);
	}
	
	public List<SocioDisplayDTO> getSociosGrupo(int grupoBurbuja){
		String sql = "SELECT idSocio FROM socio WHERE grupoBurbuja=?";
		return db.executeQueryPojo(SocioDisplayDTO.class, sql, grupoBurbuja);
	}
	
	public void addReserva(int idSocio, String instalacion, java.util.Date fecha, String hinicio, String hfin) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO reservas (idSocio, instalacion, fechaReserva, horaInicio, horaFin) values (?,?,?,?,?)";
		String fechaInicio = Util.dateToIsoString(fecha);
		db.executeUpdate(sql, idSocio, instalacion, fechaInicio, hinicio, hfin);
	}

}

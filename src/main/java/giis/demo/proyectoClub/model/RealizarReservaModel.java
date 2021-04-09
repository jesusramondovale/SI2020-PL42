package giis.demo.proyectoClub.model;

import java.sql.Date;
import java.util.List;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class RealizarReservaModel {
	
	public Database db = new Database();

	public List<InstalacionDisplayDTO> getInstalacion() {
		// TODO Auto-generated method stub
		String sql= "SELECT nombreInstalacion from instalacion";
		return db.executeQueryPojo(InstalacionDisplayDTO.class, sql);
	}

	public Object getNLicencia(String nlicencia) {
		// TODO Auto-generated method stub
		String sql = "SELECT numLicencia from licencia where numLicencia=?";
		return db.executeQueryArray(sql, nlicencia);
	}

	public Object getNombApe(String nombre, String apellido1, String apellido2) {
		// TODO Auto-generated method stub
		String sql = "SELECT nombreSocio from socio where nombreSocio=? AND apellido1socio=? AND apellido2socio=?";
		return db.executeQueryArray(sql, nombre, apellido1, apellido2);
	}

	public void addReserva(int idSocio, String instalacion, java.util.Date fecha, String hinicio, String hfin) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO reservas (idSocio, instalacion, fechaReserva, horaInicio, horaFin) values (?,?,?,?,?)";
		String fechaInicio = Util.dateToIsoString(fecha);
		db.executeUpdate(sql, idSocio, instalacion, fecha, hinicio, hfin);
	}

	public List<Object[]> obtenerSocio(String nombre, String apellido1, String apellido2) {
		// TODO Auto-generated method stub
		String sql = "SELECT idSocio from socio where nombreSocio=? AND apellido1socio=? AND apellido2socio=?";
		return db.executeQueryArray(sql, nombre, apellido1, apellido2);
	}

}

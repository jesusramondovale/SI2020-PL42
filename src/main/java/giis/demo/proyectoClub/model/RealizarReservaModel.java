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
		String sql = "SELECT nLicencia from licencia where nLicencia LIKE nlicencia";
		return db.executeQueryArray(sql, nlicencia);
	}

	public Object getNombApe(String nombre, String apellido1, String apellido2) {
		// TODO Auto-generated method stub
		String sql = "SELECT nombre from socio where nombreSocio LIKE nombre AND apellido1socio LIKE apellido1 AND apellido2socio LIKE apellido2";
		return db.executeQueryArray(sql, nombre, apellido1, apellido2);
	}

	public void addReserva(int idSocio, String instalacion, java.util.Date fecha, float hinicio, float hfin) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO reserva (idSocio, instalacion, fechaReserva, horaInicio, horaFin) values (?,?,?,?,?)";
		String fechaInicio = Util.dateToIsoString(fecha);
		db.executeUpdate(sql, idSocio, instalacion, fecha, hinicio, hfin);
	}

	public int obtenerSocio() {
		// TODO Auto-generated method stub
		String sql = "SELECT idSocio from socio where nombreSocio LIKE nombre AND apellido1socio LIKE apellido1 AND apellido2socio LIKE apellido2";
		return Integer.parseInt(sql);
	}

}

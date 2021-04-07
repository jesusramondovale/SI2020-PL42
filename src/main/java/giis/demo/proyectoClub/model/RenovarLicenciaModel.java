package giis.demo.proyectoClub.model;

import giis.demo.util.Database;

public class RenovarLicenciaModel {
	
	private Database db=new Database();
	
	/**
	 * Actualiza el estado de la licencia
	 */
	public void updateEstadoLicencia(String numLicencia) {
		String sql="UPDATE licencia SET estadoLicencia='Pendiente de pago' WHERE numLicencia=?";
		db.executeUpdate(sql, numLicencia);
	}

}

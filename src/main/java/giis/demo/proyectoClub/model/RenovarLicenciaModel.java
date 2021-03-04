package giis.demo.proyectoClub.model;

import java.util.Date;

import giis.demo.util.Database;
import giis.demo.util.Util;

public class RenovarLicenciaModel {
	
	private Database db=new Database();
	
	/**
	 * Actualiza el estado de la licencia
	 */
	public void updateEstadoLicencia(String numLicencia) {
		String sql="UPDATE licencia SET estado='Pendiente de pago' WHERE numLicencia=?";
		db.executeUpdate(sql, numLicencia);
	}

}

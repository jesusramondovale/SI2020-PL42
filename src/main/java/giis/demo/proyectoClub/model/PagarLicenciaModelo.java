package giis.demo.proyectoClub.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import giis.demo.util.Util;
import giis.demo.proyectoClub.DTO.LicenciaDTO;
import giis.demo.proyectoClub.DTO.SocioDTO;
import giis.demo.proyectoClub.DTO.TecnicoDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
/**
 * Acceso a los datos de carreras e inscripciones, 
 * utilizado como modelo para el ejemplo de swing y para las pruebas unitarias y de interfaz de usuario.
 * 
 * <br/>En los metodos de este ejemplo toda la logica de negocio se realiza mediante una unica query sql por lo que siempre
 * se utilizan los metodos de utilidad en la clase Database que usan apache commons-dbutils y controlan la conexion. 
 * En caso de que en un mismo metodo se realicen diferentes queries se deberia controlar la conexion desde esta clase 
 * (ver como ejemplo la implementacion en Database).
 * 
 * <br/>Si utilizase algún otro framework para manejar la persistencia, la funcionalidad proporcionada por esta clase sería la asignada
 * a los Servicios, Repositorios y DAOs.
 */
public class PagarLicenciaModelo {
	

	private Database db=new Database();
	
	
	
	
	public void pagarLicencia(LicenciaDTO lic) {
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;
		String sql= "UPDATE Licencia SET estadoLicencia=? WHERE numLicencia=?";
				
		try {
			dbConnection=db.getConnection();
			preparedStatement=dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, "Pagada");
			preparedStatement.setString(2, lic.getLicencia());
			
			preparedStatement.executeUpdate();
			
			dbConnection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
	}
	
	
	
}

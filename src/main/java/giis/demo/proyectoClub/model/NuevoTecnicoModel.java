package giis.demo.proyectoClub.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import giis.demo.util.Util;
import giis.demo.proyectoClub.DTO.LicenciaDTO;
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
public class NuevoTecnicoModel {
	

	private Database db=new Database();
	
	public void nuevoTecnico(TecnicoDTO tec) {
		
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;
		
		String sql= "Insert INTO tecnico (idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia,numCuenta,cuota)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			dbConnection=db.getConnection();
			preparedStatement=dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, tec.getIdTecnico());
			preparedStatement.setString(2, tec.getDniTecnico());
			preparedStatement.setString(3, tec.getNombreTecnico());
			preparedStatement.setString(4, tec.getApellido1Tecnico());
			preparedStatement.setString(5, tec.getApellido2Tecnico());
			preparedStatement.setString(6, tec.getLicenciaTecnico());
			preparedStatement.setString(7, tec.getNumeroCuenta());
			preparedStatement.setFloat(8, tec.getCuota());
			preparedStatement.executeUpdate();
			
			dbConnection.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void nuevaLicencia(LicenciaDTO lic) {
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;
		String sql= "Insert INTO Licencia (idLicencia,numLicencia,estadoLicencia)"
				+ "VALUES (?,?,?)";
		try {
			dbConnection=db.getConnection();
			preparedStatement=dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, lic.getIdLicencia());
			preparedStatement.setString(2, lic.getLicencia());
			preparedStatement.setString(3, lic.getEstado());
			preparedStatement.executeUpdate();
			
			dbConnection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
	}
	
	
	


	
	
	
	
	public int NextID(String id_buscar,  String tabla) {
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;		
		int id = -1;
		String sql ="SELECT MAX("+id_buscar+") FROM "+tabla ;
		
		try {
			dbConnection = db.getConnection();
			preparedStatement=dbConnection.prepareStatement(sql);	
			ResultSet rs = preparedStatement.executeQuery();
			id = rs.getInt(1);
				
			rs.close();
			dbConnection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
				
		}
		return id+1;	
	}	
	
}

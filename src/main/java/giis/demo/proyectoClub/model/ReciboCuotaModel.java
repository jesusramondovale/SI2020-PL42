package giis.demo.proyectoClub.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import giis.demo.proyectoClub.DTO.ReciboDisplayDTO;
import giis.demo.proyectoClub.DTO.SociosDisplayDTO;
import giis.demo.util.Database;

public class ReciboCuotaModel {
	
	private Database db = new Database();
	ArrayList lista= new ArrayList();
	
	public List<SociosDisplayDTO> getSocios() {
		String sql = "SELECT idSocio FROM socio";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql);
	}

	public List<Object[]> getNombreSocio(int idSocio) {
		String sql = "SELECT nombreSocio FROM socio WHERE idSocio=?";
		return db.executeQueryArray(sql, idSocio);
	}

	public List<Object[]> getApe1Socio(int idSocio) {
		String sql = "SELECT apellido1Socio FROM socio WHERE idSocio=?";
		return db.executeQueryArray(sql, idSocio);	
	}

	public List<Object[]> getApe2Socio(int idSocio) {
		String sql = "SELECT apellido2Socio FROM socio WHERE idSocio=?";
		return db.executeQueryArray(sql, idSocio);
	}

	public List<Object[]> getCuota(int idSocio) {
		String sql = "SELECT cuota FROM socio WHERE idSocio=?";
		return db.executeQueryArray(sql, idSocio);
	}

	public List<Object[]> getNumCuentaSocio(int idSocio) {
		String sql = "SELECT numCuenta FROM socio WHERE idSocio=?";
		return db.executeQueryArray(sql, idSocio);
	}

	public void addRecibo(String nRecibo, String fValor, String fEmision, String concepto, String importe, String socio,
			String numCuenta) {
		String sql = "INSERT INTO recibos (nRecibo, fechaValor, fechaEmision, concepto, importe, socio, numCuenta) values (?,?,?,?,?)";
		db.executeUpdate(sql, nRecibo, fValor, fEmision, concepto, importe, socio, numCuenta);
	}
	
	public ArrayList getFechaEmision(){
		
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;
		
		String sql = "Select fechaEmision FROM recibos";
		try {
			dbConnection=db.getConnection();
			preparedStatement=dbConnection.prepareStatement(sql);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {
				String fecha= result.getString("fechaEmision");
				ReciboDisplayDTO r = new ReciboDisplayDTO(fecha);
				lista.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}

}

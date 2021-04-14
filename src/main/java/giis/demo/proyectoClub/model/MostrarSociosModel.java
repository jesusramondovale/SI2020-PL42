package giis.demo.proyectoClub.model;


import java.util.List;

import giis.demo.proyectoClub.DTO.MostrarSociosDTO;
import giis.demo.util.Database;


public class MostrarSociosModel {

	private Database db=new Database();
	private static String SQL = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "WHERE nombreSocio=? "
			+ "AND apellido1Socio=? "
			+ "AND numLicencia >=? "
			+ "AND numLicencia <=?" ;

	private static String SQL_NOMBRE = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "WHERE nombreSocio=? "
			+ "AND apellido1Socio=? "
			+ "AND numLicencia >=? "
			+ "AND numLicencia <=? "
			+ "ORDER BY nombreSocio" ;

	private static String SQL_NUM = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "WHERE nombreSocio=? "
			+ "AND apellido1Socio=? "
			+ "AND numLicencia >=? "
			+ "AND numLicencia <=? "
			+ "ORDER BY numLicencia" ;

	private static String SQL_APELLIDO = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "WHERE nombreSocio=? "
			+ "AND apellido1Socio=? "
			+ "AND numLicencia >=? "
			+ "AND numLicencia <=? "
			+ "ORDER BY apellido1Socio" ;


	private static String SQLB = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio ";

	private static String SQLB_NUM = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "ORDER BY numLicencia";

	private static String SQLB_NOMBRE = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "ORDER BY nombreSocio";

	private static String SQLB_APELLIDO = "SELECT idSocio, dniSocio, numLicencia , nombreSocio , apellido1Socio "
			+ "FROM socio "
			+ "ORDER BY apellido1Socio";

	public List<MostrarSociosDTO> getListaSocios(String nombre, String apellido1, int r1, int r2){
		return db.executeQueryPojo(MostrarSociosDTO.class,SQL, nombre, apellido1, r1,r2);
	}

	public List<MostrarSociosDTO> getListaSociosTrasBorrado(){
		return db.executeQueryPojo(MostrarSociosDTO.class,SQLB);
	}

	public List<MostrarSociosDTO> getListaSociosTrasBorradoNumero(){
		return db.executeQueryPojo(MostrarSociosDTO.class,SQLB_NUM);
	}

	public List<MostrarSociosDTO> getListaSociosTrasBorradoNombre(){
		return db.executeQueryPojo(MostrarSociosDTO.class,SQLB_NOMBRE);
	}

	public List<MostrarSociosDTO> getListaSociosTrasBorradoApellido(){
		return db.executeQueryPojo(MostrarSociosDTO.class,SQLB_APELLIDO);
	}
	
	public List<MostrarSociosDTO> getListaSociosNumero(String nombre, String apellido1, int r1, int r2) {
		return db.executeQueryPojo(MostrarSociosDTO.class,SQL_NUM, nombre, apellido1, r1,r2);
	}

	public List<MostrarSociosDTO> getListaSociosNombre(String nombre, String apellido1, int r1, int r2) {
		return db.executeQueryPojo(MostrarSociosDTO.class,SQL_NOMBRE, nombre, apellido1, r1,r2);
	}

	public List<MostrarSociosDTO> getListaSociosApellido(String nombre, String apellido1, int r1, int r2) {
		return db.executeQueryPojo(MostrarSociosDTO.class,SQL_APELLIDO, nombre, apellido1, r1,r2);
	}


}

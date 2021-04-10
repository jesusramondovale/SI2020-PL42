package giis.demo.proyectoClub.model;

import java.util.List;

import giis.demo.proyectoClub.DTO.ReciboDisplayDTO;
import giis.demo.proyectoClub.DTO.SociosDisplayDTO;
import giis.demo.util.Database;

public class ReciboCuotaModel {
	
	private Database db = new Database();
	
	public List<SociosDisplayDTO> getSocios() {
		String sql = "SELECT idSocio FROM socio";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql);
	}

	public List<SociosDisplayDTO> getNombreSocio(int idSocio) {
		String sql = "SELECT socio.nombreSocio as nombre FROM socio WHERE idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql, idSocio);
	}

	public List<SociosDisplayDTO> getApe1Socio(int idSocio) {
		String sql = "SELECT socio.apellido1Socio as apellido1 FROM socio WHERE idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql, idSocio);
	}

	public List<SociosDisplayDTO> getApe2Socio(int idSocio) {
		String sql = "SELECT socio.apellido2Socio as apellido2 FROM socio WHERE idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql, idSocio);
	}

	public List<SociosDisplayDTO> getCuota(int idSocio) {
		String sql = "SELECT socio.cuota as cuota FROM socio WHERE idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql, idSocio);
	}

	public List<SociosDisplayDTO> getNumCuentaSocio(int idSocio) {
		String sql = "SELECT socio.numCuentaSocio as numCuenta FROM socio WHERE idSocio=?";
		return db.executeQueryPojo(SociosDisplayDTO.class, sql, idSocio);
	}
	
	public List<ReciboDisplayDTO> getRecibos() {
		String sql = "SELECT * FROM recibo";
		return db.executeQueryPojo(ReciboDisplayDTO.class, sql);
	}

	public List<ReciboDisplayDTO> getNRecibo(int idRecibo) {
		String sql = "SELECT recibo.numRecibo as nRecibo FROM recibo WHERE idRecibo=?";
		return db.executeQueryPojo(ReciboDisplayDTO.class, sql, idRecibo);
	}

	public List<ReciboDisplayDTO> getFechaV(int idRecibo) {
		String sql = "SELECT recibo.fechaV as fechaV FROM recibo WHERE idRecibo=?";
		return db.executeQueryPojo(ReciboDisplayDTO.class, sql, idRecibo);
	}

	public List<ReciboDisplayDTO> getFechaE(int idRecibo) {
		String sql = "SELECT recibo.fechaE as fechaE FROM recibo WHERE idRecibo=?";
		return db.executeQueryPojo(ReciboDisplayDTO.class, sql, idRecibo);
	}

	public List<ReciboDisplayDTO> getConcepto(int idRecibo) {
		String sql = "SELECT recibo.concepto as concepto FROM recibo WHERE idRecibo=?";
		return db.executeQueryPojo(ReciboDisplayDTO.class, sql, idRecibo);
	}

	public void addRecibo(String nRecibo, String fValor, String fEmision, String concepto, String importe, String socio,
			String numCuenta) {
		String sql = "INSERT INTO recibo (nRecibo, fechaValor, fechaEmision, concepto, importe, socio, numCuenta) values (?,?,?,?,?)";
		db.executeUpdate(sql, nRecibo, fValor, fEmision, concepto, importe, socio, numCuenta);
	}

}

package giis.demo.ProyectoClub.DTO;

import java.sql.Date;

public class MostrarInstalacionesDTO {

	private String tipo;
	private Date fecha;
	private String horaIni ;
	private String horaFin ;
	
	public MostrarInstalacionesDTO(){}
	public MostrarInstalacionesDTO(String tipo, Date fecha, String horaIni, String horaFin){
		this.fecha = fecha;
		this.tipo = tipo;
		this.horaIni = horaIni;
		this.horaFin = horaFin;
		
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}
	
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
}

package giis.demo.ProyectoClub.DTO;

import java.sql.Date;
import java.sql.Time;

public class MostrarInstalacionesDTO {

	private String tipo;
	private Date fecha;
	private Time horaIni ;
	private Time horaFin ;
	
	public MostrarInstalacionesDTO(){}
	public MostrarInstalacionesDTO(String tipo, Date fecha, Time horaIni, Time horaFin){
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
	
	public Time getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(Time horaIni) {
		this.horaIni = horaIni;
	}
	
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
}

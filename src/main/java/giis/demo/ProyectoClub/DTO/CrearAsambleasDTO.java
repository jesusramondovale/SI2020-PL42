package giis.demo.ProyectoClub.DTO;

import java.sql.Time;
import java.util.Date;

public class CrearAsambleasDTO {

	private int idAsamblea;
	private String tipo;
	private String ordenDia;
	private Date fechaAsamblea;
	private Time hora1;
	private Time hora2;
	
	public void CrearAsambleaDTO(){
	}
	
	public CrearAsambleasDTO(int id, String tipo, String ordenDia, Date fecha, Time hora1, Time hora2){
		this.setIdAsamblea(id);
		this.fechaAsamblea = fecha;
		this.tipo = tipo;
		this.hora1 = hora1;
		this.hora2 = hora2;
		this.ordenDia = ordenDia;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOrdenDia() {
		return ordenDia;
	}
	public void setOrdenDia(String ordenDia) {
		this.ordenDia = ordenDia;
	}
	public Date getFecha() {
		return fechaAsamblea;
	}
	public void setFecha(Date fecha) {
		this.fechaAsamblea = fecha;
	}
	public Time getHora_1() {
		return hora1;
	}
	public void setHora_1(Time hora_1) {
		this.hora1 = hora_1;
	}
	public Time getHora_2() {
		return hora2;
	}
	public void setHora_2(Time hora_2) {
		this.hora2 = hora_2;
	}

	public int getIdAsamblea() {
		return idAsamblea;
	}

	public void setIdAsamblea(int idAsamblea) {
		this.idAsamblea = idAsamblea;
	}
	
}

package giis.demo.proyectoClub.Model;

import java.sql.Time;
import java.util.Date;

public class GenerarActaDTO {

	private static int MAX_PROPUESTAS = 25;
	
	private int idAsamblea;
	private String tipo;
	private String ordenDia;
	private Date fechaAsamblea;
	private Time hora1;
	private Time hora2;
	
	private String[] propuestas;


	public GenerarActaDTO(int idAsamblea, String tipo, String ordenDia, Date fechaAsamblea, Time hora1, Time hora2,
			String[] propuestas) {
		super();
		this.idAsamblea = idAsamblea;
		this.tipo = tipo;
		this.ordenDia = ordenDia;
		this.fechaAsamblea = fechaAsamblea;
		this.hora1 = hora1;
		this.hora2 = hora2;
		this.propuestas = propuestas;
	}

	
	
	public GenerarActaDTO(int idAsamblea, String ordenDia, String[] propuestas) {
		super();
		this.idAsamblea = idAsamblea;
		this.ordenDia = ordenDia;
		this.propuestas = propuestas;
	}



	public int getIdAsamblea() {
		return idAsamblea;
	}

	public void setIdAsamblea(int idAsamblea) {
		this.idAsamblea = idAsamblea;
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

	public Date getFechaAsamblea() {
		return fechaAsamblea;
	}

	public void setFechaAsamblea(Date fechaAsamblea) {
		this.fechaAsamblea = fechaAsamblea;
	}

	public Time getHora1() {
		return hora1;
	}

	public void setHora1(Time hora1) {
		this.hora1 = hora1;
	}

	public Time getHora2() {
		return hora2;
	}

	public void setHora2(Time hora2) {
		this.hora2 = hora2;
	}

	public String[] getPropuestas() {
		return propuestas;
	}

	public void setPropuestas(String[] propuestas) {
		this.propuestas = propuestas;
	}
	
	public String MostrarPropuesta(int i){
		
		return this.propuestas[i];
		
	}
	
	
	
}

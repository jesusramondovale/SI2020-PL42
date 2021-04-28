package giis.demo.proyectoClub.DTO;


import java.util.Date;
import java.util.Map;




public class GenerarActaDTO {

	private static int MAX_PROPUESTAS = 25;
	
	private int idAsamblea;
	private String tipo;
	private String ordenDia;
	private Date fechaAsamblea;
	private String hora1;
	private String hora2;
	
	private Map<String, int[]> propuestas;

	
	
	
	public GenerarActaDTO() {
		super();
	}
	
	

	public GenerarActaDTO(int idAsamblea, String tipo, String ordenDia, Date fechaAsamblea, String hora1, String hora2,
			Map<String, int[]> propuestas) {
		super();
		this.idAsamblea = idAsamblea;
		this.tipo = tipo;
		this.ordenDia = ordenDia;
		this.fechaAsamblea = fechaAsamblea;
		this.hora1 = hora1;
		this.hora2 = hora2;
		this.propuestas = propuestas;
	}

	public GenerarActaDTO(int idAsamblea, String ordenDia, Map<String, int[]> propuestas) {
		super();
		this.idAsamblea = idAsamblea;
		this.ordenDia = ordenDia;
		this.propuestas = propuestas;
	}

	public static int getMAX_PROPUESTAS() {
		return MAX_PROPUESTAS;
	}

	public static void setMAX_PROPUESTAS(int mAX_PROPUESTAS) {
		MAX_PROPUESTAS = mAX_PROPUESTAS;
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

	public String getHora1() {
		return hora1;
	}

	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}

	public String getHora2() {
		return hora2;
	}

	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}

	public Map<String, int[]> getPropuestas() {
		return propuestas;
	}

	public void setPropuestas(Map<String, int[]> propuestas) {
		this.propuestas = propuestas;
	}

	

	
	
	
}

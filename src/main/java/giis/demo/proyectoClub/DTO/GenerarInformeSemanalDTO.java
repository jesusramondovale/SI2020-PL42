package giis.demo.proyectoClub.DTO;



public class GenerarInformeSemanalDTO {

	private String idSocio;
	private String correo;
	private String horaIni;
	private String horaFin;
	private int grupoBurbuja;


	public GenerarInformeSemanalDTO(String idSocio, String correo, String fechaIni, String fechaFin, int grupo) {
		super();
		this.idSocio = idSocio;
		this.correo = correo;
		this.horaIni = fechaIni;
		this.horaFin = fechaFin;
		this.setGrupoBurbuja(grupo);
	}

	
	
	public GenerarInformeSemanalDTO(String correo) {
		super();
		this.correo = correo;
	}



	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String Ini) {
		this.horaIni = Ini;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String Fin) {
		this.horaFin = Fin;
	}

	public int getGrupoBurbuja() {
		return grupoBurbuja;
	}

	public void setGrupoBurbuja(int grupoBurbuja) {
		this.grupoBurbuja = grupoBurbuja;
	} 




}

package giis.demo.proyectoClub.DTO;



public class GenerarInformeSemanalDTO {

	private int idSocio;
	private int grupoBurbuja;
	private String correo;
	private String horaIni;
	private String horaFin;
	


	public GenerarInformeSemanalDTO(int idSocio, String correo, String fechaIni, String fechaFin, int grupo) {
		
		super();
		this.idSocio = idSocio;
		this.setGrupoBurbuja(grupo);
		this.correo = correo;
		this.horaIni = fechaIni;
		this.horaFin = fechaFin;
		
	}

	
	
	public GenerarInformeSemanalDTO(int grupo,String correo) {
		super();
		this.grupoBurbuja = grupo;
		this.correo = correo;
	}



	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
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

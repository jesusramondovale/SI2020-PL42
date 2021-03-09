package giis.demo.proyectoClub.DTO;

public class SociosDisplayDTO {
	
	private String nombreSocio;
	private int idSocio;
	private String apellido1Socio;
	private String apellido2Socio;
	private float cuota;
	private String numCuentaSocio;

	public SociosDisplayDTO(String rowNombreSocio, int idUsuario, String rowApellido1Socio, String rowApellido2Socio, float rowCuota, String rowNumCuentaSocio){
		this.nombreSocio = rowNombreSocio;
		this.idSocio = idUsuario;
		this.apellido1Socio = rowApellido1Socio;
		this.apellido2Socio = rowApellido2Socio;
		this.cuota = rowCuota;
		this.numCuentaSocio = rowNumCuentaSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}
	
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	
	public int getIdSocio() {
		return idSocio;
	}

	public String getApellido1Socio() {
		return apellido1Socio;
	}

	public void setApellido1Socio(String apellido1Socio) {
		this.apellido1Socio = apellido1Socio;
	}

	public String getApellido2Socio() {
		return apellido2Socio;
	}

	public void setApellido2Socio(String apellido2Socio) {
		this.apellido2Socio = apellido2Socio;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	public String getNumCuentaSocio() {
		return numCuentaSocio;
	}

	public void setNumCuentaSocio(String numCuentaSocio) {
		this.numCuentaSocio = numCuentaSocio;
	}


	



	
	

}

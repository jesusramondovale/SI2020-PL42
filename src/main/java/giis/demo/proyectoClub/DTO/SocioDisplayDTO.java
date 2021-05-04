package giis.demo.proyectoClub.DTO;

public class SocioDisplayDTO {

	private int idSocio;
	private String nombreSocio;
	private String apellido1Socio;
	private String apellido2Socio;
	private float cuota;
	private String numCuentaSocio;
	private String numLicencia;
	private String fechaNacimiento;
	private int grupoBurbuja;

	public SocioDisplayDTO() {}
	public SocioDisplayDTO(int rowIdSocio, String rowNombreSocio, String rowApellido1Socio, 
			String rowApellido2Socio, float rowCuota, String rowNumCuentaSocio, String rowNumLicencia, 
			String rowFechaNacimiento, int rowGrupoBurbuja){
		this.idSocio = rowIdSocio;
		this.nombreSocio = rowNombreSocio;
		this.apellido1Socio = rowApellido1Socio;
		this.apellido2Socio = rowApellido2Socio;
		this.cuota = rowCuota;
		this.numCuentaSocio = rowNumCuentaSocio;
		this.numLicencia = rowNumLicencia;
		this.fechaNacimiento = rowFechaNacimiento;
		this.grupoBurbuja = rowGrupoBurbuja;
	}

	public int getIdSocio() {
		return this.idSocio;
	}

	public String getNombreSocio() {
		return this.nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getApellido1Socio() {
		return this.apellido1Socio;
	}

	public void setApellido1Socio(String apellido1Socio) {
		this.apellido1Socio = apellido1Socio;
	}

	public String getApellido2Socio() {
		return this.apellido2Socio;
	}

	public void setApellido2Socio(String apellido2Socio) {
		this.apellido2Socio = apellido2Socio;
	}

	public float getCuota() {
		return this.cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	public String getNumCuentaSocio() {
		return this.numCuentaSocio;
	}

	public void setNumCuentaSocio(String numCuentaSocio) {
		this.numCuentaSocio = numCuentaSocio;
	}

	public String getNumLicencia() {
		return this.numLicencia;
	}
	
	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getGrupoBurbuja() {
		return this.grupoBurbuja;
	}
	
	public void setGrupoBurbuja(int grupoBurbuja) {
		this.grupoBurbuja = grupoBurbuja;
	}

}

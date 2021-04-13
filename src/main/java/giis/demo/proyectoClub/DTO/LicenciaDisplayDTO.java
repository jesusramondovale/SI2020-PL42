package giis.demo.proyectoClub.DTO;

public class LicenciaDisplayDTO {
	
	private int idLicencia;
	private String numLicencia;
	private float precio;
	private String estadoLicencia;
	
	public LicenciaDisplayDTO() {}
	public LicenciaDisplayDTO(int idLicencia, String numLicencia, String estadoLicencia, float precio) {
		this.idLicencia = idLicencia;
		this.numLicencia = numLicencia;
		this.precio = precio;
		this.estadoLicencia = estadoLicencia;
	}

	public int getIdLicencia() {
		return idLicencia;
	}

	public void setIdLicencia(int idLicencia) {
		this.idLicencia = idLicencia;
	}

	public String getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getEstadoLicencia() {
		return estadoLicencia;
	}
	
	public void setEstadoLicencia(String estadoLicencia) {
		this.estadoLicencia = estadoLicencia;
	}
	
	
}

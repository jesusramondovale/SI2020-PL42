package giis.demo.proyectoClub.DTO;

public class LicenciaDTO {
	private int idLicencia;
	private String Licencia;
	private String estado;
	
	public LicenciaDTO(int idLicencia, String licencia, String estado) {
		super();
		this.idLicencia = idLicencia;
		Licencia = licencia;
		this.estado = estado;
	}

	public int getIdLicencia() {
		return idLicencia;
	}

	public void setIdLicencia(int idLicencia) {
		this.idLicencia = idLicencia;
	}

	public String getLicencia() {
		return Licencia;
	}

	public void setLicencia(String licencia) {
		Licencia = licencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}

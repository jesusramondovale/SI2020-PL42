package giis.demo.proyectoClub.DTO;

public class TecnicoDTO {
	private int idTecnico;
	private String nombreTecnico;
	private String dniTecnico;
	private String licenciaTecnico;
	public TecnicoDTO(int idTecnico, String nombreTecnico, String dniTecnico, String licenciaTecnico) {
		super();
		this.idTecnico = idTecnico;
		this.nombreTecnico = nombreTecnico;
		this.dniTecnico = dniTecnico;
		this.licenciaTecnico = licenciaTecnico;
	}
	public int getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	public String getNombreTecnico() {
		return nombreTecnico;
	}
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}
	public String getDniTecnico() {
		return dniTecnico;
	}
	public void setDniTecnico(String dniTecnico) {
		this.dniTecnico = dniTecnico;
	}
	public String getLicenciaTecnico() {
		return licenciaTecnico;
	}
	public void setLicenciaTecnico(String licenciaTecnico) {
		this.licenciaTecnico = licenciaTecnico;
	}
	
	
	

}

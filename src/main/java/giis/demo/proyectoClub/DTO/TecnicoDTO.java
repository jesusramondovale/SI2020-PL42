package giis.demo.proyectoClub.DTO;

public class TecnicoDTO {
	private int idTecnico;
	private String nombreTecnico;
	private String dniTecnico;
	private String apellido1Tecnico;
	private String apellido2Tecnico;
	private String licenciaTecnico;
	private String numeroCuenta;
	private float cuota;
	public TecnicoDTO(int idTecnico, String dniTecnico, String nombreTecnico,String apellido1Tecnico,String apellido2Tecnico ,String licenciaTecnico,String numeroCuenta,float cuota) {
		super();
		this.idTecnico = idTecnico;
		this.nombreTecnico = nombreTecnico;
		this.dniTecnico = dniTecnico;
		this.apellido1Tecnico=apellido1Tecnico;
		this.apellido2Tecnico=apellido2Tecnico;
		this.licenciaTecnico = licenciaTecnico;
		this.numeroCuenta=numeroCuenta;
		this.cuota=cuota;
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
	public String getApellido1Tecnico() {
		return apellido1Tecnico;
	}
	public void setApellido1Tecnico(String apellido1Tecnico) {
		this.apellido1Tecnico = apellido1Tecnico;
	}
	public String getApellido2Tecnico() {
		return apellido2Tecnico;
	}
	public void setApellido2Tecnico(String apellido2Tecnico) {
		this.apellido2Tecnico = apellido2Tecnico;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public float getCuota() {
		return cuota;
	}
	public void setCuota(float cuota) {
		this.cuota = cuota;
	}
	
	
	

}

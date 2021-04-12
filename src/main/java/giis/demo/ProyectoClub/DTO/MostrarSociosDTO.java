package giis.demo.ProyectoClub.DTO;

public class MostrarSociosDTO {

	private int idSocio;
	private String dniSocio;
	private String numLicencia;
	private String nombreSocio;
	private String apellido1Socio;
	private String apellido2Socio;
	private String sexo;
	private String fechaNacimiento;
	private String club;
	private String numCuenta;
	private double cuota;
	private String dniTutor;
	private String dniTecnico;
	


	public MostrarSociosDTO() {	}
	
	public MostrarSociosDTO(int idSocio, String dniSocio, String numLicencia, String nombreSocio, String apellidoSocio1,
			String apellidoSocio2, String sexo, String club, String fechaNacimiento, 
			String numCuenta, String dniTutor, String dniTecnico, double cuota) {
		super();
		this.idSocio = idSocio;
		this.dniSocio = dniSocio;
		this.numLicencia = numLicencia;
		this.nombreSocio = nombreSocio;
		this.apellido1Socio = apellidoSocio1;
		this.apellido2Socio = apellidoSocio2;
		this.sexo = sexo;
		this.club = club;
		this.fechaNacimiento = fechaNacimiento;
		this.numCuenta = numCuenta;
		this.dniTutor = dniTutor;
		this.dniTecnico = dniTecnico;
		this.cuota = cuota;
	}
	
	

	public MostrarSociosDTO(int idSocio, String dniSocio, String nombreSocio, String apellidoSocio1,
			String apellidoSocio2, String sexo, String club, String fechaNacimiento, String numLicencia,
			String numCuenta) {
		super();
		this.idSocio = idSocio;
		this.dniSocio = dniSocio;
		this.nombreSocio = nombreSocio;
		this.apellido1Socio = apellidoSocio1;
		this.apellido2Socio = apellidoSocio2;
		this.sexo = sexo;
		this.club = club;
		this.fechaNacimiento = fechaNacimiento;
		this.numLicencia = numLicencia;
		this.numCuenta = numCuenta;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getDniSocio() {
		return dniSocio;
	}

	public void setDniSocio(String dniSocio) {
		this.dniSocio = dniSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getApellidoSocio1() {
		return apellido1Socio;
	}

	public void setApellidoSocio1(String apellidoSocio1) {
		this.apellido1Socio = apellidoSocio1;
	}

	public String getApellidoSocio2() {
		return apellido2Socio;
	}

	public void setApellidoSocio2(String apellidoSocio2) {
		this.apellido2Socio = apellidoSocio2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getDniTutor() {
		return dniTutor;
	}

	public void setDniTutor(String dniTutor) {
		this.dniTutor = dniTutor;
	}

	public String getDniTecnico() {
		return dniTecnico;
	}

	public void setDniTecnico(String dniTecnico) {
		this.dniTecnico = dniTecnico;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	

	
}

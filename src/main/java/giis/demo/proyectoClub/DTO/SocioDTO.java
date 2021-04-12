package giis.demo.proyectoClub.DTO;

public class SocioDTO {
	private int idSocio;
	private String nombre;
	private String dni;
	private String fechaNacimiento;
	private String sexo;
	private String club;
	private String licencia;
	private String nombreTutor;
	private String dniTutor;
	private String dniTecnico;
	
	
	public SocioDTO(int idSocio, String nombre, String dni, String fechaNacimiento, String sexo, String club,
			String licencia, String nombreTutor,String dniTutor,String dniTecinco) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.club = club;
		this.licencia = licencia;
		this.nombreTutor = nombreTutor;
		this.dniTutor = dniTutor;
		this.dniTecnico= dniTecnico;
	}
	
	public SocioDTO(int idSocio, String nombre, String dni, String fechaNacimiento, String sexo, String club,
			String licencia,String dniTecnico) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.club = club;
		this.licencia = licencia;
		this.dniTecnico= dniTecnico;
		
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
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

	@Override
	public String toString() {
		return "SocioDTO [idSocio=" + idSocio + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", sexo=" + sexo + ", club=" + club + ", licencia=" + licencia + ", nombreTutor="
				+ nombreTutor + ", dniTutor=" + dniTutor + "]";
	}
	
	
	
	

}

package giis.demo.proyectoClub.DTO;

public class SocioDTO {
	private int idSocio;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String sexo;
	private String club;
	private String licencia;
	private String numCuenta;
	private float cuota;
	private String dniTutor;
	private String dniTecnico;
	
	
	public SocioDTO(int idSocio, String dni, String nombre,String apellido1,String apellido2, String fechaNacimiento, String sexo, String club,
			String licencia, String numCuenta,float cuota,String dniTutor,String dniTecnico) {
		super();
		this.idSocio = idSocio;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.club = club;
		this.licencia = licencia;
		this.numCuenta=numCuenta;
		this.cuota=cuota;
		this.dniTutor = dniTutor;
		this.dniTecnico= dniTecnico;
	}
	
	public SocioDTO(int idSocio, String dni, String nombre,String apellido1,String apellido2, String fechaNacimiento, String sexo, String club,
			String licencia,String numCuenta,float cuota,String dniTecnico) {
		super();
		this.idSocio = idSocio;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.club = club;
		this.licencia = licencia;
		this.numCuenta=numCuenta;
		this.cuota=cuota;
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

	

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
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
		return "SocioDTO [idSocio=" + idSocio + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", club="
				+ club + ", licencia=" + licencia + ", numCuenta=" + numCuenta + ", cuota=" + cuota + ", dniTutor="
				+ dniTutor + ", dniTecnico=" + dniTecnico + "]";
	}

	
	
	
	
	

}

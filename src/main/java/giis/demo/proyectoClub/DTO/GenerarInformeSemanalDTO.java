package giis.demo.proyectoClub.DTO;

import java.util.Date;

public class GenerarInformeSemanalDTO {

	private int idSocio;
	private String dniSocio;
	private int numLicencia;
	private String nombreSocio;
	private String apellido1Socio;
	private String apellido2Socio;
	private String sexo;
	private Date fechaNacimiento;
	private String club;
	private String fechaReserva;
	private String horaFin;
	private String horaInicio;
	private String numCuenta;
	private float cuota;
	private String dniTutor;
	private String dniTecnico;
	private int grupoBurbuja;
	private String correo;
	
	private int idReserva;
	private String instalacion;
	
	
	
	
	
	


	public GenerarInformeSemanalDTO() {
		
	}



	public GenerarInformeSemanalDTO(int idSocio, int grupoBurbuja, String correo, String fechaReserva, String horaInicio,
			String horaFin) {
		super();
		this.idSocio = idSocio;
		this.grupoBurbuja = grupoBurbuja;
		this.correo = correo;
		this.fechaReserva = fechaReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}



	public GenerarInformeSemanalDTO(int idSocio, String dniSocio, int numLicencia, String nombreSocio,
			String apellido1Socio, String apellido2Socio, String sexo, Date fechaNacimiento, String club,
			String numCuenta, float cuota, String dniTutor, String dniTecnico, int grupoBurbuja, String correo,
			String horaInicio, String horaFin) {
		super();
		this.idSocio = idSocio;
		this.dniSocio = dniSocio;
		this.numLicencia = numLicencia;
		this.nombreSocio = nombreSocio;
		this.apellido1Socio = apellido1Socio;
		this.apellido2Socio = apellido2Socio;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.club = club;
		this.numCuenta = numCuenta;
		this.cuota = cuota;
		this.dniTutor = dniTutor;
		this.dniTecnico = dniTecnico;
		this.grupoBurbuja = grupoBurbuja;
		this.correo = correo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	
	
	public GenerarInformeSemanalDTO(int idSocio, int grupoBurbuja, String correo, String horaInicio, String horaFin) {
		super();
		this.idSocio = idSocio;
		this.grupoBurbuja = grupoBurbuja;
		this.correo = correo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	
	
	

	public GenerarInformeSemanalDTO(int idSocio, String dniSocio, int numLicencia, String nombreSocio,
			String apellido1Socio, String apellido2Socio, String sexo, Date fechaNacimiento, String club,
			String numCuenta) {
		super();
		this.idSocio = idSocio;
		this.dniSocio = dniSocio;
		this.numLicencia = numLicencia;
		this.nombreSocio = nombreSocio;
		this.apellido1Socio = apellido1Socio;
		this.apellido2Socio = apellido2Socio;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.club = club;
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


	public int getNumLicencia() {
		return numLicencia;
	}


	public void setNumLicencia(int numLicencia) {
		this.numLicencia = numLicencia;
	}


	public String getNombreSocio() {
		return nombreSocio;
	}


	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
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


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
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


	public int getGrupoBurbuja() {
		return grupoBurbuja;
	}


	public void setGrupoBurbuja(int grupoBurbuja) {
		this.grupoBurbuja = grupoBurbuja;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}



	public int getIdReserva() {
		return idReserva;
	}



	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}



	public String getInstalacion() {
		return instalacion;
	}



	public void setInstalacion(String instalacion) {
		this.instalacion = instalacion;
	}



	public String getFechaReserva() {
		return fechaReserva;
	}



	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
	
	
	

	
	
	
}

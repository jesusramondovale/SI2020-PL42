package giis.demo.proyectoClub.DTO;

public class JuezDTO {
	private int idjuez;
	private String nombreJuez;
	private String dniJuez;
	private String apellido1Juez;
	private String apellido2Juez;
	private String licenciaJuez;
	private String numeroCuenta;
	private float cuota;
	public JuezDTO(int idjuez,  String dniJuez, String nombreJuez,String apellido1Juez, String apellido2Juez,
			String licenciaJuez, String numeroCuenta, float cuota) {
		super();
		this.idjuez = idjuez;
		this.nombreJuez = nombreJuez;
		this.dniJuez = dniJuez;
		this.apellido1Juez = apellido1Juez;
		this.apellido2Juez = apellido2Juez;
		this.licenciaJuez = licenciaJuez;
		this.numeroCuenta = numeroCuenta;
		this.cuota = cuota;
	}
	public int getIdjuez() {
		return idjuez;
	}
	public void setIdjuez(int idjuez) {
		this.idjuez = idjuez;
	}
	public String getNombreJuez() {
		return nombreJuez;
	}
	public void setNombreJuez(String nombreJuez) {
		this.nombreJuez = nombreJuez;
	}
	public String getDniJuez() {
		return dniJuez;
	}
	public void setDniJuez(String dniJuez) {
		this.dniJuez = dniJuez;
	}
	public String getApellido1Juez() {
		return apellido1Juez;
	}
	public void setApellido1Juez(String apellido1Juez) {
		this.apellido1Juez = apellido1Juez;
	}
	public String getApellido2Juez() {
		return apellido2Juez;
	}
	public void setApellido2Juez(String apellido2Juez) {
		this.apellido2Juez = apellido2Juez;
	}
	public String getLicenciaJuez() {
		return licenciaJuez;
	}
	public void setLicenciaJuez(String licenciaJuez) {
		this.licenciaJuez = licenciaJuez;
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
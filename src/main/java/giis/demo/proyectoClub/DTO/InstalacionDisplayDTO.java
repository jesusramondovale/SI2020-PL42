package giis.demo.proyectoClub.DTO;

public class InstalacionDisplayDTO {
	
	private int idInstalacion;
	private String nombreInstalacion;
	private String fechaReserva;
	private float horaInicioReserva;
	private float horaFinReserva;
	
	public InstalacionDisplayDTO() {}
	public InstalacionDisplayDTO(int rowIdInstalacion,String rowNombre, String rowFecha, float rowInicioReserva,float rowFinReserva) {
		this.idInstalacion=rowIdInstalacion;
		this.nombreInstalacion=rowNombre;
		this.fechaReserva=rowFecha;
		this.horaInicioReserva=rowInicioReserva;
		this.horaFinReserva=rowFinReserva;
	}
	
	public int getIdInstalacion() { return this.idInstalacion;}
	public void setIdInstalacion(int value) {this.idInstalacion=value;}
	public String getNombreInstalacion() { return this.nombreInstalacion; }
	public String getFechaReserva() { return this.fechaReserva;}
	public float getHoraInicioReserva() { return this.horaInicioReserva;}
	public float getHoraFinReserva() { return this.horaFinReserva;}
	public void setNombreInstalacion(String value) { this.nombreInstalacion=value; }
	public void setFechaReserva(String value) {this.fechaReserva=value;}
	public void setInicioReserva(float value) {this.horaInicioReserva=value;}
	public void setFinReserva(float value) {this.horaFinReserva=value;}
}

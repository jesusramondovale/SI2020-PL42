package giis.demo.ProyectoClub.DTO;




public class MostrarInstalacionesDTO {

	
	private int idReserva;
	private int idSocio;
	private String instalacion;
	private String fechaReserva;
	private String horaInicio ;
	private String horaFin ;
	
	

	public MostrarInstalacionesDTO() {}

	public MostrarInstalacionesDTO(int idReserva, int idSocio, String instalacion, String fechaReserva, String horaInicio,
			String horaFin) {
		
		this.idReserva = idReserva;
		this.idSocio = idSocio;
		this.instalacion = instalacion;
		this.fechaReserva = fechaReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	
	
	public MostrarInstalacionesDTO(int idReserva, String instalacion, String fechaReserva, String horaInicio,
			String horaFin) {
		super();
		this.idReserva = idReserva;
		this.instalacion = instalacion;
		this.fechaReserva = fechaReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public String getInstalacion() {
		return instalacion;
	}
	public void setInstalacion(String tipo) {
		this.instalacion = tipo;
	}
	
	public String getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(String fecha) {
		this.fechaReserva = fecha;
	}
	
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaIni) {
		this.horaInicio = horaIni;
	}
	
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	@Override
	public String toString() {
		return "Instalación [Tipo: " + instalacion + "Fecha=" + fechaReserva + ", Hora Ini=" + horaInicio + ", Hora Fin=" + horaFin + "]";
	}


	public int getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}


	public int getIdSocio() {
		return idSocio;
	}


	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	
	
	
	
}

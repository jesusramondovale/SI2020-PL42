package giis.demo.proyectoClub.DTO;

public class ReciboDisplayDTO {
	
	private String nRecibo;
	private String fechaV;
	private String fechaE;
	private String concepto;
	private int idRecibo;
		
	public ReciboDisplayDTO(String nRecibo, String fechaV, String fechaE, String concepto, int idRecibo) {
		this.nRecibo = nRecibo;
		this.fechaV = fechaV;
		this.fechaE = fechaE;
		this.concepto = concepto;
		this.idRecibo = idRecibo;
	}
	
	public String getnRecibo() {
		return nRecibo;
	}

	public void setnRecibo(String nRecibo) {
		this.nRecibo = nRecibo;
	}

	public String getFechaV() {
		return fechaV;
	}

	public void setFechaV(String fechaV) {
		this.fechaV = fechaV;
	}

	public String getFechaE() {
		return fechaE;
	}

	public void setFechaE(String fechaE) {
		this.fechaE = fechaE;
	}

	public int getIdRecibo() {
		return idRecibo;
	}
	
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
}

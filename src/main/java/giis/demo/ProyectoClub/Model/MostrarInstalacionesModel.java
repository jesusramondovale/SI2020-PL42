package giis.demo.ProyectoClub.Model;

import java.sql.Date;
import java.util.List;

import giis.demo.ProyectoClub.DTO.MostrarInstalacionesDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class MostrarInstalacionesModel {

	private Database db=new Database();
	private Date hoy = new Date(System.currentTimeMillis());
	
	public static final String SQL_INSTALACIONES_FECHA=
			
			"SELECT tipo,fecha,hora_ini,hora_fin"			
					+"from reserva  "
					+ "where fecha==? and tipo==?"
					+ "order by hora_ini "
					+ "limit 10";
	public static final String SQL_INSTALACIONES=
			
			 "SELECT tipo,fecha,hora_ini,hora_fin"			
						+" from reserva "
					    +" where tipo==?"
						+ "order by hora_ini "
						+ "limit 10";
	
	public static final String SQL_INSTALACIONES_BORRADO=
			"SELECT tipo,fecha,hora_ini,hora_fin"			
					+" from reserva "				    
					+ "order by hora_ini "
					+ "limit 10";
	
			
	
		
	private void validateFechaSeleccionada(Date seleccionada){
		validateCondition(seleccionada.compareTo(hoy)<=0,"La fecha seleccionada no puede ser anterior a la de hoy!");
		
	}
 
	private void validateCondition(boolean cond, String msg) {

		if (!cond){
			throw new ApplicationException(msg);
		}
		
	}

	
	public List<MostrarInstalacionesDTO> getInstalacionesTrasBorrado(){
		
		return db.executeQueryPojo(MostrarInstalacionesDTO.class, SQL_INSTALACIONES);
	}
	
	
	public List<MostrarInstalacionesDTO> getListaInstalaciones(Date fecha, String tipo){
				
		if (fecha == null){
			return db.executeQueryPojo(MostrarInstalacionesDTO.class, SQL_INSTALACIONES,tipo);
		}
		
		else {	
			validateFechaSeleccionada(fecha);
			String fechaValue=Util.dateToIsoString(fecha);
			return db.executeQueryPojo(MostrarInstalacionesDTO.class, SQL_INSTALACIONES_FECHA, fechaValue,tipo);
		}
			
		
	}


}

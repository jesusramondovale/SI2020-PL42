package giis.demo.ProyectoClub.Model;


import java.util.*;

import giis.demo.ProyectoClub.DTO.MostrarInstalacionesDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class MostrarInstalacionesModel {

	private Database db=new Database();

	//Fecha actual para comprobaciones 
	private Date hoy = new Date(System.currentTimeMillis());

	public static final String SQL_FECHA_TIPO=
			"SELECT idReserva , idSocio , instalacion , fechaReserva , horaInicio , horaFin from reservas where fechaReserva=? and instalacion=?";

	/*     "SELECT instalacion , fechaReserva , horaInicio , horaFin "			
					+" from reservas "
					+" where instalacion=? and fechaReserva=?"
					+" order by horaInicio "
					+" limit 10";
	*/
	
	public static final String SQL_TIPO=
			"SELECT idReserva, idSocio , instalacion , fechaReserva , horaInicio , horaFin from reservas where instalacion=?";
			
	/*
			"SELECT instalacion , fechaReserva , horaInicio , horaFin "			
					+" from reservas "
					+" where instalacion=?"
					+" order by horaInicio "
					+" limit 10";
	*/

	public static final String SQL_FECHA=
			"SELECT idReserva, idSocio ,instalacion , fechaReserva , horaInicio , horaFin from reservas where fechaReserva=?";
	/*		
		"SELECT instalacion , fechaReserva , horaInicio , horaFin"			
					+" from reservas "
					+" where fechaReserva=?"
					+ " order by horaInicio"
					+ " limit 10";
	*/

	
	/* Consulta para obtener las últimas 10 instalaciones disponibles 
	 * sin tener en cuenta fechas ni tipos*/
	public static final String SQL=
			"SELECT idReserva, idSocio , instalacion , fechaReserva , horaInicio , horaFin"			
					+" from reservas"				    
					+" order by horaInicio"
					+" limit 10";



	/* Compara la fecha introducida con la fecha actual para que no se pueda filtrar con fechas pasadas*/ 	
	private void validateFechaSeleccionada(Date date){
		//System.out.println("\n Fecha seleccionada : " + date.toString());
		//System.out.println("\n Fecha de hoy : " + hoy.toString());
		validateCondition(date.compareTo(hoy)>=0,"La fecha seleccionada no puede ser anterior a la de hoy!");

	}

	/* Función interna para validar condición*/
	private void validateCondition(boolean cond, String msg) {

		if (!cond){
			throw new ApplicationException(msg);
		}

	}

	/* Retorna la lista de las últimas 10 Instalaciones disponibles,
	 *  sin proporcionar una fecha ni un tipo, lo que sucede si borramos el filtro */
	public List<MostrarInstalacionesDTO> getInstalacionesTrasBorrado(){

			return db.executeQueryPojo(MostrarInstalacionesDTO.class, SQL);
	}



	/* Retorna la lista de las últimas 10 Instalaciones disponibles,
	 *  pero proporcionando una fecha y/ó un tipo concretos */

	public List<MostrarInstalacionesDTO> getListaInstalaciones(Date date, String tipo){

		// No debería entrar aquí
		if (date == null && tipo == null){ // Si por alguna razón no se suministra ni fecha ni tipo

			// Retorna lo mismo que getInstalacionesTrasBorrado()
			return db.executeQueryPojo(MostrarInstalacionesDTO.class, SQL);
		}

		else if (date == null){ // No se ha proporcionado una fecha

			// Lanza la consulta sólo pasandole como argumento el tipo seleccionado a filtrar
			return db.executeQueryPojo(MostrarInstalacionesDTO.class,SQL_TIPO, tipo);
		}
		else if (tipo == null){ // No se ha proporcionado un tipo

			// REVISAR ****************
			// Captura adecuada del valor date proporcionado 
			validateFechaSeleccionada(date);
			String fechaValue=Util.dateToIsoString(date);

			// Lanza la consulta sólo pasandole como argumento la fecha seleccionada a filtrar
			return db.executeQueryPojo(MostrarInstalacionesDTO.class,SQL_FECHA, fechaValue);
		}

		else {	// Se proporciona fecha y tipo

			// REVISAR *****************
			// Captura adecuada del valor date proporcionado 
			validateFechaSeleccionada(date);
			String fechaValue=Util.dateToIsoString(date);
			
			//System.out.println("\n Date : " + date);
			//System.out.println("\n Tipo : " + tipo);
			// Lanza la consulta pasandole como argumento tanto el tipo como la fecha seleccionados a filtrar
			return db.executeQueryPojo(MostrarInstalacionesDTO.class,SQL_FECHA_TIPO, fechaValue,tipo);
		

		}


	}


}

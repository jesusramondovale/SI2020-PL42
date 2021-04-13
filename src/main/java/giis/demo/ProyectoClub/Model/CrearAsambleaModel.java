package giis.demo.ProyectoClub.Model;

import java.util.Date;

import javax.swing.JOptionPane;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class CrearAsambleaModel {

	private Database db=new Database();
	private Date hoy = new Date(System.currentTimeMillis());
	
	public void generarAsamblea(int idAsamblea, String tipo, String ordenDia, Date fechaAsamblea, String hora1, String hora2){
		
		validateFecha(fechaAsamblea);
		String SQL_ASAMBLEA= 
				"insert into asambleas (idAsamblea , tipo , ordenDia , fechaAsamblea , hora1 ,hora2)"
				+ " values"
				+" (?, ?, ?, ?, ?, ?) ";
		

		db.executeUpdate(SQL_ASAMBLEA ,idAsamblea, tipo, ordenDia, Util.dateToIsoString(fechaAsamblea), hora1, hora2);
		JOptionPane.showMessageDialog(null, "Asamblea creada con éxito!");
	
	}
	
	private void validateFecha(Date fecha){
		validateCondition(hoy.compareTo(fecha)<=0, "La fecha no puede ser anterior a la actual!");
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
	
}

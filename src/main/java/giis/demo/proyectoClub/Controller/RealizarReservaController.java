package giis.demo.proyectoClub.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

import org.apache.commons.beanutils.PropertyUtils;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.proyectoClub.View.RealizarReservaView;
import giis.demo.proyectoClub.model.RealizarReservaModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class RealizarReservaController {

	private RealizarReservaModel model;
	private RealizarReservaView view;
	private String lastSelectedKey=""; //recuerda la ultima fila seleccionada para restaurarla cuando cambie la tabla de reservas

	
	public RealizarReservaController(RealizarReservaModel m, RealizarReservaView v) {
		this.model = m;
		this.view = v;
		
		this.initView();
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		addInstalacion();
		insertarFechaReserva();
		view.setVisible(true);
		
		view.getbCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)));
		view.getbAnadir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarLicencia()));
		
		view.gettReservas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				view.getbEliminar().setEnabled(true);
			}
		});
		
		view.getbEliminar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarSeleccion()));
		view.getbReservar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reservar()));
		
		
	}

	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getRealizarReserva().setVisible(true); 
	}	

	/**
	 * Carga las instalaciones existentes de la BD en el JComboBonx
	 */
	public void addInstalacion() {
		List<InstalacionDisplayDTO> instalaciones = model.getInstalacion();
		addInstCB(instalaciones, view.getCbInstalacion(), new String("nombreInstalacion"));
	}

	/**
	 * Metodo que añade al comboBox los elementos de busqueda sql
	 */
	@SuppressWarnings("unchecked")
	public static <E> void addInstCB(List<E> pojos, JComboBox comboBox,String nombre) {
		for (int i=0;i<pojos.size();i++) {
			try {
				Object pojo=pojos.get(i);
				Object val= PropertyUtils.getSimpleProperty(pojo, nombre);
				comboBox.addItem(val);
			}catch(IllegalAccessException | InvocationTargetException|NoSuchElementException | NoSuchMethodException e) {
				throw new UnexpectedException(e);
			}			
		}
	}
	
	public void insertarFechaReserva(){
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Date fechaSistema = new Date(cal.getTimeInMillis());
		String fecha = formatter.format(fechaSistema);
		view.getCbFecha().addItem(fecha);
		
		cal.setTime(fechaSistema);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaSig = cal.getTime();
		String fecha2 = formatter.format(fechaSig);
		view.getCbFecha().addItem(fecha2);
	}
	
	public void comprobarLicencia() {
		String nlicencia = view.getTfNLicencia().getText();
		if(model.getNLicencia(nlicencia)==null) {
			JOptionPane pane = new JOptionPane("El número de licencia introducido es erróneo.", 
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
			JDialog d = pane.createDialog(pane, "Nº licencia erróneo");
			d.setLocation(200, 200);
			d.setVisible(true);
		}
		else {
			comprobarNombre();
		}
	}
	
	public void comprobarNombre() {
		String nombre = view.getTfNombre().getText();
		String apellido1 = view.getTfApellido1().getText();
		String apellido2 = view.getTfApellido2().getText();
		if(model.getNombApe(nombre,apellido1,apellido2)==null) {
			JOptionPane pane = new JOptionPane("Nombre o apellidos erroneos", 
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
			JDialog d = pane.createDialog(pane, "Error datos");
			d.setLocation(200, 200);
			d.setVisible(true);
		}
		else {
			comprobarHoraReserva();
		}
	}
	
	public void comprobarHoraReserva() {
		
		float horaInicio = (float) Double.parseDouble((String) view.getCbHInicio().getSelectedItem());
		float horaFin = (float) Double.parseDouble((String) view.getCbHFin().getSelectedItem());
		
		if(horaInicio-horaFin <= 0.0) {
			JOptionPane pane = new JOptionPane("Las horas seleccionadas son incorrectas./nPor favor, seleccione horas distintas entre sí "
					+ "o/ncompruebe que la hora de inicio sea inferior a la hora de fin.", 
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
			JDialog d = pane.createDialog(pane, "Error hora reserva");
			d.setLocation(200, 200);
			d.setVisible(true);
		}
		else {
			addReserva();
			view.getbReservar().setEnabled(true);
		}
	}
	
	public void addReserva() {
		
		DefaultTableModel m = (DefaultTableModel) view.gettReservas().getModel();
		
		Object [] datos = new Object[6];
		datos[0] = view.getTfNLicencia().getText();
		datos[1] = view.getTfNombre().getText() + " " + view.getTfApellido1() + " " + view.getTfApellido2().getText();
		datos[2] = view.getCbInstalacion().getSelectedItem().toString();
		datos[3] = view.getCbFecha().getSelectedItem().toString();
		datos[4] = view.getCbHInicio().getSelectedItem().toString();
		datos[5] = view.getCbHFin().getSelectedItem().toString();
		
		m.addRow(datos);
		view.gettReservas().setModel(m);
	}
	
	public void eliminarSeleccion() {
		DefaultTableModel m = (DefaultTableModel) view.gettReservas().getModel();
		int[] f = view.gettReservas().getSelectedRows();
		
		if (f != null) {
			
			int confirmar = JOptionPane.showConfirmDialog(null,  "¿Está seguro de que desea eliminar la selección?");
			if(JOptionPane.OK_OPTION==confirmar) {
				for(int i = 0; i<f.length; i++) {
					m.removeRow(f[i]-i);
				}
				JOptionPane.showMessageDialog(null, "Selección eliminada");
			}
		}
		else {
			JOptionPane pane = new JOptionPane("No hay reservas seleccionadas", 
					JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
			JDialog d = pane.createDialog(pane, "Aviso");
			d.setLocation(200, 200);
			d.setVisible(true);
		}
	}
	
	public void reservar() {
		
		int idSocio = model.obtenerSocio();
		model.addReserva(idSocio, view.getCbInstalacion().getSelectedItem().toString(), 
				Util.isoStringToDate(view.getCbFecha().getSelectedItem().toString()), 
				(float) Double.parseDouble(view.getCbHInicio().getSelectedItem().toString()),
				(float) Double.parseDouble(view.getCbHFin().getSelectedItem().toString()));
	}
}

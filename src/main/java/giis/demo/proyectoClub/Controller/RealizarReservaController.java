package giis.demo.proyectoClub.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

import org.apache.commons.beanutils.PropertyUtils;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.proyectoClub.DTO.SocioDTO;
import giis.demo.proyectoClub.DTO.SocioDisplayDTO;
import giis.demo.proyectoClub.View.RealizarReservaView;
import giis.demo.proyectoClub.model.RealizarReservaModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class RealizarReservaController {

	private RealizarReservaModel model;
	private RealizarReservaView view;

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
		addLicencias();
		eliminarDatosTabla();
		view.setVisible(true);
		
		view.getRbtnIndividual().setSelected(true);
		
		view.getbCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)));
		view.getbAnadir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addReserva();
				view.getbReservar().setEnabled(true);
			}
		});
		
		view.getRbtnIndividual().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getListGrupo().setEnabled(false);
				view.getlSeleccion().setEnabled(false);
				view.getTfNLicencia().setEnabled(true);
				view.getlNLicencia().setEnabled(true);
				eliminarDatosTabla();
			}
		});
		
		view.getRbtnGrupo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getTfNLicencia().setEnabled(false);
				view.getlNLicencia().setEnabled(false);
				view.getListGrupo().setEnabled(true);
				view.getlSeleccion().setEnabled(true);
				eliminarDatosTabla();
			}
		});
		
		view.gettReservas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				view.getbEliminar().setEnabled(true);
				view.getbReservar().setEnabled(true);
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

	/**
	 * Metodo que añade a cbFecha el día actual y el día siguiente para realizar una reserva
	 */
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

	/**
	 * Metodo que añade a la lista los elementos de busqueda sql
	 */
	public void addLicencias() {
		List<SocioDisplayDTO> socios = model.getLicencias();

		DefaultListModel m = (DefaultListModel) view.getListGrupo().getModel();
		for (int i = 0; i < socios.size(); i++) {
			m.addElement(socios.get(i).getNumLicencia());
		}
		view.getListGrupo().setModel(m);
	}

	/**
	 * Método que añade la seleccion del socio en la tabla
	 */
	public void addReserva() {

		DefaultTableModel m = (DefaultTableModel) view.gettReservas().getModel();
		Object [] datos = new Object[5];
		
		if(view.getRbtnIndividual().isSelected()) {
			datos[0] = view.getTfNLicencia().getText();
			datos[1] = view.getCbInstalacion().getSelectedItem().toString();
			datos[2] = view.getCbFecha().getSelectedItem().toString();
			datos[3] = view.getCbHInicio().getSelectedItem().toString();
			datos[4] = view.getCbHFin().getSelectedItem().toString();
			m.addRow(datos);
		} 
		else {
			List<String> elem = view.getListGrupo().getSelectedValuesList();
			for(int i = 0; i < elem.size(); i++) {
				datos[0] = elem.get(i);
				datos[1] = view.getCbInstalacion().getSelectedItem().toString();
				datos[2] = view.getCbFecha().getSelectedItem().toString();
				datos[3] = view.getCbHInicio().getSelectedItem().toString();
				datos[4] = view.getCbHFin().getSelectedItem().toString();
				m.addRow(datos);
			}
		}

		view.gettReservas().setModel(m);
	}
	
	/**
	 * Elimina la fila seleccionada de la tabla
	 */
	public void eliminarSeleccion() {
		DefaultTableModel m = (DefaultTableModel) view.gettReservas().getModel();
		int[] f = view.gettReservas().getSelectedRows();

		for(int i = 0; i<f.length; i++) {
			m.removeRow(f[i]-i);
		}
		JOptionPane.showMessageDialog(null, "Selección eliminada");
	}
	
	/**
	 * Elimina todos las filas de la tabla
	 */
	public void eliminarDatosTabla() {
		DefaultTableModel m = (DefaultTableModel) view.gettReservas().getModel();
		int f = view.gettReservas().getRowCount();

		for(int i = 0; i < f; i++) {
			m.removeRow(0);
		}
	}
	
	/**
	 * Añadir la reserva del socio en la tabla reservas de la BD
	 */
	public void reservar() {

		int id = 0;
		if(view.getRbtnIndividual().isSelected()) {
			List<Object[]> idSocio = model.obtenerID(view.getTfNLicencia().getText());
			for(int i = 0; i < idSocio.size(); i++) {
				id = (Integer) idSocio.get(i)[i];
			}
		}
		else {
			List<String> elem = view.getListGrupo().getSelectedValuesList();
			for(int i = 0; i < elem.size(); i++) {
				List<Object[]> idSocio = model.obtenerID(elem.get(i));
				for(int j = 0; j < idSocio.size(); j++) {
					id = (Integer) idSocio.get(j)[j];
				}
			}
		}
		model.addReserva(id, view.getCbInstalacion().getSelectedItem().toString(), 
				Util.isoStringToDate(view.getCbFecha().getSelectedItem().toString()), 
				view.getCbHInicio().getSelectedItem().toString(),
				view.getCbHFin().getSelectedItem().toString());

		generarResguardoReserva();

		JOptionPane pane = new JOptionPane("Reserva realizada con éxito.\nSe ha generado el resguardo de la reserva."
				+ "\nEnviado a: " + view.getTfCorreo().getText(), 
				JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
		JDialog d = pane.createDialog(pane, "Reserva realizada.");
		d.setLocation(200, 200);
		d.setVisible(true);
	}

	/**
	 * Método que genera el resguardo de la reserva del socio
	 */
	public void generarResguardoReserva() {
		FileWriter f;
		try {
			f = new FileWriter("C:\\Users\\inipi\\OneDrive\\Documentos\\GitHub\\SI2020-PL42\\src\\main\\java\\giis\\demo\\proyectoClub\\ResguardoReserva.txt");
			f.write("RESGUARDO RESERVA DE INSTALACIÓN\n"
					+ "\nReserva realizada por: " + view.getTfNombre().getText() + " " + view.getTfApellido1().getText() + " " + view.getTfApellido2().getText());
			DefaultTableModel m = (DefaultTableModel) view.gettReservas().getModel();
			for(int i = 0; i < m.getRowCount(); i++) {
				String nLicencia = (String) m.getValueAt(i, 0);
				String inst = view.getCbInstalacion().getSelectedItem().toString();
				String fecha = view.getCbFecha().getSelectedItem().toString();
				String hinicio = view.getCbHInicio().getSelectedItem().toString();
				String hfin = view.getCbHFin().getSelectedItem().toString();
				f.write("\nSOCIO " + nLicencia + ":\n"
						+ "\nInstalación reservada: " + inst
						+ "\nFecha de reserva: " + fecha
						+ "\nHora inicio de reserva: " + hinicio
						+ "\tHora fin de reserva: " + hfin
						+ "\n\n");
			}
			f.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

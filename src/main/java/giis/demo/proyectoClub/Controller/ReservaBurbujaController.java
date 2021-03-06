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

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.beanutils.PropertyUtils;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.proyectoClub.DTO.LicenciaDisplayDTO;
import giis.demo.proyectoClub.DTO.SocioDTO;
import giis.demo.proyectoClub.DTO.SocioDisplayDTO;
import giis.demo.proyectoClub.View.ReservaBurbujaView;
import giis.demo.proyectoClub.model.ReservaBurbujaModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

public class ReservaBurbujaController {

	private ReservaBurbujaModel model;
	private ReservaBurbujaView view;

	public ReservaBurbujaController(ReservaBurbujaModel m, ReservaBurbujaView v) {
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
		addGrupos();
		insertarFechaReserva();
		insertarHorarioReserva();
		addLicencias();
		eliminarDatosTabla();
		view.setVisible(true);
		view.getlSocio().setEnabled(false);
		view.getListSeleccion().setEnabled(false);
		view.getCbGrupo().setEnabled(false);
		view.getTfLicenciaG().setEnabled(false);
		view.getbAddSG().setEnabled(false);
		view.getbEliminarSG().setEnabled(false);

		view.getRbNGrupo().setSelected(true);

		view.getCbInstalacion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertarHorarioReserva();
			}
		});

		view.getbCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getReservaBurbuja().setVisible(false);
			}
		});
		view.getbAddTabla().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				control();
				view.getbReservar().setEnabled(true);
			}
		});

		view.getRbNGrupo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getlSocio().setEnabled(false);
				view.getListSeleccion().setEnabled(false);
				view.getCbGrupo().setEnabled(false);
				view.getTfLicenciaG().setEnabled(false);
				view.getbAddSG().setEnabled(false);
				view.getbEliminarSG().setEnabled(false);
				view.getlLicencia().setEnabled(true);
				view.getTfLicencia().setEnabled(true);
				view.getbAdd().setEnabled(true);
				view.getbEliminarNuevo().setEnabled(true);
				view.getListNuevo().setEnabled(true);
				eliminarDatosTabla();
			}
		});

		view.getRbGrupo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getlSocio().setEnabled(true);
				view.getListSeleccion().setEnabled(true);
				view.getCbGrupo().setEnabled(true);
				view.getTfLicenciaG().setEnabled(true);
				view.getbAddSG().setEnabled(true);
				view.getbEliminarSG().setEnabled(true);
				view.getlLicencia().setEnabled(false);
				view.getTfLicencia().setEnabled(false);
				view.getbAdd().setEnabled(false);
				view.getbEliminarNuevo().setEnabled(false);
				view.getListNuevo().setEnabled(false);
				eliminarDatosTabla();
			}
		});

		view.gettReserva().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				view.getbEliminar().setEnabled(true);
				view.getbReservar().setEnabled(true);
			}
		});

		view.getbAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean c = controlLicencia();
				if(c == true) {
					DefaultListModel m = (DefaultListModel) view.getListNuevo().getModel();
					if(m.getSize()>=6) {
						JOptionPane pane = new JOptionPane("El número máximo de socios por grupo es 6", 
								JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
						JDialog d = pane.createDialog(pane, "Aviso");
						d.setLocation(200, 200);
						d.setVisible(true);
					}
					else {
						if(EditarInstalacionesController.nivel >= 3) {
							List<SocioDisplayDTO> fechaN = model.getFechaNac(view.getTfLicencia().getText());
							for(int i = 0; i < fechaN.size(); i++) {
								Date fn = convFecha((fechaN.get(i).getFechaNacimiento()));
								Calendar cal = Calendar.getInstance();
								Date fechaSistema = new Date(cal.getTimeInMillis());
								long diff = fechaSistema.getTime() - fn.getTime();
								if(diff >= 14) {
									m.addElement(view.getTfLicencia().getText());
									view.getListNuevo().setModel(m);
								}
								else {
									JOptionPane pane = new JOptionPane("Nivel de estado de alarma: " + EditarInstalacionesController.nivel + "\nLos menores de 14 años no pueden reservar", 
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
									JDialog d = pane.createDialog(pane, "Aviso");
									d.setLocation(200, 200);
									d.setVisible(true);
								}
							}
						}
						else {
							m.addElement(view.getTfLicencia().getText());
							view.getListNuevo().setModel(m);
						}
					}
				}
				else {
					JOptionPane pane = new JOptionPane("El número de licencia introducido no existe", 
							JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
					JDialog d = pane.createDialog(pane, "Aviso");
					d.setLocation(200, 200);
					d.setVisible(true);
				}
			}
		});

		view.getbEliminarNuevo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultListModel m = (DefaultListModel) view.getListNuevo().getModel();
				m.remove(view.getListNuevo().getSelectedIndex());
				view.getListNuevo().setModel(m);
				JOptionPane.showMessageDialog(null, "Selección eliminada");
			}
		});

		view.getbAddSG().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean c = controlLicencia();
				if(c == true) {
					DefaultListModel m = (DefaultListModel) view.getListSeleccion().getModel();
					List<SocioDisplayDTO> grupos = model.getLicenciaGrupo();
					for(int i = 0; i < grupos.size(); i++) {
						if((grupos.get(i).getNumLicencia().equals(view.getTfLicenciaG().getText())) 
								|| (grupos.get(i).getNumLicencia().equals(view.getTfLicencia().getText()))){
							JOptionPane pane = new JOptionPane("Este usuario ya pertenece a un grupo", 
									JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
							JDialog d = pane.createDialog(pane, "Error");
							d.setLocation(200, 200);
							d.setVisible(true);
						}
					}
					if(m.getSize()>=6) {
						JOptionPane pane = new JOptionPane("El número máximo de socios por grupo es 6", 
								JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
						JDialog d = pane.createDialog(pane, "Aviso");
						d.setLocation(200, 200);
						d.setVisible(true);
					}
					else {
						if(EditarInstalacionesController.nivel >= 3) {
							List<SocioDisplayDTO> fechaN = model.getFechaNac(view.getTfLicenciaG().getText());
							for(int i = 0; i < fechaN.size(); i++) {
								Date fn = convFecha((fechaN.get(i).getFechaNacimiento()));
								Calendar cal = Calendar.getInstance();
								Date fechaSistema = new Date(cal.getTimeInMillis());
								long diff = fechaSistema.getTime() - fn.getTime();
								if(diff >= 14) {
									m.addElement(view.getTfLicenciaG().getText());
									view.getListSeleccion().setModel(m);
								}
								else {
									JOptionPane pane = new JOptionPane("Nivel de estado de alarma: " + EditarInstalacionesController.nivel + "\nLos menores de 14 años no pueden reservar", 
											JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
									JDialog d = pane.createDialog(pane, "Aviso");
									d.setLocation(200, 200);
									d.setVisible(true);
								}
							}
						}
						else {
							m.addElement(view.getTfLicenciaG().getText());
							view.getListSeleccion().setModel(m);
						}
					}
				}
				else {
					JOptionPane pane = new JOptionPane("El número de licencia introducido no existe", 
							JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
					JDialog d = pane.createDialog(pane, "Aviso");
					d.setLocation(200, 200);
					d.setVisible(true);
				}
			}
		});

		view.getbEliminarSG().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultListModel m = (DefaultListModel) view.getListSeleccion().getModel();
				m.remove(view.getListSeleccion().getSelectedIndex());
				view.getListSeleccion().setModel(m);
				JOptionPane.showMessageDialog(null, "Selección eliminada");
			}
		});

		view.getbAddTabla().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addReserva();
			}
		});

		view.getbEliminar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarSeleccion()));

		view.getbReservar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reservar()));
	}

	public void initView() {

		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getReservaBurbuja().setVisible(true); 
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
				if(EditarInstalacionesController.nivel != 4) {
					comboBox.addItem(val);
				}
				else if(!val.equals("Galería")) {
					comboBox.addItem(val);
				}
			}catch(IllegalAccessException | InvocationTargetException|NoSuchElementException | NoSuchMethodException e) {
				throw new UnexpectedException(e);
			}			
		}
	}


	/**
	 * Carga los grupos existentes de la BD en el JComboBonx
	 */
	public void addGrupos() {
		List<SocioDisplayDTO> grupos = model.getGrupos();
		int grupo=0;
		view.getCbGrupo().removeAllItems();
		try {
			for(int i = 0; i < grupos.size(); i++) {
				grupo = grupos.get(i).getGrupoBurbuja();
				view.getCbGrupo().addItem(grupo);
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error al cargar ComboBox" + e);
		}
	}


	/**
	 * Metodo que añade a cbFecha el día actual y el día siguiente para realizar una reserva
	 */
	public void insertarFechaReserva(){

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaSistema = new Date(cal.getTimeInMillis());
		String fecha = formatter.format(fechaSistema);
		view.getCbFecha().addItem(fecha);

		cal.setTime(fechaSistema);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaSig = cal.getTime();
		String fecha2 = formatter.format(fechaSig);
		view.getCbFecha().addItem(fecha2);
	}

	public void insertarHorarioReserva() {
		String[] h1i = {"09.00", "10.00", "11.00", "12.00", "13.00", "16.00", "17.00", "18.00", "19.00"};
		String[] h1f = {"10.00", "11.00", "12.00", "13.00", "14.00", "17.00", "18.00", "19.00", "20.00"};
		String[] h2i = {"09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00", "21.00"};
		String[] h2f = {"10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00", "21.00", "22.00"};
		if(view.getCbInstalacion().getSelectedItem().toString().equals("Galería")) {
			for(int i = 0; i < h1i.length; i++) {
				view.getCbHInicio().addItem(h1i[i]);
			}
			for(int i = 0; i < h1f.length; i++) {
				view.getCbHFin().addItem(h1f[i]);
			}
		}
		if(view.getCbInstalacion().getSelectedItem().toString().equals("Campo")) {
			for(int i = 0; i < h2i.length; i++) {
				view.getCbHInicio().addItem(h2i[i]);
			}
			for(int i = 0; i < h2f.length; i++) {
				view.getCbHFin().addItem(h2f[i]);
			}
		}
	}

	/**
	 * Metodo que añade a la lista los elementos de busqueda sql
	 */
	public void addLicencias() {
		List<SocioDisplayDTO> socios = model.getLicenciaGrupo();

		DefaultListModel m = (DefaultListModel) view.getListSeleccion().getModel();
		for (int i = 0; i < socios.size(); i++) {
			m.addElement(socios.get(i).getNumLicencia());
		}
		view.getListSeleccion().setModel(m);
	}

	/**
	 * Elimina la fila seleccionada de la tabla
	 */
	public void eliminarSeleccion() {
		DefaultTableModel m = (DefaultTableModel) view.gettReserva().getModel();
		int[] f = view.gettReserva().getSelectedRows();

		for(int i = 0; i<f.length; i++) {
			m.removeRow(f[i]-i);
		}
		JOptionPane.showMessageDialog(null, "Selección eliminada");
	}

	/**
	 * Elimina todos las filas de la tabla
	 */
	public void eliminarDatosTabla() {
		DefaultTableModel m = (DefaultTableModel) view.gettReserva().getModel();
		int f = view.gettReserva().getRowCount();

		for(int i = 0; i < f; i++) {
			m.removeRow(0);
		}
	}

	/**
	 * 	Metodo para convertir el String de cbFecha a Date
	 */
	public static Date convFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaDate;
	}

	/**
	 * Metodo para controlar los datos de la reserva
	 * Comprueba si el nombre y los apellidos del socio existen
	 * Comprueba que se hayan seleccionado la instalacion y el horario que se desea
	 * Comprueba que la hora de inicio sea mayor e igual que la hora de fin de la reserva
	 */
	public void control() {
		List<Object[]> socio = model.getSocio(view.getTfNombre().getText(), view.getTfApellido1().getText(), view.getTfApellido2().getText());
		if(!view.getCbHInicio().getSelectedItem().toString().equals("-- Hora inicio --") 
				&& !view.getCbHFin().getSelectedItem().toString().equals("-- Hora fin --") 
				&& !view.getCbInstalacion().getSelectedItem().toString().equals("-- Instalación --")
				&& !view.getCbFecha().getSelectedItem().toString().equals("-- Fecha --")
				&& !socio.isEmpty()) {
			Double f = Double.parseDouble(view.getCbHFin().getSelectedItem().toString());
			Double i = Double.parseDouble(view.getCbHInicio().getSelectedItem().toString());
			if((f-i) <= 0 ) {
				JOptionPane pane = new JOptionPane("La hora de fin de reserva no puede ser menor o igual a la hora de inicio.", 
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
				JDialog d = pane.createDialog(pane, "Hora incorrecta");
				d.setLocation(200, 200);
				d.setVisible(true);
			}
			else {
				addReserva();
			}
		}

		else {
			if(socio.isEmpty()) {
				JOptionPane pane = new JOptionPane("El socio introducido no existe.\nRevise los datos", 
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
				JDialog d = pane.createDialog(pane, "Socio incorrecto");
				d.setLocation(200, 200);
				d.setVisible(true);
			}
			else {
				JOptionPane pane = new JOptionPane("Ningun campo puede estar vacío", 
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
				JDialog d = pane.createDialog(pane, "Campos vacíos");
				d.setLocation(200, 200);
				d.setVisible(true);
			}
		}
	}

	public boolean controlLicencia() {
		List<LicenciaDisplayDTO> licencias = model.getLicencias();

		if(view.getTfLicencia().getText().isEmpty()) {
			return false;
		}
		else {
			int i = 0;
			while(i < licencias.size() && !licencias.get(i).getNumLicencia().equals(view.getTfLicencia().getText())) {
				i++;
			}
			if(i < licencias.size()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que añade la selección del socio a la tabla
	 */
	private void addReserva() {
		// TODO Auto-generated method stub
		DefaultTableModel m = (DefaultTableModel) view.gettReserva().getModel();
		Object [] datos = new Object[5];

		if(view.getRbNGrupo().isSelected()) {
			List<SocioDisplayDTO> grupos = model.getGrupos();
			datos[0] = grupos.size()+1;
			datos[1] = view.getCbInstalacion().getSelectedItem().toString();
			datos[2] = view.getCbFecha().getSelectedItem().toString();
			datos[3] = view.getCbHInicio().getSelectedItem().toString();
			datos[4] = view.getCbHFin().getSelectedItem().toString();
			m.addRow(datos);
		}
		else {
			if(view.getRbGrupo().isSelected()) {
				datos[0] = view.getCbGrupo().getSelectedItem().toString();
				datos[1] = view.getCbInstalacion().getSelectedItem().toString();
				datos[2] = view.getCbFecha().getSelectedItem().toString();
				datos[3] = view.getCbHInicio().getSelectedItem().toString();
				datos[4] = view.getCbHFin().getSelectedItem().toString();
				m.addRow(datos);
			}
		}
	}

	/**
	 * Método que añade la reserva realizada en la tabla reservas de la BD
	 */
	private void reservar() {

		DefaultTableModel m = (DefaultTableModel) view.gettReserva().getModel();
		int f = view.gettReserva().getRowCount();

		String instalacion = view.getCbInstalacion().getSelectedItem().toString();
		Date fecha = convFecha(view.getCbFecha().getSelectedItem().toString());
		String hinicio = view.getCbHInicio().getSelectedItem().toString();
		List<Object[]> reservasInstalacion = model.getReservasInstalacion(instalacion, fecha, hinicio);
		for(int i = 0; i < reservasInstalacion.size(); i++) {
			if(reservasInstalacion.get(i).equals(instalacion)) {
				JOptionPane pane = new JOptionPane("No es posible realizar la reserva.\nMOTIVO: Colisión con otro grupo", 
						JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
				JDialog d = pane.createDialog(pane, "Error en reserva");
				d.setLocation(200, 200);
				d.setVisible(true);
			}
			else {
				int id = 0;
				int grupo = Integer.parseInt(String.valueOf(view.gettReserva().getValueAt(0, 0)));
				List<SocioDisplayDTO> socios = model.getSociosGrupo(grupo);
				for(int j = 0; j < socios.size(); j++) {
					id = (Integer) socios.get(i).getIdSocio();
					model.addReserva(id, view.getCbInstalacion().getSelectedItem().toString(),
							convFecha(view.getCbFecha().getSelectedItem().toString()),
							view.getCbHInicio().getSelectedItem().toString(),
							view.getCbHFin().getSelectedItem().toString());
				}
			}
		}
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
			f = new FileWriter("C:\\Users\\inipi\\OneDrive\\Documentos\\GitHub\\SI2020-PL42\\src\\main\\java\\giis\\demo\\proyectoClub\\ResguardoReservaGRUPO.txt");
			f.write("RESGUARDO RESERVA DE INSTALACIÓN\n"
					+ "\nReserva realizada por: " + view.getTfNombre().getText() + " " + view.getTfApellido1().getText() + " " + view.getTfApellido2().getText());
			DefaultTableModel m = (DefaultTableModel) view.gettReserva().getModel();
			for(int i = 0; i < m.getRowCount(); i++) {
				String grupo = (String) m.getValueAt(i, 0);
				String inst = view.getCbInstalacion().getSelectedItem().toString();
				String fecha = view.getCbFecha().getSelectedItem().toString();
				String hinicio = view.getCbHInicio().getSelectedItem().toString();
				String hfin = view.getCbHFin().getSelectedItem().toString();
				f.write("\nGRUPO " + grupo + ":\n"
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

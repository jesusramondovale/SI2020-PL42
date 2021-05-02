package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class ReservaBurbujaView extends JFrame {

	private JFrame ReservaBurbuja;
	private JTextField tfNombre, tfApellido1, tfApellido2, tfCorreo;
	private JTextField tfLicencia;
	private final ButtonGroup grupo = new ButtonGroup();
	private JTable tReserva;
	private JScrollPane scrollPane;
	private JLabel lNombre, lApellido1, lApellido2, lCorreo, lSocio, lLicencia, lInstalacion, lFecha, lHora;
	private JRadioButton rbNGrupo, rbGrupo;
	private JComboBox cbGrupo, cbInstalacion, cbFecha, cbHInicio, cbHFin;
	private JButton bAdd, bCancelar, bAddTabla, bEliminar, bReservar, bAddSG, bEliminarSG, bEliminarNuevo;
	private JSeparator separator, separator_1;
	private JList listSeleccion, listNuevo;
	private JTextField tfLicenciaG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaBurbujaView frame = new ReservaBurbujaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservaBurbujaView() {
		
		ReservaBurbuja = new JFrame();
		ReservaBurbuja.setTitle("Realizar reserva");
		ReservaBurbuja.setBounds(100, 100, 1028, 636);
		ReservaBurbuja.getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lNombre = new JLabel("Nombre:");
		lNombre.setBounds(28, 49, 70, 14);
		ReservaBurbuja.getContentPane().add(lNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(93, 46, 128, 20);
		ReservaBurbuja.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		lApellido1 = new JLabel("Apellido 1:");
		lApellido1.setBounds(231, 49, 70, 14);
		ReservaBurbuja.getContentPane().add(lApellido1);
		
		tfApellido1 = new JTextField();
		tfApellido1.setBounds(297, 46, 124, 20);
		ReservaBurbuja.getContentPane().add(tfApellido1);
		tfApellido1.setColumns(10);
		
		lApellido2 = new JLabel("Apellido 2:");
		lApellido2.setBounds(431, 49, 70, 14);
		ReservaBurbuja.getContentPane().add(lApellido2);
		
		tfApellido2 = new JTextField();
		tfApellido2.setBounds(499, 46, 130, 20);
		ReservaBurbuja.getContentPane().add(tfApellido2);
		tfApellido2.setColumns(10);
		
		lCorreo = new JLabel("Correo electrónico:");
		lCorreo.setBounds(639, 49, 144, 14);
		ReservaBurbuja.getContentPane().add(lCorreo);
		
		tfCorreo = new JTextField();
		tfCorreo.setBounds(745, 46, 241, 20);
		ReservaBurbuja.getContentPane().add(tfCorreo);
		tfCorreo.setColumns(10);
		
		rbNGrupo = new JRadioButton("Nuevo grupo burbuja:");
		grupo.add(rbNGrupo);
		rbNGrupo.setBounds(28, 111, 152, 23);
		ReservaBurbuja.getContentPane().add(rbNGrupo);
		
		rbGrupo = new JRadioButton("Seleccionar grupo burbuja:");
		grupo.add(rbGrupo);
		rbGrupo.setBounds(28, 317, 172, 23);
		ReservaBurbuja.getContentPane().add(rbGrupo);
		
		cbGrupo = new JComboBox();
		cbGrupo.setModel(new DefaultComboBoxModel(new String[] {"Grupo"}));
		cbGrupo.setBounds(28, 347, 53, 22);
		ReservaBurbuja.getContentPane().add(cbGrupo);
		
		lSocio = new JLabel("Añadir nuevo socio:");
		lSocio.setBounds(93, 351, 107, 14);
		ReservaBurbuja.getContentPane().add(lSocio);
		
		lLicencia = new JLabel("Nº licencia:");
		lLicencia.setBounds(28, 150, 80, 14);
		ReservaBurbuja.getContentPane().add(lLicencia);
		
		tfLicencia = new JTextField();
		tfLicencia.setBounds(119, 147, 107, 20);
		ReservaBurbuja.getContentPane().add(tfLicencia);
		tfLicencia.setColumns(10);
		
		bAdd = new JButton("Añadir");
		bAdd.setBounds(41, 190, 89, 23);
		ReservaBurbuja.getContentPane().add(bAdd);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(91, 544, 89, 23);
		ReservaBurbuja.getContentPane().add(bCancelar);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(332, 111, 7, 477);
		ReservaBurbuja.getContentPane().add(separator);
		
		lInstalacion = new JLabel("Instalación:");
		lInstalacion.setBounds(372, 194, 89, 14);
		ReservaBurbuja.getContentPane().add(lInstalacion);
		
		cbInstalacion = new JComboBox();
		cbInstalacion.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar instalación"}));
		cbInstalacion.setBounds(372, 232, 152, 22);
		ReservaBurbuja.getContentPane().add(cbInstalacion);
		
		lFecha = new JLabel("Fecha de la reserva:");
		lFecha.setBounds(372, 287, 129, 14);
		ReservaBurbuja.getContentPane().add(lFecha);
		
		cbFecha = new JComboBox();
		cbFecha.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar fecha"}));
		cbFecha.setBounds(372, 323, 152, 22);
		ReservaBurbuja.getContentPane().add(cbFecha);
		
		lHora = new JLabel("Hora de la reserva:");
		lHora.setBounds(372, 374, 152, 14);
		ReservaBurbuja.getContentPane().add(lHora);
		
		cbHInicio = new JComboBox();
		cbHInicio.setModel(new DefaultComboBoxModel(new String[] {"Inicio"}));
		cbHInicio.setBounds(372, 411, 62, 22);
		ReservaBurbuja.getContentPane().add(cbHInicio);
		
		cbHFin = new JComboBox();
		cbHFin.setModel(new DefaultComboBoxModel(new String[] {"Fin"}));
		cbHFin.setBounds(462, 411, 62, 22);
		ReservaBurbuja.getContentPane().add(cbHFin);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(580, 111, 7, 477);
		ReservaBurbuja.getContentPane().add(separator_1);
		
		bAddTabla = new JButton("Añadir");
		bAddTabla.setBounds(401, 505, 89, 23);
		ReservaBurbuja.getContentPane().add(bAddTabla);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(607, 169, 379, 269);
		ReservaBurbuja.getContentPane().add(scrollPane);
		
		tReserva = new JTable();
		tReserva.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
						"Grupo", "Instalación", "Fecha", "Hora Inico", "Hora Fin"
				}
		));
		scrollPane.setViewportView(tReserva);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setBounds(639, 490, 89, 23);
		ReservaBurbuja.getContentPane().add(bEliminar);
		
		bReservar = new JButton("Reservar");
		bReservar.setBounds(859, 490, 89, 23);
		ReservaBurbuja.getContentPane().add(bReservar);
		
		listSeleccion = new JList();
		listSeleccion.setModel(new DefaultListModel<>());
		listSeleccion.setBounds(28, 431, 271, 82);
		ReservaBurbuja.getContentPane().add(listSeleccion);
		
		listNuevo = new JList();
		listNuevo.setModel(new DefaultListModel<>());
		listNuevo.setBounds(30, 219, 271, 82);
		ReservaBurbuja.getContentPane().add(listNuevo);
		
		bAddSG = new JButton("New button");
		bAddSG.setBounds(41, 397, 89, 23);
		ReservaBurbuja.getContentPane().add(bAddSG);
		
		bEliminarSG = new JButton("Eliminar");
		bEliminarSG.setBounds(199, 397, 89, 23);
		ReservaBurbuja.getContentPane().add(bEliminarSG);
		
		bEliminarNuevo = new JButton("Eliminar");
		bEliminarNuevo.setBounds(199, 190, 89, 23);
		ReservaBurbuja.getContentPane().add(bEliminarNuevo);
		
		tfLicenciaG = new JTextField();
		tfLicenciaG.setColumns(10);
		tfLicenciaG.setBounds(199, 348, 107, 20);
		ReservaBurbuja.getContentPane().add(tfLicenciaG);
	}

	public JFrame getReservaBurbuja() {
		return ReservaBurbuja;
	}

	public void setReservaBurbuja(JFrame reservaBurbuja) {
		ReservaBurbuja = reservaBurbuja;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JTextField getTfApellido1() {
		return tfApellido1;
	}

	public void setTfApellido1(JTextField tfApellido1) {
		this.tfApellido1 = tfApellido1;
	}

	public JTextField getTfApellido2() {
		return tfApellido2;
	}

	public void setTfApellido2(JTextField tfApellido2) {
		this.tfApellido2 = tfApellido2;
	}

	public JTextField getTfCorreo() {
		return tfCorreo;
	}

	public void setTfCorreo(JTextField tfCorreo) {
		this.tfCorreo = tfCorreo;
	}

	public JTextField getTfLicencia() {
		return tfLicencia;
	}

	public void setTfLicencia(JTextField tfLicencia) {
		this.tfLicencia = tfLicencia;
	}

	public JTable gettReserva() {
		return tReserva;
	}

	public void settReserva(JTable tReserva) {
		this.tReserva = tReserva;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JRadioButton getRbNGrupo() {
		return rbNGrupo;
	}

	public void setRbNGrupo(JRadioButton rbNGrupo) {
		this.rbNGrupo = rbNGrupo;
	}

	public JRadioButton getRbGrupo() {
		return rbGrupo;
	}

	public void setRbGrupo(JRadioButton rbGrupo) {
		this.rbGrupo = rbGrupo;
	}

	public JComboBox getCbGrupo() {
		return cbGrupo;
	}

	public void setCbGrupo(JComboBox cbGrupo) {
		this.cbGrupo = cbGrupo;
	}

	public JComboBox getCbInstalacion() {
		return cbInstalacion;
	}

	public void setCbInstalacion(JComboBox cbInstalacion) {
		this.cbInstalacion = cbInstalacion;
	}

	public JComboBox getCbFecha() {
		return cbFecha;
	}

	public void setCbFecha(JComboBox cbFecha) {
		this.cbFecha = cbFecha;
	}

	public JComboBox getCbHInicio() {
		return cbHInicio;
	}

	public void setCbHInicio(JComboBox cbHInicio) {
		this.cbHInicio = cbHInicio;
	}

	public JComboBox getCbHFin() {
		return cbHFin;
	}

	public void setCbHFin(JComboBox cbHFin) {
		this.cbHFin = cbHFin;
	}

	public JButton getbAdd() {
		return bAdd;
	}

	public void setbAdd(JButton bAdd) {
		this.bAdd = bAdd;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbAddTabla() {
		return bAddTabla;
	}

	public void setbAddTabla(JButton bAddTabla) {
		this.bAddTabla = bAddTabla;
	}

	public JButton getbEliminar() {
		return bEliminar;
	}

	public void setbEliminar(JButton bEliminar) {
		this.bEliminar = bEliminar;
	}

	public JButton getbReservar() {
		return bReservar;
	}

	public void setbReservar(JButton bReservar) {
		this.bReservar = bReservar;
	}

	public JList getListSeleccion() {
		return listSeleccion;
	}

	public void setListSeleccion(JList listSeleccion) {
		this.listSeleccion = listSeleccion;
	}

	public JList getListNuevo() {
		return listNuevo;
	}

	public void setListNuevo(JList listNuevo) {
		this.listNuevo = listNuevo;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public JLabel getlLicencia() {
		return lLicencia;
	}
	
	public void setlLicencia(JLabel lLicencia) {
		this.lLicencia = lLicencia;
	}

	public JLabel getlSocio() {
		return lSocio;
	}

	public void setlSocio(JLabel lSocio) {
		this.lSocio = lSocio;
	}

	public JButton getbAddSG() {
		return bAddSG;
	}

	public void setbAddSG(JButton bAddSG) {
		this.bAddSG = bAddSG;
	}

	public JButton getbEliminarSG() {
		return bEliminarSG;
	}

	public void setbEliminarSG(JButton bEliminarSG) {
		this.bEliminarSG = bEliminarSG;
	}

	public JButton getbEliminarNuevo() {
		return bEliminarNuevo;
	}

	public void setbEliminarNuevo(JButton bEliminarNuevo) {
		this.bEliminarNuevo = bEliminarNuevo;
	}

	public JTextField getTfLicenciaG() {
		return tfLicenciaG;
	}

	public void setTfLicenciaG(JTextField tfLicenciaG) {
		this.tfLicenciaG = tfLicenciaG;
	}
	
	
}

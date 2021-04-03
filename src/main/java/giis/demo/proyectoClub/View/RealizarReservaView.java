package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class RealizarReservaView extends JFrame {

	private JFrame RealizarReserva;
	private JTextField tfNLicencia, tfNombre, tfApellido1, tfApellido2, tfCorreo;
	private JLabel lNombre, lNLicencia, lApellido1, lApellido2, lHora, lFecha, lInstalacion;
	private JComboBox cbInstalacion, cbHInicio, cbHFin, cbFecha;
	private JButton bCancelar, bReservar, bAnadir, bEliminar;
	private JSeparator separator;
	private JTable tReservas;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarReservaView frame = new RealizarReservaView();
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
	public RealizarReservaView() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		RealizarReserva = new JFrame();
		RealizarReserva.setTitle("Realizar reserva");
		RealizarReserva.setBounds(100, 100, 614, 474);
		RealizarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RealizarReserva.getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		lNLicencia = new JLabel("Nº Licencia:");
		lNLicencia.setBounds(20, 61, 59, 14);
		getContentPane().add(lNLicencia);

		tfNLicencia = new JTextField();
		tfNLicencia.setBounds(89, 58, 175, 20);
		getContentPane().add(tfNLicencia);
		tfNLicencia.setColumns(10);

		lNombre = new JLabel("Nombre:");
		lNombre.setBounds(292, 61, 49, 14);
		getContentPane().add(lNombre);

		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(339, 58, 168, 20);
		getContentPane().add(tfNombre);
		
		lApellido1 = new JLabel("Apellido 1:");
		lApellido1.setBounds(529, 61, 59, 14);
		getContentPane().add(lApellido1);
		
		lApellido2 = new JLabel("Apellido 2:");
		lApellido2.setBounds(529, 91, 59, 14);
		getContentPane().add(lApellido2);
		
		tfApellido1 = new JTextField();
		tfApellido1.setBounds(598, 58, 160, 20);
		getContentPane().add(tfApellido1);
		tfApellido1.setColumns(10);
		
		tfApellido2 = new JTextField();
		tfApellido2.setColumns(10);
		tfApellido2.setBounds(598, 88, 160, 20);
		getContentPane().add(tfApellido2);

		JLabel lCorreo = new JLabel("Correo electrónico:");
		lCorreo.setBounds(781, 61, 94, 14);
		getContentPane().add(lCorreo);

		tfCorreo = new JTextField();
		tfCorreo.setBounds(885, 58, 204, 20);
		getContentPane().add(tfCorreo);
		tfCorreo.setColumns(10);

		lInstalacion = new JLabel("Seleccionar instalación:");
		lInstalacion.setBounds(89, 177, 116, 14);
		getContentPane().add(lInstalacion);

		cbInstalacion = new JComboBox();
		cbInstalacion.setModel(new DefaultComboBoxModel(new String[] {"-- Instalación --"}));
		cbInstalacion.setBounds(254, 173, 126, 22);
		getContentPane().add(cbInstalacion);

		lFecha = new JLabel("Seleccionar fecha:");
		lFecha.setBounds(89, 226, 116, 14);
		getContentPane().add(lFecha);
		
		cbFecha = new JComboBox();
		cbFecha.setModel(new DefaultComboBoxModel(new String[] {"-- Fecha --"}));
		cbFecha.setBounds(254, 222, 126, 22);
		getContentPane().add(cbFecha);

		lHora = new JLabel("Seleccionar hora:");
		lHora.setBounds(89, 310, 116, 14);
		getContentPane().add(lHora);

		cbHInicio = new JComboBox();
		cbHInicio.setModel(new DefaultComboBoxModel(new String[] {"-- Hora inicio --", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		cbHInicio.setBounds(254, 281, 126, 22);
		getContentPane().add(cbHInicio);

		cbHFin = new JComboBox();
		cbHFin.setModel(new DefaultComboBoxModel(new String[] {"-- Hora fin--", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"}));
		cbHFin.setBounds(254, 336, 126, 22);
		getContentPane().add(cbHFin);

		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(55, 411, 138, 20);
		getContentPane().add(bCancelar);

		bAnadir = new JButton("Añadir");
		bAnadir.setBounds(339, 411, 138, 20);
		getContentPane().add(bAnadir);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(505, 146, 2, 311);
		getContentPane().add(separator);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(564, 151, 525, 232);
		getContentPane().add(scrollPane);

		tReservas = new JTable();
		tReservas.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
						"Nº Licencia", "Socio", "Instalación", "Fecha", "Hora Inico", "Hora Fin"
				}
		));
		scrollPane.setViewportView(tReservas);

		bReservar = new JButton("Reservar");
		bReservar.setEnabled(false);
		bReservar.setBounds(854, 410, 235, 23);
		getContentPane().add(bReservar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setEnabled(false);
		bEliminar.setBounds(564, 410, 235, 23);
		getContentPane().add(bEliminar);

	}

	public JFrame getRealizarReserva() {
		return RealizarReserva;
	}

	public void setRealizarReserva(JFrame realizarReserva) {
		RealizarReserva = realizarReserva;
	}

	public JTextField getTfNLicencia() {
		return tfNLicencia;
	}

	public void setTfNLicencia(JTextField tfNLicencia) {
		this.tfNLicencia = tfNLicencia;
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

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbReservar() {
		return bReservar;
	}

	public void setbReservar(JButton bReservar) {
		this.bReservar = bReservar;
	}

	public JButton getbAnadir() {
		return bAnadir;
	}

	public void setbAnadir(JButton bAnadir) {
		this.bAnadir = bAnadir;
	}

	public JButton getbEliminar() {
		return bEliminar;
	}

	public void setbEliminar(JButton bEliminar) {
		this.bEliminar = bEliminar;
	}

	public JTable gettReservas() {
		return tReservas;
	}
	
	void settReservas(JTable tReservas) {
		this.tReservas = tReservas;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	
}

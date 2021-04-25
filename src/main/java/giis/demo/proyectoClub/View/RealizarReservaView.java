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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RealizarReservaView extends JFrame {

	private JFrame RealizarReserva;
	private JTextField tfNLicencia, tfCorreo, tfNombre, tfApellido1, tfApellido2;
	private JLabel lNLicencia, lHora, lFecha, lInstalacion, lSeleccion, lCorreo, lNombre, lApellido1, lApellido2;
	private JComboBox cbInstalacion, cbHInicio, cbHFin, cbFecha;
	private JButton bCancelar, bReservar, bEliminar, bAnadir;
	private JSeparator separator, separator_1;
	private JTable tReservas;
	private JScrollPane scrollPane;
	private JList listGrupo;
	private JRadioButton rbtnIndividual;
	private JRadioButton rbtnGrupo;
	private final ButtonGroup bgReservas = new ButtonGroup();

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
		lNLicencia.setBounds(20, 131, 85, 14);
		getContentPane().add(lNLicencia);

		tfNLicencia = new JTextField();
		tfNLicencia.setBounds(115, 128, 106, 20);
		getContentPane().add(tfNLicencia);
		tfNLicencia.setColumns(10);

		lCorreo = new JLabel("Correo electrónico:");
		lCorreo.setBounds(694, 36, 152, 14);
		getContentPane().add(lCorreo);

		tfCorreo = new JTextField();
		tfCorreo.setBounds(849, 33, 219, 20);
		getContentPane().add(tfCorreo);
		tfCorreo.setColumns(10);

		lInstalacion = new JLabel("Seleccionar instalación:");
		lInstalacion.setBounds(263, 182, 116, 14);
		getContentPane().add(lInstalacion);

		cbInstalacion = new JComboBox();
		cbInstalacion.setModel(new DefaultComboBoxModel(new String[] {"-- Instalación --"}));
		cbInstalacion.setBounds(411, 178, 106, 22);
		getContentPane().add(cbInstalacion);

		lFecha = new JLabel("Seleccionar fecha:");
		lFecha.setBounds(263, 252, 116, 14);
		getContentPane().add(lFecha);
		
		cbFecha = new JComboBox();
		cbFecha.setModel(new DefaultComboBoxModel(new String[] {"-- Fecha --"}));
		cbFecha.setBounds(411, 248, 106, 22);
		getContentPane().add(cbFecha);

		lHora = new JLabel("Seleccionar hora:");
		lHora.setBounds(263, 336, 116, 14);
		getContentPane().add(lHora);

		cbHInicio = new JComboBox();
		cbHInicio.setModel(new DefaultComboBoxModel(new String[] {"-- Hora inicio --"}));
		cbHInicio.setBounds(411, 303, 106, 22);
		getContentPane().add(cbHInicio);

		cbHFin = new JComboBox();
		cbHFin.setModel(new DefaultComboBoxModel(new String[] {"-- Hora fin --"}));
		cbHFin.setBounds(411, 354, 106, 22);
		getContentPane().add(cbHFin);

		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(53, 479, 138, 20);
		getContentPane().add(bCancelar);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(251, 86, 2, 447);
		getContentPane().add(separator);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(571, 86, 497, 374);
		getContentPane().add(scrollPane);

		tReservas = new JTable();
		tReservas.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
						"Nº Licencia", "Instalación", "Fecha", "Hora Inico", "Hora Fin"
				}
		));
		scrollPane.setViewportView(tReservas);

		bReservar = new JButton("Reservar");
		bReservar.setEnabled(false);
		bReservar.setBounds(833, 478, 235, 23);
		getContentPane().add(bReservar);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.setEnabled(false);
		bEliminar.setBounds(571, 478, 235, 23);
		getContentPane().add(bEliminar);
		
		bAnadir = new JButton("Añadir");
		bAnadir.setBounds(330, 435, 138, 20);
		getContentPane().add(bAnadir);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(545, 86, 2, 447);
		getContentPane().add(separator_1);
		
		lSeleccion = new JLabel("Seleccione los socios:");
		lSeleccion.setEnabled(false);
		lSeleccion.setBounds(22, 207, 339, 14);
		getContentPane().add(lSeleccion);
		
		listGrupo = new JList();
		listGrupo.setModel(new DefaultListModel<>());
		listGrupo.setEnabled(false);
		listGrupo.setBounds(39, 232, 152, 222);
		getContentPane().add(listGrupo);
		
		rbtnIndividual = new JRadioButton("Reserva individual");
		bgReservas.add(rbtnIndividual);
		rbtnIndividual.setBounds(39, 89, 182, 23);
		getContentPane().add(rbtnIndividual);
		
		rbtnGrupo = new JRadioButton("Reserva en grupo");
		bgReservas.add(rbtnGrupo);
		rbtnGrupo.setBounds(39, 178, 182, 23);
		getContentPane().add(rbtnGrupo);
		
		lNombre = new JLabel("Nombre: ");
		lNombre.setBounds(37, 36, 68, 14);
		getContentPane().add(lNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(114, 33, 107, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		lApellido1 = new JLabel("Apellido 1:");
		lApellido1.setBounds(231, 36, 85, 14);
		getContentPane().add(lApellido1);
		
		tfApellido1 = new JTextField();
		tfApellido1.setBounds(307, 33, 116, 20);
		getContentPane().add(tfApellido1);
		tfApellido1.setColumns(10);
		
		lApellido2 = new JLabel("Apellido 2:");
		lApellido2.setBounds(439, 36, 78, 14);
		getContentPane().add(lApellido2);
		
		tfApellido2 = new JTextField();
		tfApellido2.setColumns(10);
		tfApellido2.setBounds(527, 33, 138, 20);
		getContentPane().add(tfApellido2);

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

	public JList getListGrupo() {
		return listGrupo;
	}

	public void setListGrupo(JList listGrupo) {
		this.listGrupo = listGrupo;
	}

	public JRadioButton getRbtnIndividual() {
		return rbtnIndividual;
	}

	public void setRbtnIndividual(JRadioButton rbtnIndividual) {
		this.rbtnIndividual = rbtnIndividual;
	}

	public JRadioButton getRbtnGrupo() {
		return rbtnGrupo;
	}

	public void setRbtnGrupo(JRadioButton rbtnGrupo) {
		this.rbtnGrupo = rbtnGrupo;
	}

	public ButtonGroup getBgReservas() {
		return bgReservas;
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

	public JLabel getlNLicencia() {
		return lNLicencia;
	}

	public void setlNLicencia(JLabel lNLicencia) {
		this.lNLicencia = lNLicencia;
	}

	public JLabel getlSeleccion() {
		return lSeleccion;
	}

	public void setlSeleccion(JLabel lSeleccion) {
		this.lSeleccion = lSeleccion;
	}
	
	
}

package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class NuevoSocioVista extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldDNI;
	private JTextField textFieldFechaNacimiento;
	private JTextField textFieldSexo;
	private JTextField textFieldClub;
	private JTextField textFieldLicencia;
	private JTextField textFieldNombreTecnico;
	private JTextField textFieldDNITecnico;
	private JTextField textFieldLicenciaTecnico;
	private JTextField textFieldNombreTutor;
	private JTextField textFieldDNITutor;
	private JCheckBox chckbxAceptarDatos;
	private JCheckBox chckbxTutor;
	private JButton btnCrearLicencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoSocioVista frame = new NuevoSocioVista();
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
	public NuevoSocioVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Nuevo Socio");
		lblTitulo.setBounds(5, 5, 1024, 22);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblTitulo);
		
		JLabel lblDatosSocio = new JLabel("Datos Socio");
		lblDatosSocio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosSocio.setBounds(5, 38, 352, 36);
		contentPane.add(lblDatosSocio);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(5, 95, 147, 22);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(177, 98, 180, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(5, 142, 46, 14);
		contentPane.add(lblDNI);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(177, 141, 180, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha De Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(5, 180, 147, 14);
		contentPane.add(lblFechaNacimiento);
		
		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setToolTipText("");
		textFieldFechaNacimiento.setBounds(177, 179, 180, 20);
		contentPane.add(textFieldFechaNacimiento);
		textFieldFechaNacimiento.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(5, 216, 46, 14);
		contentPane.add(lblSexo);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(177, 215, 180, 20);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		JLabel lblClub = new JLabel("Club");
		lblClub.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClub.setBounds(5, 258, 46, 14);
		contentPane.add(lblClub);
		
		textFieldClub = new JTextField();
		textFieldClub.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldClub.setBounds(177, 257, 180, 20);
		contentPane.add(textFieldClub);
		textFieldClub.setColumns(10);
		
		JLabel lblLicencia = new JLabel("Licencia");
		lblLicencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLicencia.setBounds(5, 295, 66, 14);
		contentPane.add(lblLicencia);
		
		textFieldLicencia = new JTextField();
		textFieldLicencia.setBounds(177, 294, 180, 20);
		contentPane.add(textFieldLicencia);
		textFieldLicencia.setColumns(10);
		
		JLabel lblDatosTecnico = new JLabel("Datos Técnico");
		lblDatosTecnico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosTecnico.setBounds(5, 368, 116, 14);
		contentPane.add(lblDatosTecnico);
		
		JLabel lblNombreTecnico = new JLabel("Nombre");
		lblNombreTecnico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreTecnico.setBounds(5, 394, 147, 22);
		contentPane.add(lblNombreTecnico);
		
		textFieldNombreTecnico = new JTextField();
		textFieldNombreTecnico.setColumns(10);
		textFieldNombreTecnico.setBounds(177, 397, 180, 20);
		contentPane.add(textFieldNombreTecnico);
		
		JLabel lblDNITecnico = new JLabel("DNI");
		lblDNITecnico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNITecnico.setBounds(5, 441, 46, 14);
		contentPane.add(lblDNITecnico);
		
		textFieldDNITecnico = new JTextField();
		textFieldDNITecnico.setColumns(10);
		textFieldDNITecnico.setBounds(177, 440, 180, 20);
		contentPane.add(textFieldDNITecnico);
		
		JLabel lblLicenciaTecnico = new JLabel("Licencia");
		lblLicenciaTecnico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLicenciaTecnico.setBounds(5, 477, 66, 14);
		contentPane.add(lblLicenciaTecnico);
		
		textFieldLicenciaTecnico = new JTextField();
		textFieldLicenciaTecnico.setColumns(10);
		textFieldLicenciaTecnico.setBounds(177, 476, 180, 20);
		contentPane.add(textFieldLicenciaTecnico);
		
		chckbxAceptarDatos = new JCheckBox("Acepto la cesión de mis datos personales");
		chckbxAceptarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAceptarDatos.setBounds(6, 538, 285, 23);
		contentPane.add(chckbxAceptarDatos);
		
		chckbxTutor = new JCheckBox("Soy menor y estoy autorizado por un tutor");
		chckbxTutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTutor.setBounds(612, 48, 305, 23);
		contentPane.add(chckbxTutor);
		
		JLabel lblDatosTutor = new JLabel("Datos Tutor");
		lblDatosTutor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosTutor.setBounds(612, 78, 352, 36);
		contentPane.add(lblDatosTutor);
		
		JLabel lblNombreTutor = new JLabel("Nombre");
		lblNombreTutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreTutor.setBounds(612, 128, 147, 22);
		contentPane.add(lblNombreTutor);
		
		textFieldNombreTutor = new JTextField();
		textFieldNombreTutor.setColumns(10);
		textFieldNombreTutor.setBounds(784, 131, 180, 20);
		contentPane.add(textFieldNombreTutor);
		
		JLabel lblDNITutor = new JLabel("DNI");
		lblDNITutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNITutor.setBounds(612, 175, 46, 14);
		contentPane.add(lblDNITutor);
		
		textFieldDNITutor = new JTextField();
		textFieldDNITutor.setColumns(10);
		textFieldDNITutor.setBounds(784, 174, 180, 20);
		contentPane.add(textFieldDNITutor);
		
		btnCrearLicencia = new JButton("Crear Licencia");
		btnCrearLicencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearLicencia.setBounds(784, 499, 140, 47);
		contentPane.add(btnCrearLicencia);
		
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
	}

	public JTextField getTextFieldFechaNacimiento() {
		return textFieldFechaNacimiento;
	}

	public void setTextFieldFechaNacimiento(JTextField textFieldFechaNacimiento) {
		this.textFieldFechaNacimiento = textFieldFechaNacimiento;
	}

	public JTextField getTextFieldSexo() {
		return textFieldSexo;
	}

	public void setTextFieldSexo(JTextField textFieldSexo) {
		this.textFieldSexo = textFieldSexo;
	}

	public JTextField getTextFieldClub() {
		return textFieldClub;
	}

	public void setTextFieldClub(JTextField textFieldClub) {
		this.textFieldClub = textFieldClub;
	}

	public JTextField getTextFieldLicencia() {
		return textFieldLicencia;
	}

	public void setTextFieldLicencia(JTextField textFieldLicencia) {
		this.textFieldLicencia = textFieldLicencia;
	}

	public JTextField getTextFieldNombreTecnico() {
		return textFieldNombreTecnico;
	}

	public void setTextFieldNombreTecnico(JTextField textFieldNombreTecnico) {
		this.textFieldNombreTecnico = textFieldNombreTecnico;
	}

	public JTextField getTextFieldDNITecnico() {
		return textFieldDNITecnico;
	}

	public void setTextFieldDNITecnico(JTextField textFieldDNITecnico) {
		this.textFieldDNITecnico = textFieldDNITecnico;
	}

	public JTextField getTextFieldLicenciaTecnico() {
		return textFieldLicenciaTecnico;
	}

	public void setTextFieldLicenciaTecnico(JTextField textFieldLicenciaTecnico) {
		this.textFieldLicenciaTecnico = textFieldLicenciaTecnico;
	}

	public JTextField getTextFieldNombreTutor() {
		return textFieldNombreTutor;
	}

	public void setTextFieldNombreTutor(JTextField textFieldNombreTutor) {
		this.textFieldNombreTutor = textFieldNombreTutor;
	}

	public JTextField getTextFieldDNITutor() {
		return textFieldDNITutor;
	}

	public void setTextFieldDNITutor(JTextField textFieldDNITutor) {
		this.textFieldDNITutor = textFieldDNITutor;
	}

	public JCheckBox getChckbxAceptarDatos() {
		return chckbxAceptarDatos;
	}

	public void setChckbxAceptarDatos(JCheckBox chckbxAceptarDatos) {
		this.chckbxAceptarDatos = chckbxAceptarDatos;
	}

	public JCheckBox getChckbxTutor() {
		return chckbxTutor;
	}

	public void setChckbxTutor(JCheckBox chckbxTutor) {
		this.chckbxTutor = chckbxTutor;
	}

	public JButton getBtnCrearLicencia() {
		return btnCrearLicencia;
	}

	public void setBtnCrearLicencia(JButton btnCrearLicencia) {
		this.btnCrearLicencia = btnCrearLicencia;
	}
	public void Error(String error) {
		JOptionPane.showMessageDialog(this, error);
	}
}

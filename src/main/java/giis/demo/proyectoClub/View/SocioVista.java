package giis.demo.proyectoClub.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class SocioVista {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldDni;
	private JTextField textFieldFechaNacimiento;
	private JTextField textFieldSexo;
	private JTextField textFieldClub;
	private JTextField textFieldLicencia;
	private JTextField textFieldDniTecnico;
	private JTextField textFieldNombreTutor;
	private JTextField textFieldDniTutor;
	private JCheckBox  chckbxDatos;
	private JButton btnCrearLicencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocioVista window = new SocioVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SocioVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 1030, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Socio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 337, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Socio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 60, 176, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 96, 90, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 121, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 146, 148, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Club");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 196, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Licencia");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 221, 110, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(160, 95, 176, 20);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(160, 120, 176, 20);
		frame.getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setBounds(160, 145, 176, 20);
		frame.getContentPane().add(textFieldFechaNacimiento);
		textFieldFechaNacimiento.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(160, 170, 176, 20);
		frame.getContentPane().add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(160, 195, 176, 20);
		frame.getContentPane().add(textFieldClub);
		textFieldClub.setColumns(10);
		
		textFieldLicencia = new JTextField();
		textFieldLicencia.setBounds(160, 220, 176, 20);
		frame.getContentPane().add(textFieldLicencia);
		textFieldLicencia.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Datos Técnico");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(10, 300, 148, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_11 = new JLabel("Dni");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 394, 78, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		textFieldDniTecnico = new JTextField();
		textFieldDniTecnico.setBounds(160, 393, 176, 20);
		frame.getContentPane().add(textFieldDniTecnico);
		textFieldDniTecnico.setColumns(10);
		
		chckbxDatos = new JCheckBox("Acepto la cesion de mis datos personales");
		chckbxDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxDatos.setBounds(3, 466, 333, 23);
		frame.getContentPane().add(chckbxDatos);
		
		JLabel lblNewLabel_12 = new JLabel("Datos Tutor");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(628, 60, 193, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Nombre");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(628, 98, 78, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("DNI");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(628, 126, 46, 14);
		frame.getContentPane().add(lblNewLabel_14);
		
		textFieldNombreTutor = new JTextField();
		textFieldNombreTutor.setBounds(716, 95, 183, 20);
		frame.getContentPane().add(textFieldNombreTutor);
		textFieldNombreTutor.setColumns(10);
		
		textFieldDniTutor = new JTextField();
		textFieldDniTutor.setBounds(716, 120, 183, 20);
		frame.getContentPane().add(textFieldDniTutor);
		textFieldDniTutor.setColumns(10);
		
		btnCrearLicencia = new JButton("Crear Licencia");
		btnCrearLicencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearLicencia.setBounds(751, 447, 148, 44);
		frame.getContentPane().add(btnCrearLicencia);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldDni() {
		return textFieldDni;
	}

	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldDni = textFieldDni;
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

	

	public JTextField getTextFieldDniTecnico() {
		return textFieldDniTecnico;
	}

	public void setTextFieldDniTecnico(JTextField textFieldDniTecnico) {
		this.textFieldDniTecnico = textFieldDniTecnico;
	}

	

	public JTextField getTextFieldNombreTutor() {
		return textFieldNombreTutor;
	}

	public void setTextFieldNombreTutor(JTextField textFieldNombreTutor) {
		this.textFieldNombreTutor = textFieldNombreTutor;
	}

	public JTextField getTextFieldDniTutor() {
		return textFieldDniTutor;
	}

	public void setTextFieldDniTutor(JTextField textFieldDniTutor) {
		this.textFieldDniTutor = textFieldDniTutor;
	}

	public JCheckBox getChckbxDatos() {
		return chckbxDatos;
	}

	public void setChckbxDatos(JCheckBox chckbxDatos) {
		this.chckbxDatos = chckbxDatos;
	}

	public JButton getBtnCrearLicencia() {
		return btnCrearLicencia;
	}

	public void setBtnCrearLicencia(JButton btnCrearLicencia) {
		this.btnCrearLicencia = btnCrearLicencia;
	}
	
	public void Error(String error) {
		JOptionPane.showInputDialog(this, error);
	}
}

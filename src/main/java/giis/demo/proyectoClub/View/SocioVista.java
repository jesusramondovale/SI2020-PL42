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
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldFechaNacimiento;
	private JTextField textFieldSexo;
	private JTextField textFieldClub;
	private JTextField textFieldLicencia;
	private JTextField textFieldDniTecnico;
	private JTextField textFieldDniTutor;
	private JCheckBox  chckbxDatos;
	private JButton btnCrearLicencia;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldNumCuenta;
	private JLabel lblCuotaCalculada;
	private JLabel lblDatosTutor;
	private JLabel lblDniTutor;
	private JCheckBox chckbxMenor;

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
		lblNewLabel_2.setBounds(10, 121, 90, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 227, 148, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Club");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 288, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Licencia");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 313, 110, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(160, 95, 176, 20);
		frame.getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(160, 120, 176, 20);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setBounds(161, 226, 176, 20);
		frame.getContentPane().add(textFieldFechaNacimiento);
		textFieldFechaNacimiento.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(160, 257, 176, 20);
		frame.getContentPane().add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(160, 287, 176, 20);
		frame.getContentPane().add(textFieldClub);
		textFieldClub.setColumns(10);
		
		textFieldLicencia = new JTextField();
		textFieldLicencia.setBounds(160, 312, 176, 20);
		frame.getContentPane().add(textFieldLicencia);
		textFieldLicencia.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Datos Técnico");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(10, 389, 148, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_11 = new JLabel("Dni");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 414, 78, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		textFieldDniTecnico = new JTextField();
		textFieldDniTecnico.setBounds(160, 413, 176, 20);
		frame.getContentPane().add(textFieldDniTecnico);
		textFieldDniTecnico.setColumns(10);
		
		chckbxDatos = new JCheckBox("Acepto la cesion de mis datos personales");
		chckbxDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxDatos.setBounds(3, 466, 333, 23);
		frame.getContentPane().add(chckbxDatos);
		
		lblDatosTutor = new JLabel("Datos Tutor");
		lblDatosTutor.setEnabled(false);
		lblDatosTutor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosTutor.setBounds(628, 95, 193, 14);
		frame.getContentPane().add(lblDatosTutor);
		
		lblDniTutor = new JLabel("DNI");
		lblDniTutor.setEnabled(false);
		lblDniTutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDniTutor.setBounds(628, 121, 46, 14);
		frame.getContentPane().add(lblDniTutor);
		
		textFieldDniTutor = new JTextField();
		textFieldDniTutor.setEnabled(false);
		textFieldDniTutor.setBounds(716, 120, 183, 20);
		frame.getContentPane().add(textFieldDniTutor);
		textFieldDniTutor.setColumns(10);
		
		btnCrearLicencia = new JButton("Crear Licencia");
		btnCrearLicencia.setEnabled(false);
		btnCrearLicencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearLicencia.setBounds(751, 447, 148, 44);
		frame.getContentPane().add(btnCrearLicencia);
		
		JLabel lblNewLabel_9 = new JLabel("Apellido1");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 151, 129, 20);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Apellido2");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 182, 78, 20);
		frame.getContentPane().add(lblNewLabel_10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(160, 151, 176, 20);
		frame.getContentPane().add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(160, 184, 176, 20);
		frame.getContentPane().add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Numero de cuenta");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(10, 344, 129, 14);
		frame.getContentPane().add(lblNewLabel_15);
		
		textFieldNumCuenta = new JTextField();
		textFieldNumCuenta.setBounds(160, 343, 176, 20);
		frame.getContentPane().add(textFieldNumCuenta);
		textFieldNumCuenta.setColumns(10);
		
		lblCuotaCalculada = new JLabel("");
		lblCuotaCalculada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuotaCalculada.setBounds(628, 315, 268, 29);
		frame.getContentPane().add(lblCuotaCalculada);
		
		chckbxMenor = new JCheckBox("Soy menor , autorizado por un tutor");
		chckbxMenor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxMenor.setBounds(628, 59, 268, 23);
		frame.getContentPane().add(chckbxMenor);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldNombre() {
		return textFieldDni;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldDni = textFieldNombre;
	}

	public JTextField getTextFieldDni() {
		return textFieldNombre;
	}

	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldNombre = textFieldDni;
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
	
	

	

	public JTextField getTextFieldApellido1() {
		return textFieldApellido1;
	}

	public void setTextFieldApellido1(JTextField textFieldApellido1) {
		this.textFieldApellido1 = textFieldApellido1;
	}

	public JTextField getTextFieldApellido2() {
		return textFieldApellido2;
	}

	public void setTextFieldApellido2(JTextField textFieldApellido2) {
		this.textFieldApellido2 = textFieldApellido2;
	}

	public JTextField getTextFieldNumCuenta() {
		return textFieldNumCuenta;
	}

	public void setTextFieldNumCuenta(JTextField textFieldNumCuenta) {
		this.textFieldNumCuenta = textFieldNumCuenta;
	}

	public JTextField getTextFieldDniTecnico() {
		return textFieldDniTecnico;
	}

	public void setTextFieldDniTecnico(JTextField textFieldDniTecnico) {
		this.textFieldDniTecnico = textFieldDniTecnico;
	}

	

	/*public JTextField getTextFieldNombreTutor() {
		return textFieldNombreTutor;
	}

	public void setTextFieldNombreTutor(JTextField textFieldNombreTutor) {
		this.textFieldNombreTutor = textFieldNombreTutor;
	}*/

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
	
	
	
	public JLabel getLblCuotaCalculada() {
		return lblCuotaCalculada;
	}

	public void setLblCuotaCalculada(JLabel lblCuotaCalculada) {
		this.lblCuotaCalculada = lblCuotaCalculada;
	}
	
	

	public JLabel getLblDatosTutor() {
		return lblDatosTutor;
	}

	public void setLblDatosTutor(JLabel lblDatosTutor) {
		this.lblDatosTutor = lblDatosTutor;
	}

	public JLabel getLblDniTutor() {
		return lblDniTutor;
	}

	public void setLblDniTutor(JLabel lblDniTutor) {
		this.lblDniTutor = lblDniTutor;
	}

	public JCheckBox getChckbxMenor() {
		return chckbxMenor;
	}

	public void setChckbxMenor(JCheckBox chckbxMenor) {
		this.chckbxMenor = chckbxMenor;
	}

	public void Error(String error) {
		JOptionPane.showInputDialog(this, error);
	}
}

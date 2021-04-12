package giis.demo.proyectoClub.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class nuevoJuezVista {

	private JFrame frame;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldLicencia;
	private JTextField textFieldNumeroCuenta;
	private JCheckBox  chckbxDatos;
	private JButton btnCrearLicencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoJuezVista window = new nuevoJuezVista();
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
	public nuevoJuezVista() {
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
		
		JLabel lblNewLabel = new JLabel("Nuevo Juez");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 337, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Juez");
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
		
		JLabel lblNewLabel_4 = new JLabel("Primer Apellido");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 146, 148, 19);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Segundo Apellido");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 171, 110, 19);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nº de cuenta");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 221, 90, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Licencia");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 196, 110, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(160, 95, 176, 20);
		frame.getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(160, 120, 176, 20);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(160, 145, 176, 20);
		frame.getContentPane().add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(160, 170, 176, 20);
		frame.getContentPane().add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		textFieldLicencia = new JTextField();
		textFieldLicencia.setBounds(160, 195, 176, 20);
		frame.getContentPane().add(textFieldLicencia);
		textFieldLicencia.setColumns(10);
		
		textFieldNumeroCuenta = new JTextField();
		textFieldNumeroCuenta.setBounds(160, 220, 176, 20);
		frame.getContentPane().add(textFieldNumeroCuenta);
		textFieldNumeroCuenta.setColumns(10);
		
		chckbxDatos = new JCheckBox("Acepto la cesion de mis datos personales");
		chckbxDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxDatos.setBounds(3, 466, 333, 23);
		frame.getContentPane().add(chckbxDatos);
		
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
	
	public JTextField getTextFieldDni() {
		return textFieldDni;
	}

	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldDni = textFieldDni;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
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

	public JTextField getTextFieldLicencia() {
		return textFieldLicencia;
	}

	public void setTextFieldLicencia(JTextField textFieldLicencia) {
		this.textFieldLicencia = textFieldLicencia;
	}

	public JTextField getTextFieldNumeroCuenta() {
		return textFieldNumeroCuenta;
	}

	public void setTextFieldNumeroCuenta(JTextField textFieldNumeroCuenta) {
		this.textFieldNumeroCuenta = textFieldNumeroCuenta;
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

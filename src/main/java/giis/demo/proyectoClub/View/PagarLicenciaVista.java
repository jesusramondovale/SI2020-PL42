package giis.demo.proyectoClub.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class PagarLicenciaVista {

	private JFrame frame;
	private JTextField textFieldNumLicencia;
	private JComboBox comboBoxFormaDePago;
	private JLabel lblDatos1;
	private JButton btnPagar;
	private JLabel lblDatos2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagarLicenciaVista window = new PagarLicenciaVista();
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
	public PagarLicenciaVista() {
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
		
		JLabel lblNewLabel = new JLabel("PAGAR LICENCIA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 201, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de licencia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 47, 148, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldNumLicencia = new JTextField();
		textFieldNumLicencia.setBounds(171, 46, 201, 20);
		frame.getContentPane().add(textFieldNumLicencia);
		textFieldNumLicencia.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Forma de pago");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 72, 120, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		comboBoxFormaDePago = new JComboBox();
		comboBoxFormaDePago.setModel(new DefaultComboBoxModel(new String[] {"Trasfererncia"}));
		comboBoxFormaDePago.setBounds(171, 71, 201, 20);
		frame.getContentPane().add(comboBoxFormaDePago);
		
		JLabel lblNewLabel_3 = new JLabel("Datos Cuenta Bancaria del Club");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 127, 256, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPagar.setBounds(523, 43, 148, 48);
		frame.getContentPane().add(btnPagar);
		
		lblDatos1 = new JLabel("");
		lblDatos1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatos1.setBounds(10, 188, 317, 32);
		frame.getContentPane().add(lblDatos1);
		
		lblDatos2 = new JLabel("");
		lblDatos2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatos2.setBounds(10, 295, 317, 32);
		frame.getContentPane().add(lblDatos2);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	
	public JTextField getTextFieldNumLicencia() {
		return textFieldNumLicencia;
	}

	public void setTextFieldNumLicencia(JTextField textFieldNumLicencia) {
		this.textFieldNumLicencia = textFieldNumLicencia;
	}

	public JComboBox getComboBoxFormaDePago() {
		return comboBoxFormaDePago;
	}

	public void setComboBoxFormaDePago(JComboBox comboBoxFormaDePago) {
		this.comboBoxFormaDePago = comboBoxFormaDePago;
	}

	

	

	public JLabel getLblDatos1() {
		return lblDatos1;
	}

	public void setLblDatos1(JLabel lblDatos1) {
		this.lblDatos1 = lblDatos1;
	}

	public JLabel getLblDatos2() {
		return lblDatos2;
	}

	public void setLblDatos2(JLabel lblDatos2) {
		this.lblDatos2 = lblDatos2;
	}

	public JButton getBtnPagar() {
		return btnPagar;
	}

	public void setBtnPagar(JButton btnPagar) {
		this.btnPagar = btnPagar;
	}

	public void Error(String error) {
		JOptionPane.showInputDialog(this, error);
	}
}

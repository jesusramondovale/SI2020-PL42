package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class PagarLicenciaVista extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLicencia;
	private JComboBox comboBoxFormaDePago;
	private JTextPane textPaneDatos;
	private JButton btnPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagarLicenciaVista frame = new PagarLicenciaVista();
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
	public PagarLicenciaVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLicencia = new JLabel("Numero de Licencia");
		lblLicencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLicencia.setBounds(10, 32, 177, 14);
		contentPane.add(lblLicencia);
		
		textFieldLicencia = new JTextField();
		textFieldLicencia.setBounds(162, 30, 221, 20);
		contentPane.add(textFieldLicencia);
		textFieldLicencia.setColumns(10);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago");
		lblFormaDePago.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormaDePago.setBounds(10, 71, 102, 14);
		contentPane.add(lblFormaDePago);
		
		comboBoxFormaDePago = new JComboBox();
		comboBoxFormaDePago.setModel(new DefaultComboBoxModel(new String[] {"Transferencia"}));
		comboBoxFormaDePago.setToolTipText("");
		comboBoxFormaDePago.setBounds(162, 69, 221, 20);
		contentPane.add(comboBoxFormaDePago);
		
		JLabel lblDatosCuenta = new JLabel("DATOS DE LA CUENTA BANCARIA DEL CLUB");
		lblDatosCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDatosCuenta.setBounds(10, 159, 361, 14);
		contentPane.add(lblDatosCuenta);
		
		textPaneDatos = new JTextPane();
		textPaneDatos.setBounds(10, 191, 532, 354);
		contentPane.add(textPaneDatos);
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPagar.setBounds(10, 631, 157, 62);
		contentPane.add(btnPagar);
		
		
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextFieldLicencia() {
		return textFieldLicencia;
	}

	public void setTextFieldLicencia(JTextField textFieldLicencia) {
		this.textFieldLicencia = textFieldLicencia;
	}

	public JComboBox getComboBoxFormaDePago() {
		return comboBoxFormaDePago;
	}

	public void setComboBoxFormaDePago(JComboBox comboBoxFormaDePago) {
		this.comboBoxFormaDePago = comboBoxFormaDePago;
	}

	public JTextPane getTextPaneDatos() {
		return textPaneDatos;
	}

	public void setTextPaneDatos(JTextPane textPaneDatos) {
		this.textPaneDatos = textPaneDatos;
	}

	public JButton getBtnPagar() {
		return btnPagar;
	}

	public void setBtnPagar(JButton btnPagar) {
		this.btnPagar = btnPagar;
	}
}

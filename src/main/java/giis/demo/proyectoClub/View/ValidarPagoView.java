package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ValidarPagoView extends JFrame {
	
	private JFrame ValidarPago;
	private JLabel lSeleccion;
	private JRadioButton rbLicencia;
	private JButton bCancelar, bGenerarFichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidarPagoView frame = new ValidarPagoView();
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
	public ValidarPagoView() {
		
		initialize();
		
	}
	
	public void initialize() {
		
		ValidarPago = new JFrame();
		ValidarPago.setTitle("Validación de pagos");
		ValidarPago.setBounds(100, 100, 614, 474);
		ValidarPago.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ValidarPago.getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		lSeleccion = new JLabel("Seleccione pago a comprobar:");
		lSeleccion.setBounds(38, 33, 182, 14);
		getContentPane().add(lSeleccion);
		
		rbLicencia = new JRadioButton("Licencia");
		rbLicencia.setBounds(68, 60, 111, 23);
		getContentPane().add(rbLicencia);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(38, 115, 89, 23);
		getContentPane().add(bCancelar);
		
		bGenerarFichero = new JButton("Generar fichero de movimientos");
		bGenerarFichero.setEnabled(false);
		bGenerarFichero.setBounds(197, 115, 202, 23);
		getContentPane().add(bGenerarFichero);
		
	}
	
	public JFrame getValidarPago() {
		return ValidarPago;
	}

	public void setValidarPago(JFrame validarPago) {
		ValidarPago = validarPago;
	}

	public JRadioButton getRbLicencia() {
		return rbLicencia;
	}

	public void setRbLicencia(JRadioButton rbLicencia) {
		this.rbLicencia = rbLicencia;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbGenerarFichero() {
		return bGenerarFichero;
	}

	public void setbGenerarFichero(JButton bGenerarFichero) {
		this.bGenerarFichero = bGenerarFichero;
	}
	
	
}

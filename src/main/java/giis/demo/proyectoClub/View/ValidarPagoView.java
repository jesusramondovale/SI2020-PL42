package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;

public class ValidarPagoView extends JFrame {
	
	private JFrame ValidarPago;
	private JLabel lSeleccion;
	private JButton bTramitar, bCancelar, bSeleccion, bAceptar;
	private JTextField tfSeleccion;
	private JCheckBox cbAlbaran;

	/**
	 * Create the application.
	 */
	public ValidarPagoView() {
		
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		ValidarPago = new JFrame();
		ValidarPago.setTitle("Validación de pagos");
		ValidarPago.setBounds(100, 100, 614, 474);
		ValidarPago.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ValidarPago.getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		lSeleccion = new JLabel("Seleccionar fichero:");
		lSeleccion.setBounds(35, 70, 126, 14);
		getContentPane().add(lSeleccion);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(35, 175, 89, 23);
		getContentPane().add(bCancelar);
		
		bTramitar = new JButton("Tramitar licencias");
		bTramitar.setEnabled(false);
		bTramitar.setBounds(232, 124, 153, 23);
		getContentPane().add(bTramitar);
		
		tfSeleccion = new JTextField();
		tfSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfSeleccion.setForeground(Color.GRAY);
		tfSeleccion.setText("Seleccionar fichero de pago");
		tfSeleccion.setEditable(false);
		tfSeleccion.setBounds(171, 67, 140, 20);
		getContentPane().add(tfSeleccion);
		tfSeleccion.setColumns(10);
		
		bSeleccion = new JButton("Explorar");
		bSeleccion.setBounds(321, 66, 89, 23);
		getContentPane().add(bSeleccion);
		
		cbAlbaran = new JCheckBox("Generar albarán");
		cbAlbaran.setBounds(35, 124, 159, 23);
		getContentPane().add(cbAlbaran);
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(232, 175, 153, 23);
		getContentPane().add(bAceptar);
		
	}
	
	public JFrame getValidarPago() {
		return ValidarPago;
	}

	public void setValidarPago(JFrame validarPago) {
		ValidarPago = validarPago;
	}

	public JButton getbActualizar() {
		return bTramitar;
	}

	public void setbActualizar(JButton bActualizar) {
		this.bTramitar = bActualizar;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbSeleccion() {
		return bSeleccion;
	}

	public void setbSeleccion(JButton bSeleccion) {
		this.bSeleccion = bSeleccion;
	}

	public JTextField getTfSeleccion() {
		return tfSeleccion;
	}
	
	public void setTfSeleccion(JTextField tfSeleccion) {
		this.tfSeleccion = tfSeleccion;
	}

	/**
	 * @return the bTramitar
	 */
	public JButton getbTramitar() {
		return bTramitar;
	}

	/**
	 * @param bTramitar the bTramitar to set
	 */
	public void setbTramitar(JButton bTramitar) {
		this.bTramitar = bTramitar;
	}

	/**
	 * @return the bAceptar
	 */
	public JButton getbAceptar() {
		return bAceptar;
	}

	/**
	 * @param bAceptar the bAceptar to set
	 */
	public void setbAceptar(JButton bAceptar) {
		this.bAceptar = bAceptar;
	}

	/**
	 * @return the cbAlbaran
	 */
	public JCheckBox getCbAlbaran() {
		return cbAlbaran;
	}

	/**
	 * @param cbAlbaran the cbAlbaran to set
	 */
	public void setCbAlbaran(JCheckBox cbAlbaran) {
		this.cbAlbaran = cbAlbaran;
	}
	
}

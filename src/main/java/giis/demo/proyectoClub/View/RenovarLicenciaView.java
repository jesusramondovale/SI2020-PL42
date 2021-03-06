package giis.demo.proyectoClub.View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RenovarLicenciaView {
	
	private JFrame RenovarLicencia;
	private JLabel NLicencia;
	public JTextField tfNLicencia;
	public JCheckBox cbDatos;
	private JButton bCancelar;
	public JButton bAceptar;
	
	/**
	 * Create the application.
	 */
	public RenovarLicenciaView() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		RenovarLicencia = new JFrame();
		RenovarLicencia.setTitle("Renovar licencia");
		RenovarLicencia.getContentPane().setLayout(null);
		
		NLicencia = new JLabel("Nº de licencia: ");
		NLicencia.setBounds(30, 74, 80, 18);
		RenovarLicencia.getContentPane().add(NLicencia);
		
		tfNLicencia = new JTextField("", 20);
		tfNLicencia.setBounds(112, 73, 229, 20);
		RenovarLicencia.getContentPane().add(tfNLicencia);
		
		cbDatos = new JCheckBox("*Doy mi consentimiento para la cesión de datos", false);
		cbDatos.setBounds(30, 120, 273, 30);
		RenovarLicencia.getContentPane().add(cbDatos);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(46, 200, 100, 30);
		RenovarLicencia.getContentPane().add(bCancelar);
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setEnabled(false);
		bAceptar.setBounds(280, 200, 100, 30);
		RenovarLicencia.getContentPane().add(bAceptar);
		
	}
	
	public JFrame getFrame() {
		return this.RenovarLicencia;
	}

	public JLabel getNLicencia() {
		return NLicencia;
	}

	public void setNLicencia(JLabel nLicencia) {
		this.NLicencia = nLicencia;
	}

	public JTextField getTfNLicencia() {
		return tfNLicencia;
	}

	public void setTfNLicencia(JTextField tfNLicencia) {
		this.tfNLicencia = tfNLicencia;
	}

	public JCheckBox getCbDatos() {
		return cbDatos;
	}

	public void setCbDatos(JCheckBox cbDatos) {
		this.cbDatos = cbDatos;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbAceptar() {
		return bAceptar;
	}

	public void setbAceptar(JButton bAceptar) {
		this.bAceptar = bAceptar;
	}
	
		
	
}

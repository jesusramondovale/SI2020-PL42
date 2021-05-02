package giis.demo.proyectoClub.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EditarInstalacionesView extends JFrame {

	private JFrame EditarInstalaciones;
	private JLabel lblNewLabel, lblNewLabel_1;
	private JSlider slider;
	private JComboBox cbDias;
	private JButton bAceptar, bCancelar;
	
	/**
	 * Create the application.
	 */
	
	public EditarInstalacionesView() {
		initialize();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		
		EditarInstalaciones = new JFrame();
		EditarInstalaciones.setTitle("Estado de alarma");
		EditarInstalaciones.setBounds(400, 400, 375, 279);
		EditarInstalaciones.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Seleccione el nivel de estado de alarma:");
		lblNewLabel.setBounds(10, 39, 448, 14);
		EditarInstalaciones.getContentPane().add(lblNewLabel);
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(1);
		slider.setMaximum(4);
		slider.setBounds(49, 75, 220, 19);
		EditarInstalaciones.getContentPane().add(slider);
		
		lblNewLabel_1 = new JLabel("Tiempo de duración (en días):");
		lblNewLabel_1.setBounds(10, 136, 192, 14);
		EditarInstalaciones.getContentPane().add(lblNewLabel_1);
		
		cbDias = new JComboBox();
		cbDias.setModel(new DefaultComboBoxModel(new String[] {"Días", "7", "15", "20", "30"}));
		cbDias.setBounds(189, 132, 59, 22);
		EditarInstalaciones.getContentPane().add(cbDias);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(26, 198, 89, 23);
		EditarInstalaciones.getContentPane().add(bCancelar);
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(245, 198, 89, 23);
		EditarInstalaciones.getContentPane().add(bAceptar);
	}

	public JFrame getFrame() {
		return this.EditarInstalaciones;
	}

	public JSlider getSlider() {
		return slider;
	}

	public void setSlider(JSlider slider) {
		this.slider = slider;
	}

	public JComboBox getCbDias() {
		return cbDias;
	}

	public void setCbDias(JComboBox cbDias) {
		this.cbDias = cbDias;
	}

	public JButton getbAceptar() {
		return bAceptar;
	}

	public void setbAceptar(JButton bAceptar) {
		this.bAceptar = bAceptar;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}
	
	
}

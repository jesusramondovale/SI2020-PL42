package giis.demo.proyectoClub.Controller;

import giis.demo.proyectoClub.model.*;
import giis.demo.util.SwingUtil;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import giis.demo.proyectoClub.View.*;

/**
 * Controlador para la funcionalidad de visualizacion de carreras para la inscripcion.
 * Es el punto de entrada de esta pantalla que se invocará:
 * -instanciando el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class RenovarLicenciaController {
	
	RenovarLicenciaModel model;
	RenovarLicenciaView view;
	private String lastSelectedKey=" "; //recuerda la ultima fila seleccionada para restaurarla

	public RenovarLicenciaController(RenovarLicenciaModel m, RenovarLicenciaView v) {
		this.model = m;
		this.view = v;
		
		boolean activar = false;
		
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
		view.bAceptar.setVisible(false);
	}
	
	public void initController() {
		
		this.initView();
		
		view.getCbDatos().addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				SwingUtil.exceptionWrapper(() -> getActivarBoton());
			}
		});
			
		view.getbAceptar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarRecibo()));					
	}
	
	public void getActivarBoton() {
		
		if((view.cbDatos.isEnabled()) && (view.tfNLicencia.getText().length() != 0)) {
			view.bAceptar.setVisible(true);
		}
		else {
			view.bAceptar.setVisible(false);
		}
	}
	
	/**
	 * Método que actualiza el estado de la licencia
	 * Al pulsar sobre el botón Aceptar se avisará mediante un JDialog y se generará un recibo
	 */
	public void updateEstadoLicencia() {
		String numLicencia = view.getTfNLicencia().getText();
		model.updateEstadoLicencia(numLicencia);
		JOptionPane pane = new JOptionPane("La licencia se ha renovado correctamente", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
		JDialog d = pane.createDialog(pane, "Licencia renovada");
		d.setLocation(200, 200);
		d.setVisible(true);
		
	}
	
	public void generarRecibo() {
		FileWriter f;
		try {
			f = new FileWriter("C:\\Users\\inipi\\SI2020-PL42\\src\\main\\java\\giis\\demo\\proyectoClub\\ReciboRLicencia.txt");
			String numLicencia = view.getTfNLicencia().getText();
			f.write("RECIBO DE RENOVACIÓN DE LA LICENCIA\n\n"
					+ "Usuario con licencia número: " + numLicencia 
					+ "Total a pagar: "
					+ "\nLICENCIA PENDIENTE DE PAGO");
			JOptionPane.showMessageDialog(null, "El recibo de la renovación de la licencia ha sido generado", "Recibo renovacion licencia", JOptionPane.OK_OPTION);
			f.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

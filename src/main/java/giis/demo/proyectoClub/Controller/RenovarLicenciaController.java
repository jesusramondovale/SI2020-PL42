package giis.demo.proyectoClub.Controller;

import giis.demo.proyectoClub.model.*;
import giis.demo.util.SwingUtil;
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
		
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}
	
	/**
	 * Método que actualiza el estado de la licencia
	 * Al pulsar sobre el botón Aceptar se avisará mediante un JDialog y se generará un recibo
	 */
	public void updateEstadoLicencia() {
		String numLicencia = SwingUtil.getText(view.getTfNLicencia());
		model.updateEstadoLicencia(numLicencia);
	}
	
	
}

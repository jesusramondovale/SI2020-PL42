package giis.demo.proyectoClub.Controller;

import java.util.Date;

import javax.swing.JOptionPane;

import giis.demo.proyectoClub.Model.GenerarInformeSemanalModel;
import giis.demo.proyectoClub.View.GenerarInformeSemanalView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class GenerarInformeSemanalController {

	private GenerarInformeSemanalView view;
	private GenerarInformeSemanalModel model;
	
	
	public GenerarInformeSemanalController(GenerarInformeSemanalView view, GenerarInformeSemanalModel model) {
		
		this.view = view;
		this.model = model;
		this.initView();
		
	}


	private void initView() {
		
		this.view.getFrame().setVisible(true);
			
		
	}
	
	public void initController(){
		
		this.view.getFrame().setVisible(true);
		
		view.getBtnGenerarInforme().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
						generarInforme( Util.isoStringToDate(view.getTxtFechaIni()), Util.isoStringToDate((view.getTxtFechaFin())))));
		
		
	}


	private void generarInforme(Date fechaIni , Date fechaFin) {

		//Delega en la capa modelo
		model.generarInforme(fechaIni, fechaFin);
		JOptionPane.showMessageDialog(null, "Informe creado con exito!");

		
	}
	
	
	
	
	
	
}

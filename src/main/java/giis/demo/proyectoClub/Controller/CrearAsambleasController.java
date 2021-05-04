package giis.demo.proyectoClub.Controller;

import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;


import org.apache.commons.lang3.math.NumberUtils;

//import giis.demo.ProyectoClub.DTO.CrearAsambleasDTO;
import giis.demo.proyectoClub.Model.CrearAsambleasModel;
import giis.demo.proyectoClub.View.CrearAsambleasView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;


public class CrearAsambleasController {

	private CrearAsambleasModel model; // No se usa 
	private CrearAsambleasView view;
	
	
	
	
	
	public CrearAsambleasController(CrearAsambleasModel m, CrearAsambleasView v) {
		this.model = m;
		this.view = v;
		
		
		this.initView();

	}

	public void initView(){
		view.getFrame().setVisible(true);
	}

	public void initController(){

		view.getFrame().setVisible(true);
		view.getBtnCrearAsamblea().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarAsamblea()));
	}

	public void generarAsamblea() {
		
		
		
		
		if ( (view.getTxtOrdenDia().length()==0) || (view.getID().length() == 0) || !(NumberUtils.isParsable(view.getID()))){
			JOptionPane.showMessageDialog(null, "ERROR! Debe indicar un ID y un Orden del día!");
		}
		else {
			int idAsamblea; 
			String tipo = null;
			String ordenDia , hora1, hora2;
			String fechaAsamblea;
			Date fecha;

			idAsamblea = Integer.parseInt(this.view.getID());


			for (Enumeration<AbstractButton> buttons = this.view.getButtonGroup().getElements(); buttons.hasMoreElements();) {
				AbstractButton button = (AbstractButton) buttons.nextElement();

				if (button.isSelected()) {
					tipo = button.getText();
				}
			}

			ordenDia = this.view.getTxtOrdenDia();
			hora1 = this.view.getTxtHora1();
			hora2 = this.view.getTxtHora2();

			fechaAsamblea = this.view.getTxtFecha();
			fecha = Util.isoStringToDate(fechaAsamblea);

			// Delega en la capa modelo la consulta
			model.generarAsamblea(idAsamblea,  tipo,  ordenDia,  fecha,  hora1,  hora2, this.view.getID(), this.view.getTxtFecha());

		}
	}

}

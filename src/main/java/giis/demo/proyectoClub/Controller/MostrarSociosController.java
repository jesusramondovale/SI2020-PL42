package giis.demo.proyectoClub.Controller;

import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import giis.demo.proyectoClub.DTO.MostrarSociosDTO;
import giis.demo.proyectoClub.Model.MostrarSociosModel;
import giis.demo.proyectoClub.View.MostrarSociosView;
import giis.demo.util.SwingUtil;


public class MostrarSociosController {

	private MostrarSociosView view;
	private MostrarSociosModel model;

	public MostrarSociosController(MostrarSociosModel model ,MostrarSociosView view ) {

		this.view = view;
		this.model = model;
		this.initView();

	}


	public void initView() {
		this.view.getFrame().setVisible(true);

	}


	public void initController(){

		this.view.getFrame().setVisible(true);
		view.getBtnNewButton().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaSocios()));
		view.getBtnReset().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reseteaListaSocios()));

		for (Enumeration<AbstractButton> buttons = this.view.getButtonGroup().getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();
			button.addActionListener(e -> SwingUtil.exceptionWrapper(() -> reseteaListaSocios()));

		}
	}

	public void getListaSocios() {

		int orden = 0;
		int i = 0;
		List<MostrarSociosDTO> socios = null;
		if (view.getTfNombre().getText().length() == 0 || 
				view.getTfApellido().getText().length()==0	||
				view.getTfRangoFin().getText().length()==0 ||
				view.getTfRangoIni().getText().length()==0){

			JOptionPane.showMessageDialog(null ,"Error! Debe indicar los parámetros.");

		}

		else {


			for (Enumeration<AbstractButton> buttons = this.view.getButtonGroup().getElements(); buttons.hasMoreElements();) {
				AbstractButton button = (AbstractButton) buttons.nextElement();
				i++;
				if (button.isSelected()) {
					orden = i;
				}
			}

			if(orden==0){
				socios=model.getListaSocios(view.getTfNombre().getText(),
						view.getTfApellido().getText(),
						Integer.parseInt(view.getTfRangoIni().getText()),
						Integer.parseInt(view.getTfRangoFin().getText()));
			}
			else if (orden==1){
				socios=model.getListaSociosNumero(view.getTfNombre().getText(),
						view.getTfApellido().getText(),
						Integer.parseInt(view.getTfRangoIni().getText()),
						Integer.parseInt(view.getTfRangoFin().getText()));
			}
			else if (orden==2){
				socios=model.getListaSociosNombre(view.getTfNombre().getText(),
						view.getTfApellido().getText(),
						Integer.parseInt(view.getTfRangoIni().getText()),
						Integer.parseInt(view.getTfRangoFin().getText()));
			}
			else if (orden==3){
				socios=model.getListaSociosApellido(view.getTfNombre().getText(),
						view.getTfApellido().getText(),
						Integer.parseInt(view.getTfRangoIni().getText()),
						Integer.parseInt(view.getTfRangoFin().getText()));
			}


			// Crea un objeto tabla del GUI con los valores devueltos de las instalaciones
			TableModel tmodel=SwingUtil.getTableModelFromPojos(socios, new String[] { 
					"idSocio", "dniSocio" ,"numLicencia", "nombreSocio" });

			// Asigna a la tabla de la vista el modelo generado
			view.getTable().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTable());
		}
	}



	public void reseteaListaSocios(){

		int orden = 0;
		int i = 0;
		List<MostrarSociosDTO> socios = null;

		for (Enumeration<AbstractButton> buttons = this.view.getButtonGroup().getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();
			i++;
			if (button.isSelected()) {
				orden = i;
			}
		}

		if(orden==0){
			socios=model.getListaSociosTrasBorrado();
		}
		else if (orden==1){
			socios=model.getListaSociosTrasBorradoNumero();
		}
		else if (orden==2){
			socios=model.getListaSociosTrasBorradoNombre();
		}
		else if (orden==3){
			socios=model.getListaSociosTrasBorradoApellido();
		}



		// Crea un objeto tabla del GUI con los valores devueltos de las instalaciones
		TableModel tmodel=SwingUtil.getTableModelFromPojos(socios, new String[] { 
				"idSocio", "dniSocio" ,"numLicencia", "nombreSocio" });

		// Asigna a la tabla de la vista el modelo generado
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}


}

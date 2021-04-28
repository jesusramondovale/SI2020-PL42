package giis.demo.proyectoClub.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import giis.demo.proyectoClub.Model.GenerarActaModel;
import giis.demo.proyectoClub.View.GenerarActaView;
import giis.demo.util.SwingUtil;

public class GenerarActaController {

	private GenerarActaView view;
	private GenerarActaModel model;

	// Mapas Clave-Valor que almacenen, para cada propuesta insertada, una lista de IDs de socios
	private Map<String, List<Integer>> propsFavor;
	private Map<String, List<Integer>> propsContra;

	// listas de IDs de socios
	private List<Integer> sociosFavor; 
	private List<Integer> sociosContra;

	//Orden del día de la Asamblea
	private String ordenDia;



	


	public GenerarActaController(GenerarActaView view, GenerarActaModel model) {

		this.view = view;
		this.model = model;
		this.initView();

		propsFavor = new HashMap<String, List<Integer>>();
		propsContra = new HashMap<String, List<Integer>>();

		sociosFavor = new ArrayList<Integer>();
		sociosContra = new ArrayList<Integer>();

		
	}

	public void initView(){

		this.view.getFrame().setVisible(true);
		

		
	}

	
	public void initController(){
		
		this.view.getFrame().setVisible(true);
		
		this.view.getBtnSocioContra().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
		insertarSocioContra(this.view.getTfIDContra().getText())));

		this.view.getBtnSocioFavor().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
		insertarSocioFavor(this.view.getTfIDFavor().getText())));

		this.view.getBtnAnadirGeneral().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
		insertarPropuesta()));

		this.view.getBtnReset().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
		reset()));

		this.view.getBtnCrearActa().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
		crearActa()));

		this.view.getBtnOk().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
		rellenarOrdenDia(Integer.parseInt(this.view.getTfAsamblea().getText()))));
	}




	private void rellenarOrdenDia(int id) {

		// La capa modelo ejecuta la query 
		
		ordenDia = this.model.obtenerOrdenDia(id); 
		this.view.getTfResumen().setText(ordenDia);
		
	}


	private void crearActa() {

		//Delega en la capa modelo, le proporciona sus dos Maps para que elabore el fichero
		if (propsFavor.isEmpty() || propsContra.isEmpty()){

			JOptionPane.showMessageDialog(null, "Primero debe añadir algunas propuestas");
		}

		else if (this.view.getTfResumen().getText().length() == 0 ||
				this.view.getTfResumen().getText().equals("No existe ninguna asamblea con el ID proporcionado!")){

			JOptionPane.showMessageDialog(null, "Debe seleccionar un ID de asamblea válido!");

		}

		else {

			this.model.generarActa(Integer.parseInt(this.view.getTfAsamblea().getText()) , ordenDia, propsFavor, propsContra);
			JOptionPane.showMessageDialog(null, "Acta elaborada con éxito!");
		}


	}


	public void insertarSocioContra(String id){

		if (id == "" || id.contains(" ")){

			JOptionPane.showMessageDialog(null, "Introduzca un ID de socio en contra válido!");
		}

		else {
			sociosContra.add(Integer.parseInt(id));
			this.view.getTfIDContra().setText("");
			this.view.getBtnSocioContra().setEnabled(false);
		}

	}


	public void insertarSocioFavor(String id){

		if (id == "" || id.contains(" ")){

			JOptionPane.showMessageDialog(null, "Introduzca un ID de socio a favor válido!");
		}

		else {
			sociosFavor.add(Integer.parseInt(id));
			this.view.getTfIDFavor().setText("");
			this.view.getBtnSocioFavor().setEnabled(false);
		}

	}


	public void insertarPropuesta(){

		if (this.view.getTfPropuestas().getText().length() == 0){
			JOptionPane.showMessageDialog(null, "Debe introducir la descripción de la propuesta primero!");

		}

		else if (sociosFavor.isEmpty() || sociosContra.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe introducir los votos a favor y en contra primero!");

		}

		else {

			
			propsFavor.put(this.view.getTfPropuestas().getText(), (new ArrayList<Integer>(sociosFavor)));
			//System.out.println("A favor: " + propsFavor.toString());
			
			propsContra.put(this.view.getTfPropuestas().getText(), (new ArrayList<Integer>(sociosContra)));
			//System.out.println("En contra: " + propsContra.toString());

			sociosContra.clear();
			sociosFavor.clear();
			
			
			this.view.getTfPropuestas().setText("");

		}

	}

	
	public GenerarActaView getView() {
		return view;
	}


	public void reset() {

		this.view.getTfIDContra().setText("");
		this.view.getTfIDFavor().setText("");
		this.view.getTfPropuestas().setText("");
		this.view.getTfResumen().setText("");

		ordenDia = "";
		sociosFavor.clear();
		sociosContra.clear();
		propsFavor.clear();
		propsContra.clear();
	}


	public void setView(GenerarActaView view) {
		this.view = view;
	}
	public GenerarActaModel getModel() {
		return model;
	}
	public void setModel(GenerarActaModel model) {
		this.model = model;
	}

	public String getOrdenDia() {
		return ordenDia;
	}


	public void setOrdenDia(String ordenDia) {
		this.ordenDia = ordenDia;
	}



}

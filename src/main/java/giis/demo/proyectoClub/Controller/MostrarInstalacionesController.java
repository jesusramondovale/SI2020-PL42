package giis.demo.proyectoClub.Controller;


import java.util.List;


import javax.swing.table.TableModel;
import giis.demo.proyectoClub.DTO.MostrarInstalacionesDTO;
import giis.demo.proyectoClub.model.MostrarInstalacionesModel;
import giis.demo.proyectoClub.View.MostrarInstalacionesView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class MostrarInstalacionesController {

	private MostrarInstalacionesModel model;
	private MostrarInstalacionesView view;
	
	public MostrarInstalacionesController(MostrarInstalacionesModel m, MostrarInstalacionesView v){
	
		this.model = m;
		this.view = v;
		this.initView();
	
	}
	
	public void initView() {
		
		this.view.getFrame().setVisible(true);
		
	}
	
	public void initController(){
		
		this.view.getFrame().setVisible(true);
		
		//Funcion del botón APLICAR FILTRO -> Muestra la lista de instalaciones 
		view.getBtnAplicarFiltro().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaInstalaciones()));
	
		//Funcion del botón BORRAR FILTRO -> Resetea el filtro
	    view.getBtnBorrarFiltro().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reseteaTablaInstalaciones())) ;
	
	}
	
	
	/**
	 * La obtencion de la lista de instalaciones solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void getListaInstalaciones() {
		
		//System.out.println("\n Fecha seleccionada : " + view.getFecha() );
		//System.out.println("\n Tipo seleccionado : " + view.getTipo());
		
		// Delega en la capa Modelo para que se encargue de ejecutar las consultas
		List<MostrarInstalacionesDTO> instalaciones=model.getListaInstalaciones(Util.isoStringToDate(view.getFecha()),view.getTipo());
		//System.out.println("\n Aqui llega" );
		
		// Crea un objeto tabla del GUI con los valores devueltos de las instalaciones
		TableModel tmodel=SwingUtil.getTableModelFromPojos(instalaciones, new String[] { 
										"idReserva", "idSocio" , "instalacion", "fechaReserva", "horaInicio", "horaFin"});
		
		// Asigna a la tabla de la vista el modelo generado
		view.getTablaInstalaciones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaInstalaciones());
			
	}
	
	public void reseteaTablaInstalaciones(){
		
		// Delega en la capa Modelo para que se encargue de ejecutar las consultas
		List<MostrarInstalacionesDTO> instalaciones=model.getInstalacionesTrasBorrado();
		
		// Crea un objeto tabla del GUI con los datos devueltos de las consultas 
		TableModel tmodel=SwingUtil.getTableModelFromPojos(instalaciones, new String[] {
										"idReserva", "idSocio" ,"instalacion","fechaReserva", "horaInicio", "horaFin"});
		
		// Asigna a la nueva tabla reseteada de la vista el modelo generado
		view.getTablaInstalaciones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaInstalaciones());
		
	}
}

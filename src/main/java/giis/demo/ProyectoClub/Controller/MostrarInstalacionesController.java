package giis.demo.ProyectoClub.Controller;

import java.sql.Date;
import java.util.List;


import javax.swing.table.TableModel;

import giis.demo.ProyectoClub.DTO.MostrarInstalacionesDTO;
import giis.demo.ProyectoClub.Model.MostrarInstalacionesModel;
import giis.demo.ProyectoClub.View.MostrarInstalacionesView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class MostrarInstalacionesController {

	private MostrarInstalacionesModel model;
	private MostrarInstalacionesView view;
	
	
	public void initView() {
		
		
		
		this.view.getFrame().setVisible(true);
	}
	
	public void initController(){
		
		//Funcion del botón APLICAR FILTRO -> Muestra la lista de instalaciones 
		view.getBtnAplicarFiltro().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaInstalaciones()));
	
		//Funcion del botón BORRAR FILTRO -> Resetea el filtro
	    view.getBtnBorrarFiltro().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reseteaTablaInstalaciones())) ;
	
	}
	
	
	public MostrarInstalacionesController(MostrarInstalacionesModel m, MostrarInstalacionesView v){
	
		this.model = m;
		this.view = v;
	
	}
	
	public void getListaInstalaciones() {
		
		List<MostrarInstalacionesDTO> listaInstalaciones=model.getListaInstalaciones((Date) Util.isoStringToDate(view.getFecha()),view.getTipo());
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listaInstalaciones, new String[] {"TIPO", "FECHA", "HORA DE INICIO", "HORA DE FIN"});
		
		view.getTablaInstalaciones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaInstalaciones());
			
	}
	
	public void reseteaTablaInstalaciones(){
		
		List<MostrarInstalacionesDTO> listaInstalaciones=model.getInstalacionesTrasBorrado();
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listaInstalaciones, new String[] {"TIPO", "FECHA", "HORA DE INICIO", "HORA DE FIN"});
		
		view.getTablaInstalaciones().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaInstalaciones());
		
	}
}

package giis.demo.proyectoClub.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import giis.demo.proyectoClub.DTO.JuezDTO;
import giis.demo.proyectoClub.DTO.LicenciaDTO;

import giis.demo.proyectoClub.View.nuevoJuezVista;

import giis.demo.proyectoClub.model.NuevoJuezModel;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

/**
 * Controlador para la funcionalidad de visualizacion de carreras para la inscripcion.
 * Es el punto de entrada de esta pantalla que se invocará:
 * -instanciando el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class NuevoJuezControlador {
	private NuevoJuezModel model;
	private nuevoJuezVista view;
	
	float cuota;
	
	JuezDTO juez;
	
	LicenciaDTO licencia;

	public NuevoJuezControlador(NuevoJuezModel m, nuevoJuezVista v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		//ActionListener define solo un metodo actionPerformed(), es un interfaz funcional que se puede invocar de la siguiente forma:
		//view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		view.getBtnCrearLicencia().addActionListener(e -> SwingUtil.exceptionWrapper(() -> introduceDatos()));
	
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		//view.getTablaCarreras().addMouseListener(new MouseAdapter() {
			//@Override
			//public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				//SwingUtil.exceptionWrapper(() -> updateDetail());
			//}
		//});
	}
	
	public void initView() {
		view.getFrame().setVisible(true); 
		//if(view.getChckbxDatos().isSelected()) {
			//view.getBtnCrearLicencia().setVisible(true);
		//}
		//else {
			//view.getBtnCrearLicencia().setVisible(false);
		//}
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		
	}
	
	
	public void introduceDatos() {
		cuota=(float) 27.00;
		int id_Juez=model.NextID("idJuez","juez");
		int id_Licencia=model.NextID("idLicencia", "Licencia");
		//tecnico= new TecnicoDTO(id_Tecnico,view.getTextFieldNombreTecnico().getText(),view.getTextFieldDNITecnico().getText(),view.getTextFieldLicenciaTecnico().getText());
		licencia= new LicenciaDTO(id_Licencia,view.getTextFieldLicencia().getText(),"Pendiente de Pago");
		
			juez=new JuezDTO(id_Juez,view.getTextFieldDni().getText(),view.getTextFieldNombre().getText(),view.getTextFieldApellido1().getText(),
					view.getTextFieldApellido2().getText(),view.getTextFieldLicencia().getText(),view.getTextFieldNumeroCuenta().getText(),cuota);
			
			model.nuevoJuez(juez);
			model.nuevaLicencia(licencia);
		
		
	}
	
}

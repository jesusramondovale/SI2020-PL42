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

import giis.demo.proyectoClub.DTO.LicenciaDTO;
import giis.demo.proyectoClub.DTO.SocioDTO;
import giis.demo.proyectoClub.DTO.TecnicoDTO;
import giis.demo.proyectoClub.View.NuevoSocioVista;
import giis.demo.proyectoClub.model.NuevoSocioModelo;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

/**
 * Controlador para la funcionalidad de visualizacion de carreras para la inscripcion.
 * Es el punto de entrada de esta pantalla que se invocará:
 * -instanciando el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class NuevoSocioControlador {
	private NuevoSocioModelo model;
	private NuevoSocioVista view;
	
	int edad;
	boolean esMenor;
	SocioDTO socio;
	TecnicoDTO tecnico;
	LicenciaDTO licencia;

	public NuevoSocioControlador(NuevoSocioModelo m, NuevoSocioVista v) {
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
		view.setVisible(true);
		if(view.getChckbxAceptarDatos().isSelected()) {
			view.getBtnCrearLicencia().setVisible(true);
		}
		else {
			view.getBtnCrearLicencia().setVisible(false);
		}
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		//view.getFrame().setVisible(true); 
	}
	
	public void edadSocio() {
		
		Date fecha=new Date();
		try {
			fecha = new SimpleDateFormat("dd/MM/yy",Locale.ENGLISH).parse(view.getTextFieldFechaNacimiento().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date hoy=new Date();
		if(fecha.after(hoy)) {
			view.Error("La fecha de nacimiento no puede ser posterior al día de hoy");
		}
		else {
			long diff = hoy.getTime() - fecha.getTime();
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(diff);
	
			edad = 	c.get(Calendar.YEAR)-1970;
			
			if (edad< 18) {
				view.getTextFieldDNITutor().setEditable(true);
				view.getTextFieldNombreTutor().setEditable(true);
				esMenor=true;
			}
			else {
				view.getTextFieldDNITutor().setEditable(false);
				view.getTextFieldNombreTutor().setEditable(false);
				esMenor=false;
			}
		}
		
	}
	public void introduceDatos() {
		edadSocio();
		int id_Socio=model.NextID("id_socio", "Socio");
		int id_Tecnico=model.NextID("id_tecnico","Tecnico");
		int id_Licencia=model.NextID("id_licencia", "Licencia");
		tecnico= new TecnicoDTO(id_Tecnico,view.getTextFieldNombreTecnico().getText(),view.getTextFieldDNITecnico().getText(),view.getTextFieldLicenciaTecnico().getText());
		licencia= new LicenciaDTO(id_Licencia,view.getTextFieldLicencia().getText(),"Pendiente de Pago");
		if(!esMenor) {
			socio=new SocioDTO(id_Socio,view.getTextFieldNombre().getText(),view.getTextFieldDNI().getText(),view.getTextFieldFechaNacimiento().getText(),
					view.getTextFieldSexo().getText(),view.getTextFieldClub().getText(),view.getTextFieldLicencia().getText());
			model.nuevoSocio(socio, tecnico);
			model.nuevoTecnico(tecnico);
			model.nuevaLicencia(licencia);
		}
		else {
			socio=new SocioDTO(id_Socio,view.getTextFieldNombre().getText(),view.getTextFieldDNI().getText(),view.getTextFieldFechaNacimiento().getText(),
					view.getTextFieldSexo().getText(),view.getTextFieldClub().getText(),view.getTextFieldLicencia().getText(),
					view.getTextFieldNombreTutor().getText(),view.getTextFieldDNITutor().getText());
			model.nuevoSocioMenor(socio, tecnico);
			model.nuevoTecnico(tecnico);
			model.nuevaLicencia(licencia);
		}
		
	}
	
}

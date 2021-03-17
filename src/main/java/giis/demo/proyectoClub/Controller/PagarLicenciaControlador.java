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

import giis.demo.proyectoClub.View.PagarLicenciaVista;
import giis.demo.proyectoClub.model.NuevoSocioModelo;
import giis.demo.proyectoClub.model.PagarLicenciaModelo;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

/**
 * Controlador para la funcionalidad de visualizacion de carreras para la inscripcion.
 * Es el punto de entrada de esta pantalla que se invocará:
 * -instanciando el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class PagarLicenciaControlador {
	private PagarLicenciaModelo model;
	private PagarLicenciaVista view;
	
	
	LicenciaDTO licencia;

	public PagarLicenciaControlador(PagarLicenciaModelo m, PagarLicenciaVista v) {
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
		view.getBtnPagar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> pagarLicencia()));
	
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
		
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		//view.getFrame().setVisible(true); 
	}
	
	
	public void pagarLicencia() {
		if (!view.getComboBoxFormaDePago().getSelectedItem().equals("Transferencia")) {
			view.getBtnPagar().setVisible(false);
		}
		else {
			view.getBtnPagar().setVisible(true);
			view.getTextPaneDatos().setText("Titular de la cuenta: Club SI2021- PL42 \n Numero de cuenta(IBAN): ES12 1234 1234 123456789 \n" );
			licencia.setLicencia(view.getTextFieldLicencia().getText());
			model.pagarLicencia(licencia);
		}
	}
	
}

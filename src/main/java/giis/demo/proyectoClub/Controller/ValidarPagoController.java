package giis.demo.proyectoClub.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.WindowConstants;

import giis.demo.proyectoClub.DTO.LicenciaDTO;
import giis.demo.proyectoClub.View.ValidarPagoView;
import giis.demo.proyectoClub.model.ValidarPagoModel;
import giis.demo.util.SwingUtil;

public class ValidarPagoController {
	
	private ValidarPagoModel model;
	private ValidarPagoView view;
	
	public ValidarPagoController(ValidarPagoModel m, ValidarPagoView v) {
		this.model = m;
		this.view = v;
		
		this.initView();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		view.setVisible(true);
		
		view.getbCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)));
		view.getbGenerarFichero().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarFichero()));

		
	}
	
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getValidarPago().setVisible(true); 
	}
	
	public void generarFichero() {
		
		FileWriter file;
		try {
			file = new FileWriter("C:\\Users\\inipi\\git\\SI2020-PL42\\SI2020-PL42\\ValidacionLicencias.txt");
			List<LicenciaDTO> licencias = model.getLicencias();

			String s = "Nº LICENCIA\tTIPO DE LICENCIA\tESTADO";
			for(int j = 0; j < licencias.size(); j++) {
				s += String.valueOf(licencias.get(j).getLicencia()) + "\t" + licencias.get(j).getEstado() + "\n";
			}
			file.write(s);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

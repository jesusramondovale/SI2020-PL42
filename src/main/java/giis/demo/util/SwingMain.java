package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import giis.demo.proyectoClub.Controller.GenerarActaController;
import giis.demo.proyectoClub.Model.GenerarActaModel;
import giis.demo.proyectoClub.View.GenerarActaView;
//import giis.demo.proyectoClub.Controller.GenerarInformeSemanalController;
//import giis.demo.proyectoClub.Model.GenerarInformeSemanalModel;
//import giis.demo.proyectoClub.Controller.GenerarInformeSemanalController;
//import giis.demo.proyectoClub.Model.GenerarInformeSemanalModel;
//import giis.demo.proyectoClub.View.GenerarInformeSemanalView;
import giis.demo.tkrun.*;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 426, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEjecutarTkrun = new JButton("Ejecutar giis.demo.tkrun");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CarrerasController controller=new CarrerasController(new CarrerasModel(), new CarrerasView());
				controller.initController();
			}
		});
		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);
		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		
		
		frame.getContentPane().add(btnInicializarBaseDeDatos);
			
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton btnGenerarActaDe = new JButton("Generar Acta de Asamblea");
		frame.getContentPane().add(btnGenerarActaDe);
		
		btnGenerarActaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){   
				
				GenerarActaModel model = new GenerarActaModel();
				GenerarActaView view = new GenerarActaView();
				GenerarActaController controller = new GenerarActaController(view,model);
				controller.initController();
				
			}
		
		});
		
						
	}
	
	
	public JFrame getFrame() { return this.frame; }
	
}

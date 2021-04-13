package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import giis.demo.proyectoClub.Controller.NuevoJuezControlador;
import giis.demo.proyectoClub.Controller.NuevoSocioControlador;
import giis.demo.proyectoClub.Controller.NuevoTecnicoControlador;
import giis.demo.proyectoClub.Controller.PagarLicenciaControlador;
import giis.demo.proyectoClub.Controller.RealizarReservaController;
//import giis.demo.proyectoClub.View.NuevoSocioVista;
import giis.demo.proyectoClub.Controller.ReciboCuotaController;
import giis.demo.proyectoClub.Controller.RenovarLicenciaController;
import giis.demo.proyectoClub.Controller.ValidarPagoController;
import giis.demo.proyectoClub.View.PagarLicenciaVista;
import giis.demo.proyectoClub.View.RealizarReservaView;
import giis.demo.proyectoClub.View.ReciboCuotaView;
import giis.demo.proyectoClub.View.RenovarLicenciaView;
import giis.demo.proyectoClub.View.SocioVista;
import giis.demo.proyectoClub.View.ValidarPagoView;
import giis.demo.proyectoClub.View.nuevoJuezVista;
import giis.demo.proyectoClub.View.nuevoTecnicoVista;
import giis.demo.proyectoClub.model.NuevoJuezModel;
import giis.demo.proyectoClub.model.NuevoSocioModelo;
import giis.demo.proyectoClub.model.NuevoTecnicoModel;
import giis.demo.proyectoClub.model.PagarLicenciaModelo;
import giis.demo.proyectoClub.model.RealizarReservaModel;
import giis.demo.proyectoClub.model.ReciboCuotaModel;
import giis.demo.proyectoClub.model.RenovarLicenciaModel;
import giis.demo.proyectoClub.model.ValidarPagoModel;
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
		frame.setBounds(0, 0, 287, 185);
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

		JButton btnEjecutarNuevoSocio = new JButton("Nuevo Socio");
		btnEjecutarNuevoSocio.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				NuevoSocioControlador controller=new NuevoSocioControlador(new NuevoSocioModelo(), new SocioVista());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarNuevoSocio);
		
		JButton btnEjecutarNuevoTecnico = new JButton("Nuevo Tecnico");
		btnEjecutarNuevoTecnico.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				NuevoTecnicoControlador controller=new NuevoTecnicoControlador(new NuevoTecnicoModel(), new nuevoTecnicoVista());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarNuevoTecnico);
		
		JButton btnEjecutarNuevoJuez = new JButton("Nuevo Juez");
		btnEjecutarNuevoJuez.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				NuevoJuezControlador controller=new NuevoJuezControlador(new NuevoJuezModel(), new nuevoJuezVista());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarNuevoJuez);

		JButton btnEjecutarPagarLicencia = new JButton("PagarLicencia");
		btnEjecutarPagarLicencia.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				PagarLicenciaControlador controller=new PagarLicenciaControlador(new PagarLicenciaModelo(), new PagarLicenciaVista());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarPagarLicencia);
		
		JButton btnRealizarReserva = new JButton("Realizar reserva");
		btnRealizarReserva.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				RealizarReservaController controller=new RealizarReservaController(new RealizarReservaModel(), new RealizarReservaView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnRealizarReserva);

		JButton btnRenovarLicencia = new JButton("Renovar licencia");
		btnRenovarLicencia.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				RenovarLicenciaController controller=new RenovarLicenciaController(new RenovarLicenciaModel(), new RenovarLicenciaView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnRenovarLicencia);
		
		JButton btnReciboCuota = new JButton("Recibo Cuota");
		btnReciboCuota.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				ReciboCuotaController controller=new ReciboCuotaController(new ReciboCuotaModel(), new ReciboCuotaView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnReciboCuota);

		JButton btnValidarPago = new JButton("Validar Pagos");
		btnValidarPago.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				ValidarPagoController controller=new ValidarPagoController(new ValidarPagoModel(), new ValidarPagoView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnValidarPago);
		
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
	}

	public JFrame getFrame() { return this.frame; }

}

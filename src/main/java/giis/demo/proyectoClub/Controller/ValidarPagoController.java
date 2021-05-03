package giis.demo.proyectoClub.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import giis.demo.proyectoClub.DTO.LicenciaDTO;
import giis.demo.proyectoClub.DTO.LicenciaDisplayDTO;
import giis.demo.proyectoClub.View.ValidarPagoView;
import giis.demo.proyectoClub.model.ValidarPagoModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;

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
		view.getbSeleccion().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfcSeleccion = new JFileChooser();
				jfcSeleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfcSeleccion.showOpenDialog(jfcSeleccion);
				File fpagos = jfcSeleccion.getSelectedFile();
				String ruta = fpagos.getAbsolutePath();
				
				view.getTfSeleccion().setText(fpagos.getName());
				view.getTfSeleccion().setForeground(Color.black);
				comprobarDatos(ruta);
			}
		});

		view.getCbAlbaran().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(view.getCbAlbaran().isSelected()) {
					view.getbAceptar().setEnabled(false);
					view.getbTramitar().setEnabled(true);
				}
				else {
					view.getbAceptar().setEnabled(true);
					view.getbTramitar().setEnabled(false);
				}
			}
		});

		view.getbTramitar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tramitarLicencia();
				generarFichero();
			}
		});

		view.getbAceptar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Se han validado los pagos", "Validación", JOptionPane.DEFAULT_OPTION);
			}
		});
	}

	public void initView() {
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getValidarPago().setVisible(true); 
	}

	public void comprobarDatos(String ruta) {

		String file = ruta;
		BufferedReader fileR = null;
		try {

			String line = "";
			fileR = new BufferedReader(new FileReader(file));
			while((line = fileR.readLine()) != null) {
				String[] fields = line.split(";");
				String nlicencia = fields[0];
				String estado = fields[2];
				List<LicenciaDisplayDTO> licencias = model.getLicencias();
				for(int i = 0; i < licencias.size(); i++) {
					if(licencias.get(i).getNumLicencia().equals(nlicencia) && (estado != "Tramitada")) {
						model.editarLicencia(nlicencia);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e.getMessage());
			throw new UnexpectedException(e);
		} finally {
			try {
				fileR.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void tramitarLicencia() {

		model.tramitarLicencias("Pagada");
		JOptionPane.showMessageDialog(null, "Se han tramitado las licencias", "Tramitación", JOptionPane.DEFAULT_OPTION);
	}

	public void generarFichero() {

		FileWriter file;
		try {
			file = new FileWriter("C:\\Users\\inipi\\OneDrive\\Documentos\\GitHub\\SI2020-PL42\\src\\main\\java\\giis\\demo\\proyectoClub\\albaran.txt");
			List<LicenciaDisplayDTO> licencias = model.getLicencias();

			String s = "Nº LICENCIA\t\tPRECIO\t\tESTADO";
			for(int j = 0; j < licencias.size(); j++) {
				if(licencias.get(j).getEstadoLicencia().equals("Tramitada")) {
					s += "\n" + licencias.get(j).getNumLicencia() + "\t\t" + licencias.get(j).getPrecio() + "\t\t" + licencias.get(j).getEstadoLicencia() + "\n";
				}
			}
			file.write(s);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

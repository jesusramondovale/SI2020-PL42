package giis.demo.proyectoClub.Controller;

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

				File fpagos = jfcSeleccion.getSelectedFile();
				String ruta = fpagos.getAbsolutePath();
				comprobarDatos(ruta);
			}
		});
/*
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
		});*/
	}

	public void initView() {
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getValidarPago().setVisible(true); 
	}

	public void comprobarDatos(String ruta) {

		final String SEPARADOR = ";";
		BufferedReader br = null;
		try {

			String[] cabecera = new String[] {"Licencia", "Precio", "Estado"};
			br = new BufferedReader(new FileReader(ruta));
			String line = br.readLine();
			if(line.length() != cabecera.length) {
				JOptionPane.showMessageDialog(null, "El fichero es erróneo", "Error", JOptionPane.DEFAULT_OPTION);
				br.close();
			}
			line = br.readLine();
			while(null != line) {
				String[] fields = line.split(SEPARADOR);
				String nlicencia = fields[0];
				String estado = fields[2];
				List<LicenciaDisplayDTO> licencias = model.getLicencias();
				for(int i = 0; i < licencias.size(); i++) {
					if(licencias.get(i).getNumLicencia().equals(nlicencia) && licencias.get(i).getEstadoLicencia().equals("Pagada") && (estado != "Tramitada")) {
						model.editarLicencia(nlicencia, estado);
					}
				}
				for(int j = 0; j < fields.length; j++) {
					fields[j].replaceAll("^"+ "\"", "").replaceAll("\""+"$", "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != br) {
					br.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void tramitarLicencia() {

		model.tramitarLicencias("Pagada");
	}

	public void generarFichero() {

		FileWriter file;
		try {
			file = new FileWriter("C:\\Users\\inipi\\git\\SI2020-PL42\\SI2020-PL42\\ValidacionLicencias.txt");
			List<LicenciaDisplayDTO> licencias = model.getLicencias();

			String s = "Nº LICENCIA\t\tPRECIO\t\tESTADO";
			for(int j = 0; j < licencias.size(); j++) {
				if(licencias.get(j).getEstadoLicencia().equals("Tramitada")) {
					s += "\n" + licencias.get(j).getNumLicencia() + "\t\t" + licencias.get(j).getPrecio() + "\t\t" + licencias.get(j).getEstadoLicencia() + "\n";
				}
				else {
					file.close();
				}
			}
			file.write(s);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

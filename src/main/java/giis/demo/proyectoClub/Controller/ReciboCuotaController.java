package giis.demo.proyectoClub.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import giis.demo.proyectoClub.DTO.ReciboDisplayDTO;
import giis.demo.proyectoClub.DTO.SociosDisplayDTO;
import giis.demo.proyectoClub.View.ReciboCuotaView;
import giis.demo.proyectoClub.model.ReciboCuotaModel;
import giis.demo.util.Util;

public class ReciboCuotaController {

	private ReciboCuotaView view;
	private ReciboCuotaModel model;

	public ReciboCuotaController(ReciboCuotaModel m, ReciboCuotaView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();
		view.getbRecibo().addActionListener(e ->generarRecibo());

	}

	public void initView() {
		mostrarDatos();
		view.getFrame().setVisible(true);
	}

	/**
	 * Método que carga todos los datos de la tabla para cada socio
	 */
	public void mostrarDatos() {

		List<SociosDisplayDTO> socios = model.getSocios();
		List<ReciboDisplayDTO> recibos = model.getRecibos();
		
		String c = "Cuota Club Mes " + view.getCbMes().getSelectedItem().toString();

		Object[][]elementos = new Object[recibos.size()][7];
		for(int i = 0; i < socios.size();i++) {

			List<SociosDisplayDTO> nombreSocio = model.getNombreSocio(socios.get(i).getIdSocio());
			List<SociosDisplayDTO> apellido1Socio = model.getApe1Socio(socios.get(i).getIdSocio());
			List<SociosDisplayDTO> apellido2Socio = model.getApe2Socio(socios.get(i).getIdSocio());
			List<SociosDisplayDTO> cuota = model.getCuota(socios.get(i).getIdSocio());
			List<SociosDisplayDTO> numCuenta = model.getNumCuentaSocio(socios.get(i).getIdSocio());

			List<ReciboDisplayDTO> nRecibo = model.getNRecibo(recibos.get(i).getIdRecibo());
			List<ReciboDisplayDTO> fechaV = model.getFechaV(recibos.get(i).getIdRecibo());
			List<ReciboDisplayDTO> fechaE = model.getFechaE(recibos.get(i).getIdRecibo());
			
			if(nombreSocio.size()!=0) {
				for(int j = 0; j < nombreSocio.size(); j++) {
					elementos[j][0] = nRecibo.get(j).getnRecibo();
					elementos[j][1] = fechaV.get(j).getFechaV();
					elementos[j][2] = fechaE.get(j).getFechaE();
					elementos[j][3] = c;
					elementos[j][4] = cuota.get(j).getCuota(); 
					elementos[j][5] = nombreSocio.get(j).getNombreSocio() + " " 
							+ apellido1Socio.get(j).getApellido1Socio() + " " 
							+ apellido2Socio.get(j).getApellido2Socio();
					elementos[j][6] = numCuenta.get(j).getNumCuentaSocio(); 

				}
			}
		}
		DefaultTableModel dmodel = new DefaultTableModel(elementos, new String[] {
				"Nº Recibo", "Fecha de Valor", "Fecha de emision", "Concepto", "Importe", "Socio", "Nº de cuenta bancaria"
		});
		view.gettDatos().setModel(dmodel);
	}

	public void generarRecibo() {

		List<ReciboDisplayDTO> recibos = model.getRecibos();
		List<SociosDisplayDTO> socios = model.getSocios();

		FileWriter file;
		String c = "Cuota Club Mes " + view.getCbMes().getSelectedItem().toString();
		try {
			file = new FileWriter("C:\\Users\\inipi\\SI2020-PL42\\src\\main\\java\\giis\\demo\\proyectoClub\\ReciboRLicencia.txt");
			Object[][] elem = new Object[recibos.size()][2];
			for(int i = 0; i < recibos.size(); i++) {
				elem[i][0] = recibos.get(i).getnRecibo();
			}
			String r = "";
			if(view.getCbSelec().isSelected()) {
				for(int j = 0; j < recibos.size(); j++) {

					r += "Nº de recibo: " + String.valueOf(recibos.get(j).getnRecibo()) + "\nDatos del socio: " + socios.get(j).getNombreSocio() + " " + socios.get(j).getApellido1Socio() + " " + socios.get(j).getApellido2Socio() +
							"\nFecha de Valor: " + recibos.get(j).getFechaV() + "\tFecha de Emisión: " + recibos.get(j).getFechaE() +
							"\nConcepto: " + c;
					file.write(r);
				}
			}
			else {
				if (view.gettDatos().getSelectedRow() != -1) {
					r += "Nº de recibo: " + view.gettDatos().getValueAt(view.gettDatos().getSelectedRow(), 0) + "\nDatos del socio: " + view.gettDatos().getValueAt(view.gettDatos().getSelectedRow(), 4) +
							view.gettDatos().getValueAt(view.gettDatos().getSelectedRow(), 5) + view.gettDatos().getValueAt(view.gettDatos().getSelectedRow(), 6) +
							"\nFecha de Valor: " + view.gettDatos().getValueAt(view.gettDatos().getSelectedRow(), 1) + "\tFecha de Emisión: " + view.gettDatos().getValueAt(view.gettDatos().getSelectedRow(), 2) +
							"\nConcepto: " + c;
					file.write(r);
				}
			}

			JOptionPane.showMessageDialog(null, "Los recibos mensuales han sido generados", "Recibo mensual", JOptionPane.OK_OPTION);
			file.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package giis.demo.proyectoClub.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import giis.demo.proyectoClub.DTO.ReciboDisplayDTO;
import giis.demo.proyectoClub.DTO.SociosDisplayDTO;
import giis.demo.proyectoClub.View.ReciboCuotaView;
import giis.demo.proyectoClub.model.ReciboCuotaModel;
import giis.demo.util.Database;
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
		
		view.getbRecibo().addActionListener(e ->insertarRecibo());
		
		view.getbCancelar().addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				view.getFrame().setVisible(false);
			}
		});
		
		view.getCbSelec().addActionListener(e -> view.getbRecibo().setEnabled(true));
	}

	public void initView() {
		mostrarDatos();
		view.getFrame().setVisible(true);
	}

	/**
	 * Método que carga todos los datos de la tabla para cada socio
	 */
	public void mostrarDatos() {

		Month mes = LocalDate.now().getMonth();
		String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

		view.getCbMes().setSelectedItem(nombre);

		List<SociosDisplayDTO> socios = model.getSocios();

		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		view.getTfYear().setText(String.valueOf(y));

		DefaultTableModel m = (DefaultTableModel) view.gettDatos().getModel();
		String datos[][] = new String[socios.size()][7];

		for(int i = 0; i < socios.size(); i++) {

			datos[i][0] = "RGCC-"+ view.getTfYear().getText() + "-" + view.getCbMes().getSelectedItem().toString() + "-" + i+1;
			datos[i][1] = "1/" + view.getCbMes().getSelectedItem().toString() + "/" + view.getTfYear().getText();
			datos[i][2] = "15/" + view.getCbMes().getSelectedItem().toString() + "/" + view.getTfYear().getText();
			datos[i][3] = "Cuota Club Mes " + view.getCbMes().getSelectedItem().toString();
			datos[i][4] = "" + model.getCuota(socios.get(i).getIdSocio());
			datos[i][5] =  "" + socios.get(i).getNombreSocio() + " " + socios.get(i).getApellido1Socio() + " " + socios.get(i).getApellido2Socio();
			datos[i][6] = "" +socios.get(i).getNumCuentaSocio();
			
			m.addRow(datos);
		}
		view.gettDatos().setModel(m);
	}

	public void generarRecibo(String nRecibo, String fValor, String fEmision, String concepto, String importe, String socio,
			String numCuenta) {

		List<ReciboDisplayDTO> recibos = model.getRecibos();

		FileWriter file;
		try {
			file = new FileWriter("C:\\Users\\inipi\\SI2020-PL42\\src\\main\\java\\giis\\demo\\proyectoClub\\ReciboRLicencia.txt");
			Object[][] elem = new Object[recibos.size()][2];
			for(int i = 0; i < recibos.size(); i++) {
				elem[i][0] = recibos.get(i).getnRecibo();
			}
			String r = "";
			if(view.getCbSelec().isSelected()) {
				for(int j = 0; j < recibos.size(); j++) {
					r += "Nº DE RECIBO: " + nRecibo + "\nConcepto: " + concepto + 
							"\n\tDatos del socio: " + socio + "\t\tNumero de cuenta: " + numCuenta +
							"\n\tFecha de Valor: " + fValor + "\t\tFecha de Emisión: " + fEmision +
							"\n\t\t\t\t\t\tTOTAL: " + importe;
					file.write(r);
				}
			}
			else {
				if (view.gettDatos().getSelectedRow() != -1) {
					r += "Nº DE RECIBO: " + nRecibo + "\nConcepto: " + concepto + 
							"\n\tDatos del socio: " + socio + "\t\tNumero de cuenta: " + numCuenta +
							"\n\tFecha de Valor: " + fValor + "\t\tFecha de Emisión: " + fEmision +
							"\n\t\t\t\t\t\tTOTAL: " + importe;
					file.write(r);
				}
				else {
					JOptionPane.showMessageDialog(null, "Seleccione un recibo a generar", "Recibo mensual", JOptionPane.OK_OPTION);
				}
			}

			JOptionPane.showConfirmDialog(null, "Los recibos mensuales han sido generados", "Recibo mensual", JOptionPane.OK_OPTION);
			file.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarRecibo() {

		DefaultTableModel m = (DefaultTableModel) view.gettDatos().getModel();
		int[] filas = view.gettDatos().getSelectedRows();
		int[] columnas = view.gettDatos().getSelectedColumns();
		String[] datos = new String[columnas.length]; 
		for(int i = 0; i < filas.length; i++) {
			for(int j = 0; j < columnas.length; j++) {
				datos = (String[]) m.getValueAt(filas[i], j);
			}
			model.addRecibo(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
			generarRecibo(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
		}
	}

}

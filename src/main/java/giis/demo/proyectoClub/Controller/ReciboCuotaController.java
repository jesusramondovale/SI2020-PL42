package giis.demo.proyectoClub.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import giis.demo.proyectoClub.DTO.SociosDisplayDTO;
import giis.demo.proyectoClub.View.MostrarSociosView;
import giis.demo.proyectoClub.View.ReciboCuotaView;
import giis.demo.proyectoClub.View.generarLotesView;
import giis.demo.proyectoClub.model.MostrarSociosModel;
import giis.demo.proyectoClub.model.ReciboCuotaModel;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class ReciboCuotaController {

	private ReciboCuotaView view;
	private ReciboCuotaModel model;
	private generarLotesView lotesView;

	public ReciboCuotaController(ReciboCuotaModel m, ReciboCuotaView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
	}
	public ReciboCuotaController(ReciboCuotaModel m, generarLotesView v) {
		this.model = m;
		this.lotesView = v;
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

		view.getbRecibo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				insertarRecibo();
				generarRecibo();				
			}
		});

		view.getbCancelar().addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				view.getFrame().setVisible(false);
			}
		});

		view.gettDatos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				view.getbRecibo().setEnabled(true);
			}
		});

		view.getCbSelec().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getbRecibo().setEnabled(true);
			}
		});
		
		view.getBtnAgregar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				copiarSelecciones();
			}
		});
		

	}

	public void initView() {
		mostrarDatos();
		view.getFrame().setVisible(true);
		//lotesView.getFrame().setVisible(false);
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
		m.removeRow(0);
		String datos[] = new String[m.getColumnCount()];

		for(int i = 1; i <= socios.size(); i++) {
			List<Object[]> n = model.getNombreSocio(i);
			List<Object[]> a1 = model.getApe1Socio(i);
			List<Object[]> a2 = model.getApe2Socio(i);
			List<Object[]> c = model.getCuota(i);
			List<Object[]> nc = model.getNumCuentaSocio(i);

			datos[0] = "RGCC-"+ view.getTfYear().getText() + "-" + view.getCbMes().getSelectedItem().toString() + "-" + i;
			datos[1] = "15-" + view.getCbMes().getSelectedItem().toString() + "-" + view.getTfYear().getText();
			datos[2] = "1-" + view.getCbMes().getSelectedItem().toString() + "-" + view.getTfYear().getText();
			datos[3] = "Cuota Club Mes " + view.getCbMes().getSelectedItem().toString();
			for(int j = 0; j < n.size(); j ++) {
				datos[4] = "" + c.get(j)[j];
				datos[5] =  "" + n.get(j)[j] + " " + a1.get(j)[j] + " " + a2.get(j)[j];
				datos[6] = "" + nc.get(j)[j];
			}
			m.addRow(datos);
			view.gettDatos().setModel(m);
		}
		DefaultTableModel mS = (DefaultTableModel) view.gettSelec().getModel();
		mS.removeRow(0);
	}

	public void generarRecibo() {

		DefaultTableModel m = (DefaultTableModel) view.gettDatos().getModel();
		FileWriter file;
	
		try {
			file = new FileWriter("C:\\Users\\Pela\\Desktop\\UNI\\Informacion2021\recibo.txt");
			for(int j = 0; j < m.getRowCount(); j++) {
				String r = "";
				
				r += "Nº DE RECIBO: " + m.getValueAt(j, 0) + "\nConcepto: " + m.getValueAt(j, 3) + 
						"\n\tDatos del socio: " + m.getValueAt(j, 5) + "\t\tNumero de cuenta: " + m.getValueAt(j, 6) +
						"\n\tFecha de Valor: " + m.getValueAt(j, 1) + "\t\tFecha de Emisión: " + m.getValueAt(j, 2) +
						"\n\t\t\t\t\t\tTOTAL: " + m.getValueAt(j, 4);
				file.write(r);
				file.close();
			}

			JOptionPane.showConfirmDialog(null, "Los recibos mensuales han sido generados", "Recibo mensual", JOptionPane.DEFAULT_OPTION);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarRecibo() {

		/*DefaultTableModel m = (DefaultTableModel) view.gettDatos().getModel();
		int[] filas = view.gettDatos().getSelectedRows();
		int[] columnas = view.gettDatos().getSelectedColumns();
		String[] datos = new String[columnas.length]; 
		for(int i = 0; i < filas.length; i++) {
			for(int j = 0; j < columnas.length; j++) {
				datos =  (String[]) m.getValueAt(filas[i], j);
			}
			model.addRecibo(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
		}*/
		DefaultTableModel m = (DefaultTableModel) view.gettSelec().getModel();
		int filas = view.gettDatos().getRowCount();
		int columnas = view.gettDatos().getColumnCount();
		String[] datos = new String[columnas]; 
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				datos =  (String[]) m.getValueAt(i, j);
			}
			model.addRecibo(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
		}
	}
	public void copiarSelecciones() {
		DefaultTableModel mD= (DefaultTableModel) view.gettDatos().getModel();
		DefaultTableModel mS= (DefaultTableModel) view.gettSelec().getModel();
		
		if(view.gettDatos().getSelectedRowCount()>0) {
			int [] filas=view.gettDatos().getSelectedRows();
			
			for(int i : filas) {
				Object[] fila= new Object[mD.getColumnCount()];
				for(int j=0; j < fila.length; j ++) {
					fila[j]=mD.getValueAt(i, j);
				}
				mS.addRow(fila);
			}
		}
	}

}

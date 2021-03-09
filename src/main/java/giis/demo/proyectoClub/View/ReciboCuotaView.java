package giis.demo.proyectoClub.View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class ReciboCuotaView {
	
	private JFrame GenerarRecibos;
	private JTable tDatos;
	private JLabel LMes;
	private JComboBox cbMes;
	private JLabel LYear;
	private JTextField tfYear;
	private JCheckBox cbSelec;
	private JButton bCancelar;
	private JButton bRecibo;

	
	/**
	 * Create the application.
	 */
	
	public ReciboCuotaView() {
		initialize();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		GenerarRecibos = new JFrame();
		GenerarRecibos.setTitle("Generar recibo");
		GenerarRecibos.setBounds(400, 400, 775, 619);
		GenerarRecibos.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 105, 612, 351);
		GenerarRecibos.getContentPane().add(scrollPane);
		
		tDatos = new JTable();
		tDatos.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
						"Nº Recibo", "Fecha de Valor", "Fecha de emision", "Concepto", "Importe", "Socio", "Nº de cuenta bancaria"
				}
		));
		tDatos.getColumnModel().getColumn(6).setPreferredWidth(145);
		scrollPane.setViewportView(tDatos);
		
		LMes = new JLabel("Mes:");
		LMes.setBounds(107, 58, 33, 14);
		GenerarRecibos.getContentPane().add(LMes);
		
		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"- Elegir mes -", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cbMes.setBounds(171, 54, 112, 22);
		GenerarRecibos.getContentPane().add(cbMes);
		
		LYear = new JLabel("Año:");
		LYear.setBounds(438, 58, 33, 14);
		GenerarRecibos.getContentPane().add(LYear);
		
		tfYear = new JTextField();
		tfYear.setBounds(481, 55, 96, 20);
		GenerarRecibos.getContentPane().add(tfYear);
		tfYear.setColumns(10);
		
		cbSelec = new JCheckBox("Seleccionar todo");
		cbSelec.setBounds(60, 487, 122, 23);
		GenerarRecibos.getContentPane().add(cbSelec);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(171, 533, 89, 23);
		GenerarRecibos.getContentPane().add(bCancelar);
		
		bRecibo = new JButton("Generar recibo");
		bRecibo.setEnabled(false);
		bRecibo.setBounds(481, 533, 122, 23);
		GenerarRecibos.getContentPane().add(bRecibo);
		
	}
	
	public JFrame getFrame() {
		return this.GenerarRecibos;
	}

	public JTable gettDatos() {
		return tDatos;
	}

	public void settDatos(JTable tDatos) {
		this.tDatos = tDatos;
	}

	public JLabel getLMes() {
		return LMes;
	}

	public void setLMes(JLabel lMes) {
		LMes = lMes;
	}

	public JComboBox getCbMes() {
		return cbMes;
	}

	public void setCbMes(JComboBox cbMes) {
		this.cbMes = cbMes;
	}

	public JLabel getLYear() {
		return LYear;
	}

	public void setLYear(JLabel lYear) {
		LYear = lYear;
	}

	public JTextField getTfYear() {
		return tfYear;
	}

	public void setTfYear(JTextField tfYear) {
		this.tfYear = tfYear;
	}
	
	public JCheckBox getCbSelec() {
		return cbSelec;
	}

	public void setCbSelec(JCheckBox cbSelec) {
		this.cbSelec = cbSelec;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbRecibo() {
		return bRecibo;
	}

	public void setbRecibo(JButton bRecibo) {
		this.bRecibo = bRecibo;
	}
		
}

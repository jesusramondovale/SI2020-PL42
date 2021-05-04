package giis.demo.proyectoClub.View;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import giis.demo.proyectoClub.Controller.ReciboCuotaController;
import giis.demo.proyectoClub.Controller.ValidarPagoController;
import giis.demo.proyectoClub.model.ReciboCuotaModel;
import giis.demo.proyectoClub.model.ValidarPagoModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class generarLotesView {
	
	private JDialog cerrarLotes;
	private JLabel LMes;
	private JComboBox cbMes;
	private JButton btncerrarLotes;

	
	/**
	 * Create the application.
	 */
	
	public generarLotesView() {
		initialize();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		cerrarLotes = new JDialog();
		cerrarLotes.setTitle("Cerrar Lote");
		cerrarLotes.setBounds(600, 600, 370, 239);
		cerrarLotes.getContentPane().setLayout(null);
		
		LMes = new JLabel("Mes:");
		LMes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LMes.setBounds(38, 44, 59, 18);
		cerrarLotes.getContentPane().add(LMes);
		
		cbMes = new JComboBox();
		cbMes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"}));
		cbMes.setBounds(107, 40, 175, 40);
		cerrarLotes.getContentPane().add(cbMes);
		
		btncerrarLotes = new JButton("Cerrar Lote");
		btncerrarLotes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btncerrarLotes.setBounds(38, 108, 175, 62);
		cerrarLotes.getContentPane().add(btncerrarLotes);
		
			
		
	}
	
	
	public JDialog getCerrarLotes() {
		return cerrarLotes;
	}
	public void setCerrarLotes(JDialog cerrarLotes) {
		this.cerrarLotes = cerrarLotes;
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
	public JButton getBtncerrarLotes() {
		return btncerrarLotes;
	}
	public void setBtncerrarLotes(JButton btncerrarLotes) {
		this.btncerrarLotes = btncerrarLotes;
	}
	
	
	
}

	
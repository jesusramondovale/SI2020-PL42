package giis.demo.ProyectoClub.View;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MostrarInstalacionesView {

	private JFrame frame;
	private JTable table;
	private JButton btnAplicarFiltro;
	private JButton btnBorrarFiltro;
	private JSpinner spnFecha;
	private JComboBox seleccInstall;
	private JTable tablaMostrada;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarInstalacionesView window = new MostrarInstalacionesView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MostrarInstalacionesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSeleccInstal = new JLabel("Seleccione la instalación:");
		
		JLabel lblSeleccFecha = new JLabel("Indique la fecha:");
		
		JComboBox seleccInstal = new JComboBox();
		seleccInstal.addItem("Galería");
		seleccInstal.addItem("Campo");
		
		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.DATE);
		
		
		Date today = new Date(System.currentTimeMillis());
		JSpinner spnFecha = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spnFecha, "dd/MM/yy");
		spnFecha.setEditor(editor);
		
		
		
		JButton btnAplicarFiltro = new JButton("Aplicar Filtro");
		
		JButton btnBorrarFiltro = new JButton("Borrar Filtro");
		
		JScrollPane TablaMostrada = new JScrollPane();
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(seleccInstal, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeleccInstal))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSeleccFecha)
						.addComponent(spnFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAplicarFiltro)
						.addComponent(btnBorrarFiltro))
					.addContainerGap())
				.addComponent(TablaMostrada, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(seleccInstal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAplicarFiltro)
								.addComponent(lblSeleccFecha)
								.addComponent(lblSeleccInstal))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBorrarFiltro)
								.addComponent(spnFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(TablaMostrada, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
		);
		
		table = new JTable();
		TablaMostrada.setViewportView(table);
		
		
		frame.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrame() { return this.frame; }
    public JButton getBtnAplicarFiltro(){ return this.btnAplicarFiltro;}
    public JButton getBtnBorrarFiltro(){ return this.btnBorrarFiltro;}
    public String getFecha()  { return (String) this.spnFecha.getValue(); }
    public JTable getTablaInstalaciones(){  return this.tablaMostrada; }
    
    public String getTipo() { 
    		    		
    		return this.seleccInstall.getItemAt(this.seleccInstall.getSelectedIndex()).toString();
    	

    }
    
    
}

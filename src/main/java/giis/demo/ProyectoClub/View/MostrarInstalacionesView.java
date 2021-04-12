package giis.demo.ProyectoClub.View;

import java.awt.EventQueue;
import java.sql.Date;


import java.util.Calendar;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MostrarInstalacionesView {

	private JFrame frmMostrarInstalaciones;
	private JButton btnAplicarFiltro;
	private JButton btnBorrarFiltro;
	private JSpinner spnFecha;
	private JComboBox<String> seleccInstall;

	private JLabel lblSeleccInstal;
	private JLabel lblSeleccFecha;
	private JComboBox<String> seleccInstal;

	private JTable table;
	private JTextField txtFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarInstalacionesView window = new MostrarInstalacionesView();
					window.frmMostrarInstalaciones.setVisible(true);
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
		
		frmMostrarInstalaciones = new JFrame();
		frmMostrarInstalaciones.setTitle("Mostrar Instalaciones");
		frmMostrarInstalaciones.setBounds(100, 100, 620, 296);
		
		
		lblSeleccInstal = new JLabel("Seleccione la instalación:");
		lblSeleccFecha = new JLabel("Indique la fecha (ISO):");
		
		seleccInstal = new JComboBox<String>();
		seleccInstal.addItem("Galería");
		seleccInstal.addItem("Campo");
		seleccInstal.addItem("Cancha de baloncesto");
		seleccInstal.addItem("Piscina");
		seleccInstal.addItem("Pista de Atletismo");
		seleccInstal.addItem("Pista de tenis");
		seleccInstal.addItem("Campo de hockey");
		seleccInstal.addItem("Campo de rugby");
		
		
		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.DATE);
		
		
		
		Date  today = new Date(System.currentTimeMillis());
		spnFecha = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
		spnFecha.setEnabled(false);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spnFecha, "yyyy-MM-dd");
		spnFecha.setEditor(editor);
		
		
		
		btnAplicarFiltro = new JButton("Aplicar Filtro");
		
		btnBorrarFiltro = new JButton("Borrar Filtro");
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		
		GroupLayout groupLayout = new GroupLayout(frmMostrarInstalaciones.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblSeleccInstal)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(seleccInstal, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(35)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeleccFecha)
						.addComponent(spnFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAplicarFiltro)
						.addComponent(btnBorrarFiltro))
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSeleccInstal)
								.addComponent(lblSeleccFecha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(seleccInstal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spnFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAplicarFiltro)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBorrarFiltro)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		frmMostrarInstalaciones.getContentPane().setLayout(groupLayout);
		frmMostrarInstalaciones.setVisible(true);
	}

	
	/* Getters y setters*/
	public JFrame getFrame() { return this.frmMostrarInstalaciones; }
    public JButton getBtnAplicarFiltro(){ return this.btnAplicarFiltro;}
    public JButton getBtnBorrarFiltro(){ return this.btnBorrarFiltro;}  
    public String getFecha()  {return this.txtFecha.getText();}
    public JTable getTablaInstalaciones(){  return this.table; }
    public String getTipo() { 
    	
    	
    	return this.seleccInstal.getSelectedItem().toString();
    	
    }

	public JComboBox<String> getSeleccInstall() {
		return this.seleccInstall;
	}

	public void setSeleccInstall(JComboBox<String> seleccInstall) {
		this.seleccInstall = seleccInstall;
	}
}

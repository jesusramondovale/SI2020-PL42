package giis.demo.tkrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class InstalacionesView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstalacionesView frame = new InstalacionesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InstalacionesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String texto1 = "<html><body>Seleccione el tipo<br>de instalación:</body></html>";
		JLabel lblSeleccioneElTipo = new JLabel(texto1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Galería");
		comboBox.addItem("Campo");
		
		JLabel lblSeleccioneUnaFecha = new JLabel("Seleccione una fecha: ");
		
		SpinnerModel model1 = new SpinnerDateModel();
		JSpinner spinner = new JSpinner(model1);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm"));
		
		JButton btnAplicarFiltro = new JButton("Aplicar Filtro");
		
		JButton btnBorrarFiltro = new JButton("Borrar filtro");
		
		
		Object[][] rows = {
	            {"Amir", "Karachi"},
	            {"Noman", "Quetta"},
	            {"Salman", "Rawalpindi"}
	        };
	        Object[] cols = {"Name", "City"};
		
		
	
		
		
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeleccioneElTipo))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSeleccioneUnaFecha)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAplicarFiltro)
						.addComponent(btnBorrarFiltro))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeleccioneElTipo)
						.addComponent(lblSeleccioneUnaFecha)
						.addComponent(btnAplicarFiltro))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBorrarFiltro))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

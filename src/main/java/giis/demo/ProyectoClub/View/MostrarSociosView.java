package giis.demo.ProyectoClub.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class MostrarSociosView {

	private JFrame frame;
	private JTextField tfNombre;
	

	private JTextField tfApellido;
	private JButton btnNewButton;
	private JButton btnReset;
	private JLabel lblIndiqueElRango;
	private JTextField tfRangoIni;
	private JTextField tfRangoFin;
	private JLabel label;
	private JScrollPane scrollPane;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JTextField getTfRangoIni() {
		return tfRangoIni;
	}

	public void setTfRangoIni(JTextField tfRangoIni) {
		this.tfRangoIni = tfRangoIni;
	}

	public JTextField getTfRangoFin() {
		return tfRangoFin;
	}

	public void setTfRangoFin(JTextField tfRangoFin) {
		this.tfRangoFin = tfRangoFin;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public void setTfApellido(JTextField tfApellido) {
		this.tfApellido = tfApellido;
	}
	
	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JTextField getTfApellido() {
		return tfApellido;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarSociosView window = new MostrarSociosView();
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
	public MostrarSociosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblIndiqueElNombre = new JLabel("Indique el nombre del Socio:");
		
		JLabel lblIndiqueElApellido = new JLabel("Indique el apellido del Socio:");
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		
		btnNewButton = new JButton("Búsqueda");
		
		btnReset = new JButton("Reset");
		
		lblIndiqueElRango = new JLabel("Indique el rango de licencias:");
		
		tfRangoIni = new JTextField();
		tfRangoIni.setColumns(10);
		
		tfRangoFin = new JTextField();
		tfRangoFin.setColumns(10);
		
		label = new JLabel("-");
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblIndiqueElRango)
							.addGap(18)
							.addComponent(tfRangoIni, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tfRangoFin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblIndiqueElNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblIndiqueElApellido)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIndiqueElNombre)
						.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIndiqueElApellido)
								.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(btnReset)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIndiqueElRango)
						.addComponent(tfRangoIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfRangoFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Ordenar según...");
		menuBar.add(mnOpciones);
		
		JRadioButtonMenuItem rdbtnmntmNmeroDeLicencia = new JRadioButtonMenuItem("Número de licencia");
		buttonGroup.add(rdbtnmntmNmeroDeLicencia);
		mnOpciones.add(rdbtnmntmNmeroDeLicencia);
		
		JRadioButtonMenuItem rdbtnmntmNombreDeSocio = new JRadioButtonMenuItem("Nombre de socio");
		buttonGroup.add(rdbtnmntmNombreDeSocio);
		mnOpciones.add(rdbtnmntmNombreDeSocio);
		
		JRadioButtonMenuItem rdbtnmntmApellidoDeSocio = new JRadioButtonMenuItem("Apellido de socio");
		buttonGroup.add(rdbtnmntmApellidoDeSocio);
		mnOpciones.add(rdbtnmntmApellidoDeSocio);
	}
}

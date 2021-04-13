package giis.demo.ProyectoClub.View;

import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;


public class CrearAsambleasView {

	private JFrame frmCrearAsambleas;
	private JTextField txtOrdenDia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String hora1;
	private String hora2;
	
	private JSpinner spinnerHora1;
	private JSpinner spinnerHora2;


	private JSpinner spinnerFecha;
	private JRadioButton JRBExtraordinaria;
	private JRadioButton JRBOrdinaria;
	private String fechaAsamblea;
	private JTextField txtID;
	private JButton btnCrearAsamblea;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearAsambleasView window = new CrearAsambleasView();
					window.frmCrearAsambleas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearAsambleasView() {
		initialize();
		
		this.fechaAsamblea = getTxtFecha();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCrearAsambleas = new JFrame();
		frmCrearAsambleas.setTitle("Nueva Asamblea");
		frmCrearAsambleas.setBounds(100, 100, 768, 351);
		
		
		
		
		JLabel lblSeleecioneElTipo = new JLabel("Selecione el tipo de Asamblea:");
		
		JRadioButton rdbtnExtraordinaria = new JRadioButton("Extraordinaria");
		
		buttonGroup.add(rdbtnExtraordinaria);
		
		JRadioButton rdbtnOrdinaria = new JRadioButton("Ordinaria");
		rdbtnOrdinaria.setSelected(true);
		
		buttonGroup.add(rdbtnOrdinaria);
		
		JLabel lblEspecifiqueElOrden = new JLabel("Especifique el orden del día: ");
		
		txtOrdenDia = new JTextField();
		
		txtOrdenDia.setColumns(10);
		
		JLabel lblIndiqueUnaFecha = new JLabel("Indique una fecha:");
		
		JLabel lblIndiqueLaHora = new JLabel("Indique la hora (1ª Conv.):");
		
		JLabel lblIndiqueLaHora_1 = new JLabel("Indique la hora (2ª Conv.)");
		
		spinnerFecha = new JSpinner();
		
		
		java.util.Date datenow = Calendar.getInstance().getTime();
		
		SpinnerDateModel smb = new SpinnerDateModel(datenow, null, null, Calendar.HOUR_OF_DAY);
		
		spinnerFecha.setModel(smb);
		JSpinner.DateEditor d = new JSpinner.DateEditor(spinnerFecha, "yyyy-MM-dd");
		spinnerFecha.setEditor(d);
		
		
	
		
		spinnerHora1 = new JSpinner();
		
		
		SpinnerDateModel smb1 = new SpinnerDateModel(datenow, null, null, Calendar.HOUR_OF_DAY);
		spinnerHora1.setModel(smb1);
		JSpinner.DateEditor d1 = new JSpinner.DateEditor(spinnerHora1, "HH.MM");
		spinnerHora1.setEditor(d1);
		
		
		
		
		
		spinnerHora2 = new JSpinner();
		
		SpinnerDateModel smb2 = new SpinnerDateModel(datenow, null, null, Calendar.HOUR_OF_DAY);
		spinnerHora2.setModel(smb2);
		JSpinner.DateEditor d2 = new JSpinner.DateEditor(spinnerHora2, "HH.MM");
		spinnerHora2.setEditor(d2);
		
		
		
		JLabel lblidAsamblea = new JLabel("#ID asamblea:");
		
		txtID = new JTextField();
		
		txtID.setColumns(10);
		
		btnCrearAsamblea = new JButton("Crear Asamblea");
		
		
		GroupLayout groupLayout = new GroupLayout(frmCrearAsambleas.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblEspecifiqueElOrden)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblIndiqueUnaFecha)
								.addGap(47)
								.addComponent(lblIndiqueLaHora))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(spinnerFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(spinnerHora1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSeleecioneElTipo)
									.addGap(34)
									.addComponent(rdbtnOrdinaria))
								.addComponent(txtOrdenDia, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnExtraordinaria)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblidAsamblea)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(spinnerHora2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblIndiqueLaHora_1)))))))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(612, Short.MAX_VALUE)
					.addComponent(btnCrearAsamblea)
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSeleecioneElTipo)
							.addComponent(rdbtnOrdinaria))
						.addComponent(rdbtnExtraordinaria))
					.addGap(15)
					.addComponent(lblEspecifiqueElOrden, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOrdenDia, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblidAsamblea)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIndiqueUnaFecha)
						.addComponent(lblIndiqueLaHora)
						.addComponent(lblIndiqueLaHora_1))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(spinnerHora2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerHora1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(btnCrearAsamblea)
					.addGap(17))
		);
		frmCrearAsambleas.getContentPane().setLayout(groupLayout);
	}
 
	

/////////
	

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JFrame getFrame(){
		return this.frmCrearAsambleas;
	}
	
	
	public String getHora1(){
		return this.hora1;
		
	}
     
	public String getHora2(){
		return this.hora2;	
		
	}
	

	public JRadioButton getJRBExtraordinaria(){
		return this.JRBExtraordinaria;
		
	}
	
	public JRadioButton getJRBOrdinaria(){
		return this.JRBOrdinaria;
		
	}
	
	public JTextField getOrdenDia(){
		return this.txtOrdenDia;
	}
	
	public String getTxtOrdenDia() {
		return this.txtOrdenDia.getText();
	}
	
	public JTextField getTxtID() {
		return txtID;
	}
	
	public String getID(){
		return this.txtID.getText();
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public String getFechaAsamblea() {
		return fechaAsamblea;
	}

	public void setFechaAsamblea(String fechaAsamblea) {
		this.fechaAsamblea = fechaAsamblea;
	}

	public JButton getBtnCrearAsamblea() {
		return btnCrearAsamblea;
	}

	public void setBtnCrearAsamblea(JButton btnCrearAsamblea) {
		this.btnCrearAsamblea = btnCrearAsamblea;
	}
	
	public JSpinner getSpinnerFecha() {
		return spinnerFecha;
	}
	
	public String getTxtFecha(){
		
		JSpinner.DateEditor d = new JSpinner.DateEditor(spinnerFecha, "yyyy-MM-dd");
		return d.getFormat().format(spinnerFecha.getValue());
	}
	
	public String getTxtHora1(){
		
		JSpinner.DateEditor d = new JSpinner.DateEditor(spinnerHora1, "HH.MM");
		return d.getFormat().format(spinnerFecha.getValue());
	}
	
public String getTxtHora2(){
		
		JSpinner.DateEditor d = new JSpinner.DateEditor(spinnerHora2, "HH.MM");
		return d.getFormat().format(spinnerFecha.getValue());
	}
	
}

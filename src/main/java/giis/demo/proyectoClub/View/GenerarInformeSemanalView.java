package giis.demo.proyectoClub.View;

import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class GenerarInformeSemanalView {

	private JFrame frame;
	private JSpinner spinnerIni;


	private JSpinner spinnerFin;
	private JButton btnGenerarInforme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarInformeSemanalView window = new GenerarInformeSemanalView();
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
	public GenerarInformeSemanalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 391, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblSeleccioneLaFecha = new JLabel("Seleccione la fecha (inicio de semana) :");

		spinnerIni = new JSpinner();


		java.util.Date datenow = Calendar.getInstance().getTime();

		SpinnerDateModel smb = new SpinnerDateModel(datenow, null, null, Calendar.HOUR_OF_DAY);

		spinnerIni.setModel(smb);
		JSpinner.DateEditor d = new JSpinner.DateEditor(spinnerIni, "yyyy-MM-dd");
		spinnerIni.setEditor(d);

		btnGenerarInforme = new JButton("Generar Informe");

		JLabel lblSeleccioneLaFecha_1 = new JLabel("Seleccione la fecha (fin de semana) :");

		spinnerFin = new JSpinner();
		SpinnerDateModel smb1 = new SpinnerDateModel(datenow, null, null, Calendar.HOUR_OF_DAY);

		spinnerFin.setModel(smb1);
		JSpinner.DateEditor d1 = new JSpinner.DateEditor(spinnerFin, "yyyy-MM-dd");
		spinnerFin.setEditor(d1);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblSeleccioneLaFecha)
										.addGap(71))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(btnGenerarInforme)
										.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(spinnerIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(242, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(spinnerFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(242, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblSeleccioneLaFecha_1)
										.addContainerGap(90, Short.MAX_VALUE))))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblSeleccioneLaFecha)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(spinnerIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblSeleccioneLaFecha_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(spinnerFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addComponent(btnGenerarInforme)
						.addContainerGap())
				);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrame() {

		return this.frame;
	}

	public JButton getBtnGenerarInforme() {

		return this.btnGenerarInforme;
	}

	public JSpinner getSpinnerIni() {
		return spinnerIni;
	}

	public void setSpinnerIni(JSpinner spinnerIni) {
		this.spinnerIni = spinnerIni;
	}

	public JSpinner getSpinnerFin() {
		return spinnerFin;
	}

	public void setSpinnerFin(JSpinner spinnerFin) {
		this.spinnerFin = spinnerFin;
	}

	public String getTxtFechaIni(){

		JSpinner.DateEditor d = new JSpinner.DateEditor(this.spinnerIni, "yyyy-MM-dd");
		return d.getFormat().format(spinnerIni.getValue());
	}
	
	public String getTxtFechaFin(){

		JSpinner.DateEditor d = new JSpinner.DateEditor(this.spinnerFin, "yyyy-MM-dd");
		return d.getFormat().format(spinnerFin.getValue());
	}

}

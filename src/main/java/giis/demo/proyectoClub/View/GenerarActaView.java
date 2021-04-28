package giis.demo.proyectoClub.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class GenerarActaView {

	private JFrame frame;
	private JTextField tfOrdenDia;
	private JLabel lblAadirPropuestaAprobada;
	private JTextField tfPropuestas;
	private JTextField tfIDFavor;
	private JTextField tfIDContra;
	private JTextField tfAsamblea;
	
	

	public JTextField getTfIDFavor() {
		return tfIDFavor;
	}

	public void setTfIDFavor(JTextField tfIDFavor) {
		this.tfIDFavor = tfIDFavor;
	}

	public JTextField getTfIDContra() {
		return tfIDContra;
	}

	public void setTfIDContra(JTextField tfIDContra) {
		this.tfIDContra = tfIDContra;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarActaView window = new GenerarActaView();
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
	public GenerarActaView() {
		initialize();
	}

	
	
	
	
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTfResumen() {
		return tfOrdenDia;
	}

	public void setTfResumen(JTextField tfResumen) {
		this.tfOrdenDia = tfResumen;
	}

	

	public JTextField getTfPropuestas() {
		return tfPropuestas;
	}

	public void setTfPropuestas(JTextField tfPropuestas) {
		this.tfPropuestas = tfPropuestas;
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblOrdenDia = new JLabel("Orden del día de la Asamblea especificada:");
		
		tfOrdenDia = new JTextField();
		tfOrdenDia.setColumns(10);
		
		lblAadirPropuestaAprobada = new JLabel("Indique una propuesta aprobada:");
		
		tfPropuestas = new JTextField();
		tfPropuestas.setColumns(10);
		
		JButton btnSocioFavor = new JButton("Añadir Socio a Favor");
		
		JButton btnSocioContra = new JButton("Añadir Socio en Contra");
		
		JButton btnCrearActa = new JButton("Crear Acta");
		
		JButton btnReset = new JButton("Reset");
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblId_1 = new JLabel("ID");
		
		tfIDFavor = new JTextField();
		tfIDFavor.setColumns(10);
		
		tfIDContra = new JTextField();
		tfIDContra.setColumns(10);
		
		JLabel lblIndiqueElId = new JLabel("Indique el ID de la Asamblea:");
		
		tfAsamblea = new JTextField();
		tfAsamblea.setColumns(10);
		
		JLabel lblId_2 = new JLabel("ID");
		
		JButton btnOk = new JButton("OK");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
							.addComponent(btnCrearActa))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSocioContra)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(lblId_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfIDContra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSocioFavor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblId)
							.addGap(9)
							.addComponent(tfIDFavor, 0, 0, Short.MAX_VALUE))
						.addComponent(tfPropuestas, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
						.addComponent(lblAadirPropuestaAprobada)
						.addComponent(tfOrdenDia, 372, 372, 372)
						.addComponent(lblOrdenDia, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblId_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfAsamblea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnOk))
							.addComponent(lblIndiqueElId)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIndiqueElId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId_2)
						.addComponent(tfAsamblea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk))
					.addGap(28)
					.addComponent(lblOrdenDia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfOrdenDia, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAadirPropuestaAprobada)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfPropuestas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSocioFavor)
							.addComponent(lblId))
						.addComponent(tfIDFavor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSocioContra)
						.addComponent(tfIDContra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId_1))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnCrearActa))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}

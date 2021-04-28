package giis.demo.proyectoClub.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GenerarActaView {

	private JFrame frame;
	private JTextField tfOrdenDia;
	private JLabel lblAadirPropuestaAprobada;
	private JTextField tfPropuestas;
	private JTextField tfIDFavor;
	private JTextField tfIDContra;
	private JTextField tfAsamblea;
	private JButton btnSocioFavor;
	private JButton btnSocioContra;
	private JButton btnAnadirGeneral;
	private JButton btnReset;
	private JButton btnCrearActa;
	private JButton btnOk;
	
	
	public JTextField getTfAsamblea() {
		return tfAsamblea;
	}

	public void setTfAsamblea(JTextField tfAsamblea) {
		this.tfAsamblea = tfAsamblea;
	}

	public JButton getBtnAnadirGeneral() {
		return btnAnadirGeneral;
	}

	public void setBtnAnadirGeneral(JButton btnAnadirGeneral) {
		this.btnAnadirGeneral = btnAnadirGeneral;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
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
		this.btnSocioContra.setEnabled(false);
		this.btnSocioFavor.setEnabled(false);
		
	}

	
	
	public JButton getBtnSocioFavor() {
		return btnSocioFavor;
	}

	public void setBtnSocioFavor(JButton btnSocioFavor) {
		this.btnSocioFavor = btnSocioFavor;
	}

	public JButton getBtnSocioContra() {
		return btnSocioContra;
	}

	public void setBtnSocioContra(JButton btnSocioContra) {
		this.btnSocioContra = btnSocioContra;
	}

	
	
	
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
		frame.setBounds(100, 100, 480, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblOrdenDia = new JLabel("Orden del día de la Asamblea especificada:");
		
		tfOrdenDia = new JTextField();
		tfOrdenDia.setColumns(10);
		
		lblAadirPropuestaAprobada = new JLabel("Indique una propuesta aprobada:");
		
		tfPropuestas = new JTextField();
		tfPropuestas.setColumns(10);
		
		btnSocioFavor = new JButton("Añadir Socio a Favor");
		
		btnSocioContra = new JButton("Añadir Socio en Contra");
		
		btnCrearActa = new JButton("Crear Acta");
		
		btnReset = new JButton("Reset");
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblId_1 = new JLabel("ID");
		
		tfIDFavor = new JTextField();
		tfIDFavor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if (tfIDFavor.getText().length() != 0){
					btnSocioFavor.setEnabled(true);
				}
				
				else {
					btnSocioFavor.setEnabled(false);
				}
				
				
			}
		});
		tfIDFavor.setColumns(10);
		
		tfIDContra = new JTextField();
		tfIDContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (tfIDContra.getText().length() != 0){
					btnSocioContra.setEnabled(true);
				}
				
				else {
					btnSocioContra.setEnabled(false);
					
				}
				
			}
		});
		tfIDContra.setColumns(10);
		
		JLabel lblIndiqueElId = new JLabel("Indique el ID de la Asamblea:");
		
		tfAsamblea = new JTextField();
		tfAsamblea.setColumns(10);
		
		JLabel lblId_2 = new JLabel("ID");
		
		btnOk = new JButton("OK");
		
		btnAnadirGeneral = new JButton("Añadir");
		btnAnadirGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAadirPropuestaAprobada)
						.addComponent(lblOrdenDia, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblId_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfAsamblea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOk))
						.addComponent(lblIndiqueElId)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnSocioContra)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tfOrdenDia, Alignment.LEADING, 372, 372, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSocioFavor)
										.addComponent(btnReset))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(47)
											.addComponent(lblId)
											.addGap(18)
											.addComponent(tfIDFavor, 0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(50)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnCrearActa)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblId_1)
													.addGap(18)
													.addComponent(tfIDContra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(tfPropuestas, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAnadirGeneral)))))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfPropuestas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnadirGeneral))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSocioFavor)
						.addComponent(tfIDFavor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSocioContra)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfIDContra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblId_1)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrearActa)
						.addComponent(btnReset))
					.addGap(106))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JButton getBtnCrearActa() {
		return btnCrearActa;
	}

	public void setBtnCrearActa(JButton btnCrearActa) {
		this.btnCrearActa = btnCrearActa;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}
}

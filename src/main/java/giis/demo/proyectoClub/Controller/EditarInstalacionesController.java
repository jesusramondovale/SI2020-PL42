package giis.demo.proyectoClub.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import giis.demo.proyectoClub.View.EditarInstalacionesView;

public class EditarInstalacionesController {

	private EditarInstalacionesView view;
	public int nivel;
	public int dias;

	public EditarInstalacionesController(EditarInstalacionesView v) {
		this.view = v;
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();

		view.getbCancelar().addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				view.getFrame().setVisible(false);
			}
		});

		view.getbAceptar().addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				view.getFrame().setVisible(false);
			}
		});

		view.getCbDias().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!(view.getCbDias().getSelectedItem().toString()).equals("Dias")) {
					dias = Integer.parseInt(view.getCbDias().getSelectedItem().toString());
				}
			}
		});	
	}


	public void initView() {
		view.getFrame().setVisible(true);
	}
}


package giis.demo.proyectoClub.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.proyectoClub.View.EditarInstalacionesView;
import giis.demo.proyectoClub.model.EditarInstalacionesModel;

public class EditarInstalacionesController {

	private EditarInstalacionesView view;
	private EditarInstalacionesModel model;
	public int nivel;
	public int dias;

	public EditarInstalacionesController(EditarInstalacionesModel m, EditarInstalacionesView v) {
		this.model = m;
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
				nivel = view.getSlider().getValue();
				if(nivel != 1) {
					List<InstalacionDisplayDTO> aforo = model.getAforo();
					for(int i = 0; i < aforo.size(); i++) {
						if(nivel == 2) {
							model.editarAforo(aforo.get(i).getAforo()*(0.75));
						}
						if(nivel == 3) {
							model.editarAforo(aforo.get(i).getAforo()*(0.60));
						}
						if(nivel == 4) {
							model.editarAforo(aforo.get(i).getAforo()*(0.50));
						}
					}
				}
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


package giis.demo.proyectoClub.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import giis.demo.proyectoClub.DTO.SociosDisplayDTO;
import giis.demo.proyectoClub.View.MostrarSociosView;
import giis.demo.proyectoClub.View.ReciboCuotaView;
import giis.demo.proyectoClub.View.generarLotesView;
import giis.demo.proyectoClub.model.MostrarSociosModel;
import giis.demo.proyectoClub.model.ReciboCuotaModel;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class cerrarLotesController {

	
	private ReciboCuotaModel model;
	private generarLotesView view;

	
	public cerrarLotesController(ReciboCuotaModel m, generarLotesView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();

		view.getBtncerrarLotes().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarLotes();				
			}
		});

	}

	public void initView() {
		
		view.getCerrarLotes().setVisible(true);
		//lotesView.getFrame().setVisible(false);
	}
	
	public static Calendar convFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Calendar fechaDate =Calendar.getInstance();
		try {
		fechaDate.setTime(formato.parse(fecha));
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return fechaDate;
		}
	public void cerrarLotes() {
		ArrayList lista = model.getFechaEmision();
		List<Calendar> listaFecha= new ArrayList<Calendar> ();
		List<SociosDisplayDTO> socios = model.getSocios();
		int contador=0;
		for(int i = 0; i<lista.size(); i++) {
			Calendar f = convFecha(lista.get(i).toString());
			listaFecha.add(f);
		}
		for(int j =0;j<listaFecha.size(); j++) {
			String mes= Integer.toString(listaFecha.get(j).get(Calendar.MONTH));
			if(mes.equals(numeroMes(view.getCbMes().getSelectedItem().toString()))){
				contador++;
			}
			if(contador==socios.size()) {
				JOptionPane.showConfirmDialog(null, "Se ha cerrado el lote", "Cerrar Lotes", JOptionPane.DEFAULT_OPTION);
			}
			else {
				JOptionPane.showConfirmDialog(null, "Faltan recibos por generar", "Cerrar Lotes", JOptionPane.DEFAULT_OPTION);
			}
		}
		
	 }
	 public String numeroMes(String mes) {
		 String mesNumero;
		 switch(mes) {
		 	
		 	case "enero": mesNumero="0";
		 		  		  break;
		 	case "febrero": mesNumero="1";
	 						break;	
		 	case "marzo": mesNumero="2";
				break;	
		 	case "abril": mesNumero="3";
				break;	
		 	case "mayo": mesNumero="4";
				break;	
		 	case "junio": mesNumero="5";
				break;	
		 	case "julio": mesNumero="6";
				break;
		 	case "agosto": mesNumero="7";
				break;
		 	case "septiembre": mesNumero="8";
				break;	
		 	case "octubre": mesNumero="9";
				break;	
		 	case "noviembre": mesNumero="10";
				break;	
		 	case "diciembre": mesNumero="11";
		 		break;	
			default: mesNumero="Mes invalido";
				break;
		 }
		 return mesNumero;
	 }
}
	
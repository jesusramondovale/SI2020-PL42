package giis.demo.proyectoClub.Model;

import java.util.Date;
import java.util.List;
import java.util.Properties;





import javax.mail.PasswordAuthentication;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import giis.demo.proyectoClub.DTO.SociosDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class CrearAsambleasModel {

	private Database db=new Database();
	private Date hoy = new Date(System.currentTimeMillis());


	private String password; 

	private Session session;


	public void generarAsamblea(int idAsamblea, String tipo, String ordenDia, Date fechaAsamblea, String hora1, String hora2, 
			String ID, String fecha){

		validateFecha(fechaAsamblea);
		 // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


		String SQL_ASAMBLEA= 
				"insert into asambleas (idAsamblea , tipo , ordenDia , fechaAsamblea , hora1 ,hora2)"
						+ " values"
						+" (?, ?, ?, ?, ?, ?) ";

		String SQL_CORREOS =
				"SELECT correo "
						+ "FROM socio" ;

		List<SociosDTO> socios = db.executeQueryPojo(SociosDTO.class, SQL_CORREOS);

		JPasswordField pf = new JPasswordField(); int okCxl = JOptionPane.showConfirmDialog(null, pf, "Introduzca la contraseña del correo de administrador:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE); 
		if (okCxl == JOptionPane.OK_OPTION && pf.getPassword().length != 0) {
			
			password = new String(pf.getPassword()); 
			
		}
		// Get the Session object.// and pass username and password
        session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("jesus.fabero@gmail.com", password);

            }

        });
        
       
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("jesus.fabero@gmail.com"));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress("roalte67@gmail.com"));

            message.setSubject("Notificación de asamblea");

            message.setText("Convocatoria para la asamblea #" + ID + "\n" + 
                             "Fecha: " + fecha + "\n" + 
            		         "Orden del dia: " + ordenDia);

            System.out.println("Enviando mensaje...");
            // Send message
            Transport.send(message);
            System.out.println("Mensaje enviado correctamente....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
   
        
		db.executeUpdate(SQL_ASAMBLEA ,idAsamblea, tipo, ordenDia, Util.dateToIsoString(fechaAsamblea), hora1, hora2);
		JOptionPane.showMessageDialog(null, "Asamblea creada con éxito!");

	}

	private void validateFecha(Date fecha){
		validateCondition(hoy.compareTo(fecha)<=0, "La fecha no puede ser anterior a la actual!");
	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

}

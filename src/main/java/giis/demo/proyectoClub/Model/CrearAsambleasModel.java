package giis.demo.proyectoClub.Model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;





import javax.mail.PasswordAuthentication;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import giis.demo.proyectoClub.DTO.SociosDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class CrearAsambleasModel {

	private Database db=new Database();
	private Date hoy = new Date(System.currentTimeMillis());


	private String password; 

	private Session session;


	public void generarAsamblea(int idAsamblea, String tipo, String ordenDia, Date fechaAsamblea, String hora1, String hora2, 
			String ID, String fecha, boolean acta){

		validateFecha(fechaAsamblea);
		 // Get system properties
		Properties props = new Properties(); 
        // Setup mail server
        
        props.setProperty("mail.transport.protocol", "smtp");     
        props.setProperty("mail.host", "smtp.gmail.com");  
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.port", "587");  
        props.put("mail.debug", "true");  
        props.put("mail.smtp.socketFactory.port", "465");  
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
        props.put("mail.smtp.socketFactory.fallback", "false");       
        


		String SQL_ASAMBLEA= 
				"insert into asambleas (idAsamblea , tipo , ordenDia , fechaAsamblea , hora1 ,hora2)"
						+ " values"
						+" (?, ?, ?, ?, ?, ?) ";

		String SQL_CORREOS =
				"SELECT correo "
						+ "FROM socio" ;

		//List<SociosDTO> socios = db.executeQueryPojo(SociosDTO.class, SQL_CORREOS);

		try {
			db.executeUpdate(SQL_ASAMBLEA ,idAsamblea, tipo, ordenDia, Util.dateToIsoString(fechaAsamblea), hora1, hora2);
		}
		catch (UnexpectedException e){
			
			JOptionPane.showMessageDialog(null, "ERROR! La asamblea con el ID introducido ya existe!");
			return;
			
		}
		
		JPasswordField pf = new JPasswordField(); int okCxl = JOptionPane.showConfirmDialog(null, pf, "Introduzca la contraseña del correo de administrador:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE); 
		if (okCxl == JOptionPane.OK_OPTION && pf.getPassword().length != 0) {
			
			password = new String(pf.getPassword()); 
			
		}
		// Get the Session object.// and pass username and password
		session = Session.getDefaultInstance(props,  
			    new javax.mail.Authenticator() {
			       protected PasswordAuthentication getPasswordAuthentication() {  
			       return new PasswordAuthentication("jesus.fabero@gmail.com",password);  
			   }  
			   });  
        
       try{
		   Transport transport = session.getTransport();  
		   String from = "jesus.fabero@gmail.com" ;
		   String to = "roalte67@gmail.com" ;


	         Message message = new MimeMessage(session);
         
	         message.setFrom(new InternetAddress(from));

	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));

	         message.setSubject("Notificación de convocatoria");

	         BodyPart messageBodyPart = new MimeBodyPart();

	         messageBodyPart.setText("Convocatoria para la asamblea #" + ID + "\n" + 
	        		 					"Fecha: " + fecha + "\n" + 
	        		 					"Orden del dia: " + ordenDia);

	         
	         // Mensaje multiparte
	         Multipart multipart = new MimeMultipart();

	         // Añade el texto del mensaje
	         multipart.addBodyPart(messageBodyPart);
	         
	         if(acta){
	         // Part two is attachment
	        	 messageBodyPart = new MimeBodyPart();
	        	 String filename = "Acta_" + (idAsamblea-1) + ".pdf";
	        	 DataSource source = new FileDataSource(filename);
	        	 messageBodyPart.setDataHandler(new DataHandler(source));
	        	 messageBodyPart.setFileName(filename);
	        	 multipart.addBodyPart(messageBodyPart);
	        	 message.setContent(multipart);
	         }
	         
	         

	         
	         System.out.println("Enviando el mensaje a los socios...");
	         
	         //transport.send(message);

	         System.out.println("Mensaje enviado correctamente!");
       }
       catch (MessagingException me ){
    	   System.err.println("send failed, exception: " + me);
       }
   
        
		
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

package tn.esprit.rendez_vous;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail
{

	
	  public SendMail() 
	    {
	    }

	    public static void sendEMail(String mail, String etat,String nom,String prenom) {
	        final String username = "epionepi@gmail.com";
	        final String password = "Epione123/";
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }

	        });
	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("Epione"));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
	            message.setSubject("Annulation rendez vous");
	            message.setContent("<html>\n"
	                    + "<head>\n"
	                    + "<style>\n"
	                    + ".div_principale a:hover {\n"
	                    + "	border-bottom: 1px solid #253c93; }\n"
	                    + "</style>\n"
	                    + "</head>\n"
	                    + "<body>\n"
	                    + "<div style=\"width:80%;margin-left:10%;border: 1.5px solid #1b1a19;/* outer shadows  (note the rgba is red, green, blue, alpha) */-webkit-box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.4); -moz-box-shadow: 0px 1px 6px rgba(23, 69, 88, .5);\n"
	                    + "\n"
	                    + "-webkit-border-radius: 12px;\n"
	                    + "-moz-border-radius: 7px; \n"
	                    + "border-radius: 7px;\n"
	                    + "\n"
	                    + "background: -webkit-gradient(linear, left top, left bottom, \n"
	                    + "color-stop(0%, white), color-stop(15%, white), color-stop(100%, #D7E9F5)); \n"
	                    + "background: -moz-linear-gradient(top, white 0%, white 55%, #D5E4F3 130%); \">\n"
	                    + "<img src=\"http://localhost:18080/EpionePi-web/resources/assets/images/epioneLogo.png\" style=\"width: 90%;height: 250;margin-left: 5%;\">\n"
	                    + "<div style=\"margin-left:7%;\">\n"
	                    + "<p class=\"p\"><h3>Bonjour "+nom+" "+prenom+",</h3>\n"
	                    + "Bienvenue chez <b>Epione</b>. Nous vous informons que vous avez annuler votre rendez vous !<br><br>\n"
	                    + "<p>\n"
	                    + "Vous pouvez accÃ©der au site : <a href=\"\" style=\"color: #253c93;text-decoration: none;\">www.epione.tn</a>\n"
	                    + "</p>\n"
	                    + "<div>\n"
	                    + "</div>\n"
	                    + "</body>\n"
	                    + "</html>", "text/html; charset=utf-8");
	            Transport.send(message);
	            System.out.println("Was the email : Done");
	        } catch (Exception e) {
	            //throw new RuntimeException(e);
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    
}

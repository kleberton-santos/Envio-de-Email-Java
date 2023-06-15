package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	private String userName = "ti.klebersantos2@gmail.com";
	private String senha = "kleber4815162342";
	private String listaDestinatarios = "";
	private String nomeRemetentes = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	

	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetentes, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetentes = nomeRemetentes;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}



	public void enviarEmail(boolean envioHtml) throws Exception {
		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true"); // autorização
		properties.put("mail.smtp.starttls", "true"); // autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); // servidor gmail
		properties.put("mail.smtp.port", "465"); // porta
		properties.put("mail.smtp.socketFactory.port", "465"); // porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // classe socket de conexao
																							// ao smtp

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, senha);
			}
		});

		Address[] toUser = InternetAddress.parse(listaDestinatarios);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName,nomeRemetentes)); // Quem esta enviando
		message.setRecipients(Message.RecipientType.TO, toUser); // Email de destino
		message.setSubject(assuntoEmail); // assunto do email
		
		if(envioHtml) {
			message.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			message.setText(textoEmail); // corpo do email
		}
		
		Transport.send(message);
		
	}
}

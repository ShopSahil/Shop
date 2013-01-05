package shop.util;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.flower.config.ConfigMangaer;


public class MailUtil extends HttpServlet{
	
	ConfigMangaer cm = ConfigMangaer.getInstance();
	Properties p = cm.getProperties();

	String mailServerAddress = p.getProperty("mailServerAddress");
	String mailUserId = p.getProperty("mailUserId");
	String mailPassword = p.getProperty("mailPassword");
	String subject	= "Test For Flower Mail";
	String contentsText = "";
	String contentsHtml = "Dear Recipient, \n\n"
						  + "This is an official email from VAS Flower Shop.\n\n"
						  + "You have registerd in VAS with below credentials.\n\n"
						  + "UserID= newUserEmailId \n\n"
						  + "Password= newUserPassword \n\n"
						  + "Please visit again. Thanks!!\n\n" ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailUtil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		sendMails(request.getParameter("receiverMails"), request.getParameter("newPassword"));
	}
	
	public String sendMails(String receiverMails, String newPassword)
	{
		System.out.println("receiverMails=="+receiverMails);
		String receiverEmail[] = receiverMails.split(",");
		for(int i=0; i<receiverEmail.length;i++)
		{
			contentsHtml = contentsHtml.replace("newUserEmailId", receiverEmail[i]) ;
			contentsHtml = contentsHtml.replace("newUserPassword", newPassword) ;
			 
			sendMail(mailUserId,mailPassword,receiverEmail[i],contentsText,contentsHtml,subject,mailServerAddress);
		}
		
		return " Mail sent.";
	}

	
	public void sendMail(String senderEmail,String password ,String receiverEmail,String contentsText, String contentsHtml, String subject,String mailipAddress, String Attachment)
	{
	try{
		System.out.println(senderEmail + " Sending Mail Alert to "+receiverEmail+ " with attachment "+Attachment+ " using mail server "+ mailipAddress+" having subject "+ subject);
		System.out.println("The mail conteXt is "+contentsText+" and content is "+contentsHtml);
		if(senderEmail.equals("")||senderEmail.equals(null)||receiverEmail.equals("")||receiverEmail.equals(null))
		{
			System.out.println("Kindly configure the mailConfig.ini file properly for Mail server.");
			System.exit(0);
		}

		System.out.println(senderEmail + " Sending Mail Alert to "+receiverEmail);
		//SMTP_Client client = new SMTP_Client();

			if((Attachment!=null && Attachment!= ""))
		    {
				test(senderEmail, password ,receiverEmail,contentsText, contentsHtml, subject, mailipAddress, Attachment);
				/*client.connect(mailipAddress);
				client.startMultiPartMimeAlternative(senderEmail,receiverEmail,subject);
				client.addMessageBodyAsHtml(contentsHtml);
				client.addFileAsAttachment(Attachment,Attachment.substring(Attachment.lastIndexOf(File.separator)));
				client.endMultiPartMime();*/
		    }else
		    {
		    	run(senderEmail, password ,receiverEmail,contentsText, contentsHtml, subject,mailipAddress);
		    	/*client.connect(mailipAddress);
				client.startMultiPartMimeAlternative(senderEmail,receiverEmail,subject);
				client.addMessageBodyAsHtml(contentsHtml);
				client.endMultiPartMime();*/

		    }
		    // Send the message


		}catch(Exception e)
		{
			//System.out.println("Unable to send e-mail to :"+senderEmail);
			System.out.println("Unable to send e-mail to :"+senderEmail+"\nError is : "+e.getMessage());
			e.printStackTrace();
			
			return;
		}
	}
    @SuppressWarnings("static-access")
	public void test(String senderEmail,String password ,String receiverEmail,String contentsText, String contentsHtml, String subject,String mailipAddress, String Attachment) throws Exception{
        try {System.out.println(":::::::::::: in test method");
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", mailipAddress);
			props.put("mail.smtp.auth", "true");

			Authenticator auth = new SMTPAuthenticator(senderEmail,password);

			Session mailSession = Session.getInstance(props, auth);

			
			// uncomment for debugging infos to stdout
			// mailSession.setDebug(true);
			Transport transport = mailSession.getTransport();

			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(subject);
					//message.setFrom(new InternetAddress(UtilityMethods.SMTP_AUTH_SENDER));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiverEmail));
			message.addFrom(new InternetAddress[] { new InternetAddress(senderEmail) });
			message.setContent(contentsHtml,"text/html");
			message.setDisposition("inline");
			MimeBodyPart messageBodyPart = new MimeBodyPart();

			//fill message
			messageBodyPart.setText(contentsHtml);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source =  new FileDataSource(Attachment);
			messageBodyPart.setDataHandler( new DataHandler(source));
			messageBodyPart.setFileName(Attachment);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			//transport.connect();
			transport.send(message);
			//transport.close();
						System.out.println(":::::::::::: in test method,sent");

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
}

	
public String sendMail(String senderEmail,String password,String receiverEmail,String contentsText, String contentsHtml, String subject,String mailipAddress) 
{
	try
	{
		run(senderEmail, password ,receiverEmail,contentsText, contentsHtml, subject,mailipAddress);
	}
	catch(Exception e)
	{
		System.out.println("Unable to send e-mail to :"+receiverEmail);
		e.printStackTrace();
		String error = e.getMessage();
		if(error != null && error.indexOf("AuthenticationFailedException")>=0)
			error = "Authentication failed.";
		return "Unable to send e-mail to :"+receiverEmail+" . "+error;
		
	}
	return "Task assigned to selected user.";
}


@SuppressWarnings("unused")
private void run(String senderEmail,String password ,String receiverEmail,String contentsText, String contentsHtml, String subject,String mailipAddress) throws Exception {
	try{
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", mailipAddress);
		props.put("mail.smtp.auth", "true");  

		Authenticator auth = new SMTPAuthenticator(senderEmail,password);
		Session mailSession = Session.getInstance(props, auth);
		// uncomment for debugging infos to stdout
		// mailSession.setDebug(true);
		Transport transport = mailSession.getTransport();

		//MimeMessage message = new MimeMessage(mailSession);
		Message message = new MimeMessage(mailSession);

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
		message.addFrom(new InternetAddress[] { new InternetAddress(senderEmail) });

		message.setSubject(subject);
		message.setContent(contentsHtml, "text/html");
		message.setDisposition("inline");

		Transport.send(message);
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
	}

	 private class SMTPAuthenticator extends javax.mail.Authenticator {
	     public String userName="";
		 public String password="";		 
	     public SMTPAuthenticator(String userName,String password)
		 {
		      this.userName=userName;
			  this.password=password;
			  System.out.println("username and password==="+this.userName );
		 }
        public PasswordAuthentication getPasswordAuthentication() {
           String username = userName;
           String password1 = password;
		   System.out.println("username==="+username );
		   System.out.println("password==="+password );
           return new PasswordAuthentication(username, password1);
        }
    }	

}

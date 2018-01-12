<%@page import="java.util.*" %>
<%@page import="java.io.*"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="javax.activation.*"%>
<%
Transport transport = null;

        try {
            Properties props = System.getProperties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "smtp.pcsglobal.in");
            props.put("mail.smtp.port","587" );
            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.user", "hr@pcsglobal.in");
            props.setProperty("mail.password", "Kolkata@781");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject("Welcome to The Professional Tutors Family !");
            message.setFrom(new InternetAddress("hr@pcsglobal.in"));
			
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("prashanta.pcsglobal@gmail.com"));

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();



           String content = "<html><head><title>" +
                        message.getSubject()
                        +"</title></head><body><h1>"
                        + message.getSubject()
                        + "</h1><p> Dear "+ "Alok" + " , </p>"
                        + "<p>Thank you for signing up with us. Your new account has been setup and you can now login to sign-up area using the details below. </p>"
                        + "<p>Membership Id: "+" Membership Id"+" </p>"
                        + "<p>Email Address: "+ "sendTo" + "</p>"
                        + "<p>User Id: "+"userName"+" </p>"
                        + "<p>Password: "+ "password"+" </p>"
                        + "<p>To login, visit http://www.tpcsglobal.com </p>"
                        + "<p>Assuring you of our best, fast & effective education services </p>"
                        + "<p>&nbsp;</p>"
                        + "<p>Warm Regards</p>"
                        + "<p>The Professional Consultancy Services</p>"
                        + "<p>Mobile:919748556776</p>"
                        +"</body></html>";


          //  String content  = goDaddySubjectContent(message,membershipId,senderName, sendTo ,userName,password);
            messageBodyPart.setContent(content, "text/html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            transport.connect("smtp.pcsglobal.in", "hr@pcsglobal.in", "Kolkata@781");
           // setHTMLContent(message,membershipId,senderName, sendTo,userName,password);
            message.saveChanges(); // don't forget this
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            System.out.println("Mail Sent  ");%>
            <%="Mail Send"%>
        <%} catch (Exception e) {
out.println("Message : " + e.getMessage());
e.printStackTrace();
}
        %>
 
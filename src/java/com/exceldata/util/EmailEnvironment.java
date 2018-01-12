package com.exceldata.util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class EmailEnvironment {

    public static Properties getproperties(Transport transport) {
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.pcsglobal.in");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.user", "hr@pcsglobal.in");
        props.setProperty("mail.password", "Kolkata@781");

        return props;
    }

    public static String getInterviewContent(MimeMessage message, String name, String date) {
        String content = null;
        try {
            content = "<html><head><title>"
                    + message.getSubject()
                    + "</title></head><body><h1>"
                    + message.getSubject()
                    + "</h1><p> Dear " + name + " , </p>"
                    + "<p>Thank you for sending resume to us . Your CV has been shortlisted for the interview process with Perennation Computer Solutions Global Private Limited (PCS GLOBAL). </p>"
                    + "<p>Please find following details for your interview schedule.</p>"
                    + "<p>Interview Date : "+date+"</p>"
                    + "<p>Reporting Time: 10:00 AM</p>"
                    + "<p>Venue Details:  PCS Global, Suite -914,DN-51,Merlin Infinite,Kolkata-91 Salt Lake Sector-V, Near RS Software.</p>"
                    + "<p>Visit Us : www.pcsglobal.in / www.pcsglobal.co</p>"
                    + "<p>Contact Person: Sucharita Patra / Debapriya Das</p>"
                    + "<p>&nbsp;</p>"
                    + "<p>Kindly note,</p>"
                    + "<p>a. All past service certificates</p>"
                    + "<p>b. Current company offer and hike letter (if any)</p>"
                    + "<p>c. Photo Copy of Highest Educational Qualification Degree certificates and its mark sheets</p>"
                    + "<p>d. Govt. Photo ID proof.</p>"
                    + "<p>e. Updated hard-copy resume</p>"
                    + "<p>f. Print out of this mail</p>"
                    + "<p>&nbsp;</p>"
                    + "<p>&nbsp;</p>"
                    + "<p>Thanks & Regards.</p>"
                    + "<p>HR Department</p>"
                    + "<p>Perennation Computer Solutions Global Pvt Ltd</p>"
                    + "<p>An ISO 9001:2008 Certified S/ W Development and IT Service Provider Company</p>"
                    + "<p>Email id: careers@pcsglobal.in/ hr@pcsglobal.in</p>"
                    + "<p>Mobile No.-8697741613/033-40012426</p>"
                    + "</body></html>";

        } catch (MessagingException ex) {
            Logger.getLogger(EmailEnvironment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
    
    
    
    public static String getInternshipContent(MimeMessage message, String name) {
        String content = null;
        try {
            content = "<html><head><title>"
                    + message.getSubject()
                    + "</title></head><body><h1>"
                    + message.getSubject()
                    + "</h1><p> Dear " + name + " , </p>"
                    + "<p>Thank you for sending resume to us . Your CV has been shortlisted for the interview process with Perennation Computer Solutions Global Private Limited (PCS GLOBAL). </p>"
                    + "<p>Please find following details for your interview schedule.</p>"
                    + "<p>Interview Date:17th November,17.(Saturday)</p>"
                    + "<p>Reporting Time: 10:00 AM</p>"
                    + "<p>Venue Details:  PCS Global, Suite -914,DN-51,Merlin Infinite,Kolkata-91 Salt Lake Sector-V, Near RS Software.</p>"
                    + "<p>Visit Us : www.pcsglobal.in / www.pcsglobal.co</p>"
                    + "<p>Contact Person: Sucharita Patra / Debapriya Das</p>"
                    + "<p>&nbsp;</p>"
                    + "<p>Kindly note,</p>"
                    + "<p>a. All past service certificates</p>"
                    + "<p>b. Current company offer and hike letter (if any)</p>"
                    + "<p>c. Photo Copy of Highest Educational Qualification Degree certificates and its mark sheets</p>"
                    + "<p>d. Govt. Photo ID proof.</p>"
                    + "<p>e. Updated hard-copy resume</p>"
                    + "<p>f. Print out of this mail</p>"
                    + "<p>&nbsp;</p>"
                    + "<p>&nbsp;</p>"
                    + "<p>Thanks & Regards.</p>"
                    + "<p>HR Department</p>"
                    + "<p>Perennation Computer Solutions Global Pvt Ltd</p>"
                    + "<p>An ISO 9001:2008 Certified S/ W Development and IT Service Provider Company</p>"
                    + "<p>Email id: careers@pcsglobal.in/ hr@pcsglobal.in</p>"
                    + "<p>Mobile No.-8697741613/033-40012426</p>"
                    + "</body></html>";

        } catch (MessagingException ex) {
            Logger.getLogger(EmailEnvironment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
}



package servlet;

import com.exceldata.app.SingleClassExcelReaderExample;
import com.exceldata.beans.Candidate;
import com.exceldata.util.EmailEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import com.oreilly.servlet.multipart.FilePart;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;

public class UploadExcelServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        InputStream is = null;
        Workbook workbook = null;
        HttpSession session = request.getSession();
        String msg="";
        List<Candidate> list = new ArrayList<>();
        try {
            MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 1024);  // file limit size of 1GB
            Part _part;
            while ((_part = parser.readNextPart()) != null) {
                if (_part.isFile()) {
                    FilePart fPart = (FilePart) _part;  // get some info about the file
                    String name = fPart.getFileName();
                    System.out.println("file name " + name);
                    if (name != null) {
                        is = fPart.getInputStream();
                        workbook = new XSSFWorkbook(is);
                        Sheet nSheet = workbook.getSheetAt(0);// getSheetAt(0): sheet 1, getSheetAt(1): sheet 2
                        Iterator<Row> iterator = nSheet.iterator();
                        while (iterator.hasNext()) { // Iterate row          
                            Candidate cn = new Candidate();
                            Row nextRow = iterator.next();
                            int row = nextRow.getRowNum();
                            System.out.println("row:" + row);
                            if (row >= 3) {
                                Iterator<Cell> cellIterator = nextRow.cellIterator();
                                while (cellIterator.hasNext()) {// Iterate cell
                                    Cell cell = cellIterator.next();
                                    int colIndex = cell.getColumnIndex();
                                    switch (colIndex) {
                                        case 2:
                                            cn.setFirstname(cell.getStringCellValue());
                                            break;

                                        case 5:
                                            cn.setEmail(cell.getStringCellValue());
                                            break;

                                    }
                                }
                                if ((cn.getFirstname() != null) && (!"".equals(cn.getFirstname())) && (cn.getEmail() != null) && (!"".equals(cn.getEmail()))) {
                                    list.add(cn);
                                }
                            }
                        }
                        // code to sent mail

                        Transport transport = null;
                        Properties props = System.getProperties();
                        props.setProperty("mail.transport.protocol", "smtp");
                        props.setProperty("mail.host", "smtp.pcsglobal.in");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.setProperty("mail.user", "hr@pcsglobal.in");
                        props.setProperty("mail.password", "Kolkata@781");
                        Session mailSession = Session.getDefaultInstance(props, null);
                        mailSession.setDebug(true);
                        transport = mailSession.getTransport("smtp");
                        MimeMessage message = new MimeMessage(mailSession);
                        message.setSentDate(new java.util.Date());
                        message.setSubject("Welcome to Our PCS Family !");
                        message.setFrom(new InternetAddress("hr@pcsglobal.in"));

                        System.out.println("size : " + list.size());
                        for (Candidate c : list) {
                            System.out.println("\nname : " + c.getFirstname() + "      email : " + c.getEmail());

                            message.setRecipient(Message.RecipientType.TO, new InternetAddress(c.getEmail()));
                            MimeMultipart multipart = new MimeMultipart("related");
                            BodyPart messageBodyPart = new MimeBodyPart();
                            String content = EmailEnvironment.getInterviewContent(message, c.getFirstname(), (String)session.getAttribute("ivDate") );
                            messageBodyPart.setContent(content, "text/html");
                            multipart.addBodyPart(messageBodyPart);
                            message.setContent(multipart);

                            transport.connect("smtp.pcsglobal.in", "hr@pcsglobal.in", "Kolkata@781");
                            message.saveChanges(); // don't forget this
                            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                            msg +="<font color='green' size='4'>Sent to :  </font><font color='blue' size='4'>"+c.getEmail()+"</font><br/>";
                            transport.close();
                        }
                    } else {

                    }
                }
            }

        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(UploadExcelServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(UploadExcelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("before redirect");
        msg+="</font>";
        request.setAttribute("msg", msg);

        getServletContext().getRequestDispatcher("/uploadFile.jsp").forward(request, response);
    }

}// End of class

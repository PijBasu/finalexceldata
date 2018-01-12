package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pijush
 */
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        InputStream input = getServletContext().getResourceAsStream("/WEB-INF/email.properties");
//        Properties prop = new Properties();
//        prop.load(input);
//        input.close();
//        String sub = prop.getProperty("subject");
//        String emailbody = prop.getProperty("emailbody");
//        request.setAttribute("sub", sub);
//        request.setAttribute("emailbody", emailbody);
//        
        String p = request.getParameter("p");

        switch (p) {

            case "interview":
                request.setAttribute("body", "set-date.jsp");
                getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
            case "internship":

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String f = request.getParameter("f");

        switch (f) {

            case "interview":
                String ivDate = request.getParameter("ivDate");
                //System.out.println(emailBody);
                //out.print(emailBody);
                session.setAttribute("ivDate", ivDate);
                request.setAttribute("body", "uploadFile.jsp");
                getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
                break;
            case "internship":
                break;

        }

    }

}

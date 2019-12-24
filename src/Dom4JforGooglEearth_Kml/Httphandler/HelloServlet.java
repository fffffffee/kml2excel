package Dom4JforGooglEearth_Kml.Httphandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    String mm = "Hello big baby!";
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        req.setAttribute("String" , mm);
        req.getRequestDispatcher("/webapp/jsp/Hello.jsp").forward(req , resp);
    }
}

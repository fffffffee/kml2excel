package Dom4JforGooglEearth_Kml.Httphandler;

import Dom4JforGooglEearth_Kml.Entity.PlacemarkEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static Dom4JforGooglEearth_Kml.Dom4JforKml.readkml;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    String mm = "Hello big baby!";
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        req.setAttribute("hello" , mm);
        ArrayList<PlacemarkEntity> placemarkList = readkml();
        req.setAttribute("placemarkList" , placemarkList);
        req.getRequestDispatcher("/webapp/jsp/Hello.jsp").forward(req , resp);
    }
}

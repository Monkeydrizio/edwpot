package esericizioCountries;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import javax.annotation.Resource;

@WebServlet("/ControllerCountry")
public class ControllerCountry extends HttpServlet{
private static final long serialVersionUID = 1L;

@Resource(name= "jdbc/hr")
private DataSource ds;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    CountryDAO dao = new CountryDAO(ds);
    Long regionid = (Long) request.getAttribute("regionid");
    
    if (regionid == 1) {
    	request.setAttribute("countries", dao.getEU());
    } else if (regionid == 2){
    	request.setAttribute("countries", dao.getAMER());
    } else if (regionid == 3){
    	request.setAttribute("countries", dao.getAS());
    } else if (regionid == 4){
    	request.setAttribute("countries", dao.getMEA());
    }
        
    request.getRequestDispatcher("/s21/regions2.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response);
}



}

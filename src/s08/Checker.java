package s08;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s08/checker")
public class Checker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user"); // (*)
		Set<Character> set = new TreeSet<>();
		if (user != null) {
			for (char c : user.toCharArray()) {
				set.add(Character.toLowerCase(c));
			}
		}
		request.setAttribute("set", set); // attenzione, quello su cui lavora l'utente sono parametri(*) quelli su cui
											// lavoro io sono ATTRIBUTI. solo l'ultimo dar� la response, quindi il
											// lavoro gi� fatto dalla prima servlet vengno salvati nell'ATTRIBUTO della
											// request e passati alla fase due.

		RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp"); //
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

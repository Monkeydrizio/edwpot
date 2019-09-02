package alfy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AlfyPapRul")
public class AlfyPapRul extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("v1") != null || session.getAttribute("v2") != null
				|| session.getAttribute("v3") != null || session.getAttribute("v4") != null
				|| session.getAttribute("v5") != null) {
			int numero_vinili_uno = (int) session.getAttribute("v1");
			int numero_vinili_due = (int) session.getAttribute("v2");
			int numero_vinili_tre = (int) session.getAttribute("v3");
			int numero_vinili_quattro = (int) session.getAttribute("v4");
			int numero_vinili_cinque = (int) session.getAttribute("v5");
			int vinili_totali = numero_vinili_uno + numero_vinili_due + numero_vinili_tre + numero_vinili_quattro
					+ numero_vinili_cinque;
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			try (PrintWriter writer = response.getWriter()) {
				writer.print(vinili_totali);

			}
		}

		if (request.getParameter("done") != null) {
			session.invalidate();
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			try (PrintWriter writer = response.getWriter()) {
				writer.println("<!DOCTYPE html><html>");
				writer.println("<head><meta charset=\"utf-8\">");
				writer.println("<title>Purchase complete</title></head>");
				writer.println("<body><h1>Goodbye</h1>");
				writer.println("<p>CIAONE");
				writer.println("</body></html>");

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
package s08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s08/CheckerWithUser")
public class CheckerWithUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a = req.getParameter("par");
		Set<Character> set = new TreeSet<>();
		if (a != null) {
			for (char c : a.toCharArray()) {
				set.add(Character.toLowerCase(c));}
				try (PrintWriter writer = resp.getWriter()) {
					resp.setContentType("text/plain");
					resp.setCharacterEncoding("utf-8");
					for (char c:set) {
					writer.print(c);
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package bank_application;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		int accno = Integer.parseInt(req.getParameter("Accno"));
		String name = req.getParameter("name");
		BankAccountBean b1 = new BankAccountBean();
		HttpSession h1=req.getSession();
		h1.setAttribute("accno", accno);
		b1.setAccNo(accno);
		b1.setName(name);
		BankDAO b = new BankDAO();
		boolean result = b.login(b1);
		pw.println("<html><body bgcolor='yellow'>");
		if (result) {
			req.getRequestDispatcher("Dep.html").include(req, res);
		} else {
			pw.println("Invalid Username/Password");
		}

		pw.println("</body></html>");

	}
}

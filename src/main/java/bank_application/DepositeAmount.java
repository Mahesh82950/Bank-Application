package bank_application;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Depos")
public class DepositeAmount extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int amount = Integer.parseInt(req.getParameter("depAmount"));
		PrintWriter pw = res.getWriter();
        HttpSession h1=req.getSession();
        Integer accno=((Integer)h1.getAttribute("accno"));
		BankDAO b1 = new BankDAO();
		if(amount>0) {
		int k = b1.insert(accno, amount);
		if (k > 0) {
			b1.update(accno, amount);
			pw.println("<html><body bgcolor=cyan><h1>Amount Diposited SuccessFully...</h1></body></html>");

		} else {
			pw.println("<html><body bgcolor=cyan><h1>Transcation failed Try Again...</h1></body></html>");
		}
		}
		else {
			pw.println("<html><body bgcolor=cyan><h1>Please Aplii Laykii Dakhavu Naka...</h1></body></html>");

		}
	}

}

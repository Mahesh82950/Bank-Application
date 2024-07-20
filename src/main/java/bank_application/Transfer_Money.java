package bank_application;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Transfer")
public class Transfer_Money extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		double amount = Double.parseDouble(req.getParameter("TranAmount"));
		HttpSession h1=req.getSession();
        Integer accno=((Integer)h1.getAttribute("accno"));
		BankDAO b = new BankDAO();
		PrintWriter pw = res.getWriter();
		if(amount>0) {
		int k = b.insertTransaction(amount, accno);
		if (k > 0) {
			b.updateTransfer(accno, amount);
			pw.println("<html><body bgcolor=cyan><h1>Amount Transfer SuccessFully...</h1></body></html>");

		} else {
			pw.println("<html><body bgcolor=cyan><h1>Transcation failed Try Again...</h1></body></html>");
		}
		}
		else {
			pw.println("<html><body bgcolor=cyan><h1>Please Aplii Laykii Dakhavu Naka...</h1></body></html>");
		}
	}
}

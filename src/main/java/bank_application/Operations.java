package bank_application;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/operation")
public class Operations extends GenericServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String str = req.getParameter("Operation");
		if (str.equals("Deposite Amount")) {
			req.getRequestDispatcher("Deposite.html").include(req, res);
		} else if (str.equals("Transfer Money")) {
			req.getRequestDispatcher("Transfer.html").include(req, res);

		}
	}

}

package bank_application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class BankDAO {

	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login(BankAccountBean b1) {
		try {
			PreparedStatement p1 = con.prepareStatement("select * from bankaccount where accno=? and name=?");
			p1.setInt(1, b1.getAccNo());
			p1.setString(2, b1.getName());
			ResultSet r1 = p1.executeQuery();
			if (r1.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void update(int accno, int amount) {
		try {
			PreparedStatement p1 = con.prepareStatement("Update bankaccount set balance=balance+? where accno=?");
			double balance = amount;
			p1.setDouble(1, balance);
			p1.setInt(2, accno);
			p1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(int accno, int amount) {
		int k = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
			PreparedStatement p1 = con.prepareStatement("insert into transaction values(?,?,?,?)");

			String transId = accno * (int) (Math.random() * 9999) + "";
			p1.setInt(1, accno);
			p1.setString(2, transId);
			p1.setDate(3, Date.valueOf(LocalDate.now()));
			p1.setDouble(4, amount);
			k = p1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	public void updateTransfer(int accno, double amount) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
			PreparedStatement p1 = con.prepareStatement("Update bankaccount set balance=balance-? where accno=?");
			double balance = amount;
			p1.setDouble(1, balance);
			p1.setInt(2, accno);
			p1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertTransaction(double amount, int accno) {
		int k = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
			PreparedStatement p1 = con.prepareStatement("insert into transaction values(?,?,?,?)");

			String transId = accno * (int) (Math.random() * 9999) + "";

			p1.setInt(1, accno);
			p1.setString(2, transId);
			p1.setDate(3, Date.valueOf(LocalDate.now()));
			p1.setDouble(4, amount);
			k = p1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}

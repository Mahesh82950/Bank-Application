package bank_application;

public class BankAccountBean {

	private int AccNo;
	private String name;
	private double balance;
	private String acctype;
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accno) {
		this.AccNo = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	
	
}

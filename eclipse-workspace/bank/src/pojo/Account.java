package pojo;

public class Account {
	
	
	
	
	private String accno;
	private int password;
	private double balance;
	private String name;
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accno == null) ? 0 : accno.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + password;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accno == null) {
			if (other.accno != null)
				return false;
		} else if (!accno.equals(other.accno))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password != other.password)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", password=" + password + ", balance=" + balance + ", name=" + name + "]";
	}
	public Account(String accno, int password, double balance, String name) {
		super();
		this.accno = accno;
		this.password = password;
		this.balance = balance;
		this.name = name;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

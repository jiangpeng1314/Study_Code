package pojo;

public class Log {
	private int id;
	private String accIn;
	private String accOut;
	private double money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccIn() {
		return accIn;
	}
	public void setAccIn(String accIn) {
		this.accIn = accIn;
	}
	public String getAccOut() {
		return accOut;
	}
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accIn == null) ? 0 : accIn.hashCode());
		result = prime * result + ((accOut == null) ? 0 : accOut.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Log other = (Log) obj;
		if (accIn == null) {
			if (other.accIn != null)
				return false;
		} else if (!accIn.equals(other.accIn))
			return false;
		if (accOut == null) {
			if (other.accOut != null)
				return false;
		} else if (!accOut.equals(other.accOut))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", accIn=" + accIn + ", accOut=" + accOut + ", money=" + money + "]";
	}
	public Log(int id, String accIn, String accOut, double money) {
		super();
		this.id = id;
		this.accIn = accIn;
		this.accOut = accOut;
		this.money = money;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

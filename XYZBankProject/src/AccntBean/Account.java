package AccntBean;

public class Account {
	private String accnt_name;
	private String accnt_id;
	private double accnt_balance;
	private String accnt_pin;
	
	public Account(String accnt_name, String accnt_id,
			double accnt_balance, String accnt_pin) {
		super();
		this.accnt_id = accnt_name;
		this.accnt_name = accnt_id;
		this.accnt_balance = accnt_balance;
		this.accnt_pin = accnt_pin;
	}


	public String getAccnt_Id() {
		return accnt_id;
	}

	public void setAccnt_Id(String accnt_id) {
		this.accnt_id = accnt_id;
	}

	public String getAccount_Name() {
		return accnt_name;
	}
	public void setAccount_Name(String account_name) {
		this.accnt_name = account_name;
	}
	public double getAccount_Balance() {
		return accnt_balance;
	}
    public void setAccount_Balance(double account_balance) {
		this.accnt_balance = account_balance;
	}

	public String getAccount_Pin() {
		return accnt_pin;
	}

	public void setAccount_Pin(String account_pin) {
		this.accnt_pin = account_pin;
	}

	@Override
	public String toString() {
		return "Account [name=" + accnt_name + ", id=" + accnt_id +
				", balance=" + accnt_balance + ", pin=" + accnt_pin
				+ "]";
	}
}








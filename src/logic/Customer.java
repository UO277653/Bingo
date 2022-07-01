package logic;

public class Customer {

	private String ID;
	private String name;
	private String surname;
	private int balance;
	
	public Customer(String ID, String name, String surname, int balance){
		setID(ID);
		setName(name);
		setSurname(surname);
		setBalance(balance);
	}
	
	public Customer(String ID, String name, String surname){
		setID(ID);
		setName(name);
		setSurname(surname);
		setBalance(20);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

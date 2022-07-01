package logic;

import java.util.ArrayList;
import java.util.List;

public class CustomerRecord {

	private List<Customer> customers;
	
	private String currentUser;
	
	public CustomerRecord() {
		customers = new ArrayList<Customer>();
		
		loadCustomers();
	}

	private void loadCustomers() {
		FileUtil.loadCustomers(customers);
	}

	public void addNewCustomer(String ID, String name, String surname) {
		
		customers.add(new Customer(ID, name, surname, 20));
		
		currentUser = ID;
		
		FileUtil.writeCustomerData(customers);
	}

	public Customer getCurrentUser() {
		for(Customer c: customers) {
			if(c.getID().equals(currentUser)) {
				return c;
			}
		}
		
		return null;
	}

	public void updateCustomerBalance(String identification) {
		
		for(Customer c: customers) {
			if(c.getID().equals(identification)) {
				c.setBalance(c.getBalance() + 20);
				currentUser = c.getID();
			}
		}
		
		FileUtil.writeCustomerData(customers);
		
	}

	public int getBalance(String ID) {
		for(Customer c: customers) {
			if(c.getID().equals(ID)) {
				return c.getBalance();
			}
		}
		
		return 20;
	}

	public boolean isIDCorrect(String ID) {
		for(Customer c: customers) {
			if(c.getID().equals(ID)) {
				return true;
			}
		}
		return false;
	}

	public String getNameFromID(String ID) {
		for(Customer c: customers) {
			if(c.getID().equals(ID)) {
				return c.getName();
			}
		}
		return null;
	}
	
	public String getSurnameFromID(String ID) {
		for(Customer c: customers) {
			if(c.getID().equals(ID)) {
				return c.getSurname();
			}
		}
		return null;
	}
}

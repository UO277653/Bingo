package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	/*
	 * 
	 * 
	 */
	private static final String TICKETS_FILE = "files/tickets.dat";
	private static final String PRIZES_FILE = "files/gifts.dat";
	private static final String CUSTOMER_FILE = "files/customers.dat";
	
	public static List<Ticket> loadTickets(List<Ticket> ticketsList) {
		
	    String line;
	    String[] ticketData= null;
	    
	    try {
	    	   BufferedReader file = new BufferedReader(new FileReader(TICKETS_FILE));
	    		while (file.ready()) {
	    			line = file.readLine();
	    			ticketData = line.split("@");
	    			ticketsList.add(new Ticket(ticketData[0], ticketData[1]));
	    		}
	    		file.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("File not found.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("I/O Error.");
	    } 
	    
	    return ticketsList;
	    
	}
	
	public static List<Prize> loadPrizes(){
		
	    String line;
	    String[] prizeData= null;
	    List<Prize> res = new ArrayList<Prize>();
	    
	    try {
	    	   BufferedReader file = new BufferedReader(new FileReader(PRIZES_FILE));
	    		while (file.ready()) {
	    			line = file.readLine();
	    			prizeData = line.split("@");
	    			res.add(new Prize(prizeData[0], prizeData[1], prizeData[2]));
	    		}
	    		file.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("File not found.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("I/O Error.");
	    } 
	    
	    return res;
	    
	}

	public static List<Customer> loadCustomers(List<Customer> customerList) {

	    String line;
	    String[] customerData= null;
	    
	    try {
	    	   BufferedReader file = new BufferedReader(new FileReader(CUSTOMER_FILE));
	    		while (file.ready()) {
	    			line = file.readLine();
	    			customerData = line.split("@");
	    			customerList.add(new Customer(customerData[0], customerData[1], customerData[2], Integer.valueOf(customerData[3])));
	    		}
	    		file.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("File not found.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("I/O Error.");
	    } 
	    
	    return customerList;
		
	}

	public static void writeCustomerData(List<Customer> customers) {
		
		String line;
		
		try {
				BufferedWriter file = new BufferedWriter(new FileWriter(CUSTOMER_FILE));
				for(Customer c: customers) {
					line = c.getID() + "@" + c.getName() + "@" + c.getSurname() + "@" + c.getBalance() + "\n";
					file.write(line);
				}
				file.close();
		} 
		catch (FileNotFoundException fnfe) {
		      System.out.println("File not found.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("I/O Error.");
	    } 
		
	}

	public static void writeTickets(List<Ticket> tickets) {
		String line;
		
		try {
				BufferedWriter file = new BufferedWriter(new FileWriter(TICKETS_FILE));
				for(Ticket t: tickets) {
					line = t.getCode() + "@" + t.getValue() + "\n";
					file.write(line);
				}
				file.close();
		} 
		catch (FileNotFoundException fnfe) {
		      System.out.println("File not found.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("I/O Error.");
	    } 
	}
}

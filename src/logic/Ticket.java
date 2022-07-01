package logic;

public class Ticket {

	private String code;
	private double value;
	
	public Ticket(String code, String value) {
		this.code = code;
		this.value = Double.valueOf(value);
	}

	public String getCode() {
		return code;
	}

	public double getValue() {
		return value;
	}
	
	
}

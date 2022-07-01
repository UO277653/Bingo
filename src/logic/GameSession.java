package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSession {

	private static final int NUMBER_OF_CELLS = 9;
	private static final int NUMBER_OF_ROWS = 3;
	private static final int MIN_VALUE = 30;
	private static final String NUMBER_OF_DRAWNS = "30";
	public static final int MAX_NUMBER_OF_LINES = 2;
	
	private List<Ticket> tickets;  // Read from the file
	private Ticket ticket = null;
	private int magicNumber;
	private String magicValueNumber;
	private List<Integer> drawnNumbers;
	
	private boolean[] marked;
	private boolean[] claimedLines;
	private boolean[] expiredLines;
	private boolean bingoExpired = false;
	private boolean isBingo;
	private boolean magicNumberMarked = false;
	private boolean wildCard = false;
	
	private PrizeSelection ps;
	
	
	/**
	 * 
	 */
	public GameSession() {
		tickets = new ArrayList<Ticket>();
		drawnNumbers = new ArrayList<Integer>();
		marked = new boolean[NUMBER_OF_CELLS];
		claimedLines = new boolean[NUMBER_OF_ROWS];
		expiredLines = new boolean[NUMBER_OF_ROWS];
		ps = new PrizeSelection();
		
		loadTickets();
	}
	
	/**
	 * 
	 */
	private void loadTickets() {
		
		FileUtil.loadTickets(tickets);
		
	}
	
	public void setTicket(Ticket argTicket) {
		
		this.ticket = argTicket;
		
	}
	
	public boolean isTicketValid() {
		
		if(ticket.getValue() < MIN_VALUE) {
			return false;
		}
		
		return tickets.contains(ticket);
	}
	
	public boolean isTicketValid( String code ) {
		
		for(Ticket t: tickets) {
			if(t.getCode().equals(code)) {
				if(t.getValue() >= MIN_VALUE) { 
					if(t.getValue() >= 100) // Magic number
					{
						wildCard = true;
					}
					ticket = t;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void useTicket() {
		
		tickets.remove(ticket);
		
		FileUtil.writeTickets(tickets);
	}
	
	/**
	 * Returns an array of integers composed of
	 * 3 non-repeated integers between 1 and 10
	 * 3 non-repeated integers between 11 and 20
	 * and 3 non-repeated integers between 21 and 30
	 * 
	 * @return
	 */
	public int[] generateNumbers() {
		
		int nElements = 3;
		int[] res = new int[NUMBER_OF_CELLS];
		int pos = 0;
		Random rnd = new Random();
		int number;
		
		for(int i = 0; i < nElements; i++) { // cambiar que no puede salir 0
			for(int j = 0; j < nElements; j++) {
				number = rnd.nextInt(10) + (10 * i) + 1;
				while(isRepeated(number, res)) {
					number = rnd.nextInt(10) + (10 * i) + 1;
				}
				res[pos] = number;
				pos++;
			}
		}
		
		return res;
	}

	private boolean isRepeated(int number, int[] res) {
		for(int i = 0; i < res.length; i++) {
			if(number == res[i]) {
				return true;
			}
		}
		return false;
	}

	public int getSpecialNumber() {
		magicNumber = new Random().nextInt(9);
		return magicNumber; // magic number
	}
	
	public int getMagicNumber() {
		return magicNumber;
	}
	
	public String getMagicNumberValue() {
		return magicValueNumber;
	}

	public int generateNumber() {
		int number = new Random().nextInt(30) + 1;
		
		while(drawnNumbers.contains(number)) {
			number = new Random().nextInt(30) + 1;
		}
		
		drawnNumbers.add(number);
		
		return number;
	}
	
	public void addNumber(int n) {
		drawnNumbers.add(n);
	}

	public String getNumberOfDrawns() {
		return NUMBER_OF_DRAWNS;
	}

	public void setMarked(int indexOf) {
		marked[indexOf] = true;
	}

	public void checkLinesCompleted() {
		
		checkRow1();
		
		checkRow2();
		
		checkRow3();
		
	}

	private void checkRow1() {
		if(isLineCompleted(0) && (claimedLines[0] == false)) {
			expiredLines[0] = true;
		}
	}
	
	private void checkRow2() {
		if(isLineCompleted(1) && (claimedLines[1] == false)) {
			expiredLines[1] = true;
		}
	}
	
	private void checkRow3() {
		if(isLineCompleted(2) && (claimedLines[2] == false)) {
			expiredLines[2] = true;
		}
	}
	
	private boolean isLineCompleted(int row) {
		for(int i = 0 + (3*row); i < 3*(row+1); i++) {
			if(marked[i] == false) {
				return false;
			}
		}
		
		return true;
	}

	public void claimLines() {
		if(isLineCompleted(0) && (claimedLines[0] == false) && (expiredLines[0] == false)) {
			claimedLines[0] = true;
		}
		
		if(isLineCompleted(1) && (claimedLines[1] == false) && (expiredLines[1] == false)) {
			claimedLines[1] = true;
		}
		
		if(isLineCompleted(2) && (claimedLines[2] == false) && (expiredLines[2] == false)) {
			claimedLines[2] = true;
		}
	}

	public int getNumberOfPrizes() {
		int counter = 0;
		for(int i = 0; i < claimedLines.length; i++) {
			if(claimedLines[i] == true) {
				counter++;
			}
		}
		return counter;
	}

	public void saveSpecialNumber(String text) {
		magicValueNumber = text;
	}

	public boolean isCompleted() {

		if(isLineCompleted(0) && isLineCompleted(1) && isLineCompleted(2)) {
			if((claimedLines[0] && claimedLines[1]) || (claimedLines[1] && claimedLines[2]) || (claimedLines[2] && claimedLines[0])) {
				// Check that at least two have been claimed before
				if(expiredLines[0] == false && expiredLines[1] == false && expiredLines[2] == false) {
					// Check that there is not any expired line
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isBingo() {
		isBingo = isCompleted() && bingoExpired == false;
		return isBingo;
	}

	public void checkBingo() {
		if(isCompleted()) {
			bingoExpired = true;
		}
		
	}

	public List<Prize> getBingoPrizes() {
		return ps.getBingoPrizes();
	}
	
	public List<Prize> getLinePrizes() {
		return ps.getLinePrizes();
	}

	public boolean isVoucherWon() {
		if(claimedLines[magicNumber/NUMBER_OF_ROWS] == true && magicNumberMarked == true) {
			return true;
		}
		
		return false;
	}

	public void setMagicNumberMarked(boolean status) {
		this.magicNumberMarked = status;
	}

	public void initialize() {
		tickets = new ArrayList<Ticket>();
		loadTickets();
		drawnNumbers = new ArrayList<Integer>();
		marked = new boolean[9];
		claimedLines = new boolean[NUMBER_OF_ROWS];
		expiredLines = new boolean[NUMBER_OF_ROWS];
		bingoExpired = false;
		magicNumberMarked = false;
	}

	public boolean isTicketWildCard() {
		return wildCard;
	}

	public void setWildCard(boolean b) {
		wildCard = b;
	}
	
}

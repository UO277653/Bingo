package logic;

import java.util.ArrayList;
import java.util.List;

public class PrizeSelection {

	private List<Prize> linePrizes;
	private List<Prize> bingoPrizes;
	
	public PrizeSelection() {
		
		linePrizes = new ArrayList<Prize>();
		bingoPrizes = new ArrayList<Prize>();
		
		loadPrizes();
	}

	private void loadPrizes() {
		
		List<Prize> aux = FileUtil.loadPrizes();
		
		for(Prize p: aux) {
			if(p.getType().equals("l")) {
				linePrizes.add(p);
			} else if(p.getType().equals("b")){
				bingoPrizes.add(p);
			}
		}
	}
	
	public List<Prize> getBingoPrizes(){
		return bingoPrizes;
	}
	
	public List<Prize> getLinePrizes(){
		return linePrizes;
	}
}

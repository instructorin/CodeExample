import java.util.ArrayList;

public class Card {

	private String symbol;		//모양
	private int symbolNum;	//모양 순위
	private int rank; 				//숫자
	private String rankChar; //표현 문자
	
	public Card(String symbol, int symbolNum, int rank, String rankChar) {
		this.setSymbol(symbol);
		this.setSymbolNum(symbolNum);
		this.rank = rank;
		this.rankChar = rankChar;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getSymbolNum() {
		return symbolNum;
	}

	public void setSymbolNum(int symbolNum) {
		this.symbolNum = symbolNum;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRankChar() {
		return rankChar;
	}

	public void setRankChar(String rankChar) {
		this.rankChar = rankChar;
	}

		
	@Override
	public String toString() {
		
		return String.format("%s%s", this.symbol, this.rankChar);
	}
	
	
	//카드 만들기(52장)
	public static Card[] init() {
		
		Card[] list = new Card[52];
		String[] slist = { "♠", "♡", "◆", "♧" };
		int[] snlist = { 4, 3, 2, 1 };
		int cardIndex = 0;
		
		for (int j=0; j<slist.length; j++) {
		
			for (int i=0; i<13; i++) {
				
				Card card = null;
				
				if (i < 10) {
					card = new Card(slist[j], snlist[j], i+1, i + 1 + "");
				} else {
					String temp = "";
					if (i == 10) temp = "J";
					else if (i == 11) temp = "Q";
					else if (i == 12) temp = "K";
					card = new Card(slist[j], snlist[j], i+1, temp);
				}
				
				list[cardIndex] = card;
				cardIndex++;
				
			}
		
		}
		
		return list;
		
	}
	
	
	//카드 순서대로 정렬하기
	public static void sort(Card[] list) {
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=i+1; j<list.length; j++) {
				if (list[i].getRank() > list[j].getRank()) {	//숫자 정렬
					
					Card temp = null;
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
					
				} else if (list[i].getRank() == list[j].getRank()) { //모양 정렬
					
					if (list[i].getSymbolNum() < list[j].getSymbolNum()) {
						Card temp = null;
						temp = list[i];
						list[i] = list[j];
						list[j] = temp;
					}
					
				}
			}
		}
		
	}

	
}














public class Check {
	
	public static CardSet getHandsOrder(Card[] list) {
		
//		잠시 패 확인하기
//		for (int i=0; i<list.length; i++) {
//			System.out.print(list[i] + "\t");
//		}
//		System.out.println();
		
		if (checkStraightFlush(list)) {
			return CardSet.STRAIGHTFLUSH;
		} else if (checkFourofaCard(list)) {
			return CardSet.FOUROFAKIND;
		} else if (checkFullHouse(list)) {
			return CardSet.FULLHOUSE;
		} else if (checkFlush(list)) {
			return CardSet.FLUSH;
		} else if (checkStraight(list)) {
			return CardSet.STRAIGHT;
		} else if (checkThreeofaCard(list)) {
			return CardSet.THREEOFAKIND;
		} else if (checkTwoPair(list)) {
			return CardSet.TWOPAIR;
		} else if (checkOnePair(list)) {
			return CardSet.ONEPAIR;
		} else {
			return CardSet.NOTHING;
		}
		
	}

	//원페어
	private static boolean checkOnePair(Card[] list) {
		
		int count = 0;
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=i+1; j<list.length; j++) {
				if (list[i].getRank() == list[j].getRank()) {
					count++;
					if (count >= 1) return true;
				}
			}
		}
		
		return count == 1;
	}
	
	//투페어
	private static boolean checkTwoPair(Card[] list) {
		
		int count = 0;
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=i+1; j<list.length; j++) {
				if (list[i].getRank() == list[j].getRank()) {
					count++;
					if (count >= 2) return true;
				}
			}
		}
		
		return count == 2;
	}
	
	//쓰리 카드
	private static boolean checkThreeofaCard(Card[] list) {
		
		int count = 0;
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=i+1; j<list.length; j++) {
				if (list[i].getRank() == list[j].getRank()) {
					count++;
					if (count >= 3) return true;
				}
			}
		}
		
		return count == 3;
	}
	
	//스트레이트
	private static boolean checkStraight(Card[] list) {
		
		boolean check = true;
		
		for (int i=0; i<list.length-1; i++) {
			if ((list[i+1].getRank() - list[i].getRank()) != 1) {
				check = false;
				break;
			} 
		}
		
		return check;
	}
		
	//플러시
	private static boolean checkFlush(Card[] list) {
		
		boolean check = true;
		
		for (int i=0; i<list.length-1; i++) {
			if (!list[i+1].getSymbol().equals(list[i].getSymbol())) {
				check = false;
				break;
			} 
		}
		
		return check;
	}
	
	
	//풀하우스
	private static boolean checkFullHouse(Card[] list) {
				
		boolean check = true;
		
		if (!((list[0].getRank() == list[1].getRank() && list[0].getRank() == list[2].getRank()) && (list[3].getRank() == list[4].getRank()))) { 
			check = false;
		}
		
		return check;
	}
	
	
	//포카드
	private static boolean checkFourofaCard(Card[] list) {
				
		int count = 0;
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=i+1; j<list.length; j++) {
				if (list[i].getRank() == list[j].getRank()) {
					if (list[3].getRank() != list[4].getRank()) {
						count++;
						if (count >= 4) return true;
					}
				}
			}
		}
		
		return count == 4;
	}
	
	
	//스트레이트플러시
	private static boolean checkStraightFlush(Card[] list) {
				
		boolean check = true;
		
		for (int i=0; i<list.length-1; i++) {
			if ((list[i+1].getRank() - list[i].getRank()) != 1) {
				check = false;
				break;
			} 
		}
		
		
		if (check) {
			String temp = list[0].getSymbol();
			for (int i=1; i<list.length; i++) {
				if (temp != list[i].getSymbol()) {
					check = false;
					break;
				}
			}
		}
		
		return check;
		
	}

	
	//최종 결과 판단
	public static int result(Card[] player, Card[] computer) {
		
		
		return getHandsOrder(player).compareTo(getHandsOrder(computer));
	}
	
	
	
	

}











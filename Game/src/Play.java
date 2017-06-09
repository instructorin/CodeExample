import java.util.Random;
import java.util.Scanner;

public class Play {
	
	private static Card[] player;
	private static Card[] computer;
	private static Card[] list;
	
	static {
		player = new Card[5];
		computer = new Card[5];
		list = new Card[52];
	}
	

	public static void play() {
		
		list = Card.init();
		
		//카드 갖기
		for (int i=0; i<player.length; i++) {
			player[i] = getCard(list);
		}
		
		for (int i=0; i<computer.length; i++) {
			computer[i] = getCard(list);
		}
		
		//테스트용 카드 셋
//		player[0] = list[0];
//		player[1] = list[1];
//		player[2] = list[2];
//		player[3] = list[3];
//		player[4] = list[4];
		
		//정렬하기
		Card.sort(player);
		Card.sort(computer);
		
		//초반 확인용 출력
//		System.out.println();
//		for (int i=0; i<player.length; i++) {
//			System.out.printf("%s\t", player[i]);
//		}
//		
//		System.out.println();
//		for (int i=0; i<computer.length; i++) {
//			System.out.printf("%s\t", computer[i]);
//		}
//		
//		
//		System.out.println();
//		for (int i=0; i<list.length; i++) {
//			System.out.printf("%s\t", list[i]);
//		}
		
		
		
		
		//패 확인하기(종류)
		CardSet result = Check.getHandsOrder(player);
		
		//if (result == CardSet.STRAIGHTFLUSH) {
		//if (result == CardSet.FOUROFAKIND || result == CardSet.FULLHOUSE) {
		//if (result == CardSet.FOUROFAKIND) {
		//if (result == CardSet.FULLHOUSE) {
		//if (result == CardSet.FLUSH) {
		
		//	System.out.println(result);
		
			//패 확인하기(보기)
			//if (result == CardSet.FULLHOUSE) {
//			for (int i=0; i<player.length; i++) {
//				System.out.print(player[i] + "\t");
//			}
//			System.out.println();
//		}
		
		
		
		//사용자에게 패를 확인 시켜주고 몇장을 바꿀지 확인
		System.out.println();
		for (int i=0; i<player.length; i++) {
			System.out.printf("%s\t", player[i]);
		}
		System.out.println();
		System.out.println();
		for (int i=0; i<player.length; i++) {
			System.out.printf("%d. %s\n", i + 1, player[i]);
		}
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("패를 바꾸시겠습니까?(3 or 3,5 or 없으면 엔터입력) ");
		String input = scan.nextLine();
		
		//카드 바꾸기
		if (!input.isEmpty()) {
			String[] temp = input.split(",");
			for (int i=0; i<temp.length; i++) {
				int index = Integer.parseInt(temp[i].trim()) - 1;
				player[index] = getCard(list);
			}
		}
		Card.sort(player);
		
		System.out.println();
		for (int i=0; i<player.length; i++) {
			System.out.printf("%s\t", player[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.print("결과를 확인합니다. 엔터키를 누르세요.");
		scan.nextLine();
		
		
		System.out.println();
		int end = Check.result(player, computer);
		
		if (end > 0) {
			System.out.println("[컴퓨터 승]");
		} else if (end < 0) {
			System.out.println("[사용자 승]");
		} else {
			System.out.println("[무승부]");
		}
		System.out.println();
		
		System.out.print("사용자 : ");
		for (int i=0; i<player.length; i++) {
			System.out.printf("%s\t", player[i]);
		}
		System.out.printf("\t%s", Check.getHandsOrder(player));
		System.out.println();
		
		System.out.print("컴퓨터 : ");
		for (int i=0; i<computer.length; i++) {
			System.out.printf("%s\t", computer[i]);
		}
		System.out.printf("\t%s", Check.getHandsOrder(computer));
		System.out.println();
		
		scan.close();
		
	}
	
	public static Card getCard(Card[] list) {
		
		Random rnd = new Random();
		
		while (true) {
			
			int index = rnd.nextInt(list.length);
			
			//얻은 카드는 패에서 빼놓기
			if (list[index] != null) {
				Card c = new Card(list[index].getSymbol(), list[index].getSymbolNum(), list[index].getRank(), list[index].getRankChar());
				list[index] = null;
				return c;
			}
			
		}
		
	}

}









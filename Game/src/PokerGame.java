import java.util.Scanner;

public class PokerGame {
	
	public static void main(String[] args) {
		
		boolean ing = true;
		Scanner scan = new Scanner(System.in);
		
		while (ing) {
			
			UI.menu();
			String sel = "";
			System.out.print("선택 : ");
			
			sel = scan.nextLine();
			
			if (sel.equals("1")) {
				
				//for (int i=0; i<100000; i++) { //패 확인용 테스트 루프
					Play.play();
				//}
				
			} else {
				ing = false;
			}
			
			
		}
		
		UI.end();
		
		scan.nextLine();
		scan.close();
		
	}
	
}

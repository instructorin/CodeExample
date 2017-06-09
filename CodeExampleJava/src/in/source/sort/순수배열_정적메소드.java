package in.source.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator.OfInt;
import java.util.Spliterators;

public class 순수배열_정적메소드 {

	public static void main(String[] args) {

		//기본정렬();
		//기본정렬_문자열();
		
		//Array_메소드();
		Arrays_메소드();
		

	}

	private static void Arrays_메소드() {
		
		String[] list = new String[] { "홍길동", "유재석", "박명수", "정형돈", "정준하", "강호동", "이수근" };
		
		//indexOf - 항목 검색
		System.out.println(Arrays.binarySearch(list, "정형돈"));
		
		
		//배열 -> List 생성하기
		List<String> list2 = Arrays.asList(list);
		
		for (String s : list2) {
			System.out.println(s);
		}
		System.out.println();
		
		
		//배열 -> List 생성하기
		List<String> list3 = Arrays.asList("하나", "둘", "셋");
		
		for (String s : list3) {
			System.out.println(s);
		}
		System.out.println();
		
		
		//배열 복사(갯수 지정)
		String[] copy = Arrays.copyOf(list, 3);
		
		for (String s : copy) {
			System.out.println(s);
		}
		System.out.println();
		
				
		
		String[] listA = { "자바", "C#", "파이썬" };
		//String[] listB = { "자바", "C#", "파이썬" };
		String[] listB = new String[3];
		listB[0] = "자바";
		listB[1] = "C#";
		//listB[2] = "파이썬";
		listB[2] = "파이";
		listB[2] += "썬";
		
		String[] listC = listA.clone();
		
		//배열 비교하기(해시 코드에 주의할 것 -> 배열의 성질 파악하기)
		System.out.println(listA == listB);
		System.out.println(listA.equals(listB));
		System.out.println(Arrays.deepEquals(listA, listB));
		System.out.println(Arrays.equals(listA, listB));
		System.out.println(Arrays.hashCode(listA));
		System.out.println(Arrays.hashCode(listB));
		System.out.println(Arrays.deepHashCode(listA));
		System.out.println(Arrays.deepHashCode(listB));
		System.out.println(Arrays.deepHashCode(listC));
		System.out.println();
		
		
		//배열은 요소의 상태가 동일하면 어떤 상황이든 같은 객체를 참조한다.
		//배열의 일부 요소가 달라지는 순간 인스턴스가 바뀐다.
		listC[0] = "Java";
		listC[1] = "씨샵";
		listC[0] = "자바";
		listC[1] = "C#";
		
		System.out.println(listA == listC);
		System.out.println(listA.equals(listC));
		System.out.println(Arrays.deepEquals(listA, listC));
		System.out.println(Arrays.equals(listA, listC));
		System.out.println(Arrays.hashCode(listA));
		System.out.println(Arrays.hashCode(listC));
		System.out.println(Arrays.deepHashCode(listA));
		System.out.println(Arrays.deepHashCode(listB));
		System.out.println(Arrays.deepHashCode(listC));
		System.out.println();
		
		
		//배열 복사(부분 복사, 범위 지정)
		copy = Arrays.copyOfRange(list, 2, 4);
		
		for (String s : copy) {
			System.out.println(s);
		}
		System.out.println();
		
		
		
		int[] nums = { 1, 3, 5, 7, 9, 2, 4, 6, 8 };
		
		//OfInt oint = (OfInt) Arrays.spliterator(nums);
		//System.out.println(oint);
		//System.out.println(Arrays.spliterator(nums));
		OfInt sp = Arrays.spliterator(nums);
		System.out.println(sp);
		
		
		
		
	}

	private static void Array_메소드() {
		
		Object[] list = new Object[] { "빨강", 100, 3.14, true, 'A' };
		
		Object o1 = Array.get(list, 0);
		System.out.println(o1);
		
		//int n1 = Array.getInt(list, 1);
		//System.out.println(n1);
		
		//char c1 = Array.getChar(list, 4);
		//System.out.println(c1);
		
	}

	private static void 기본정렬_문자열() {
		
		String[] list = new String[] { "홍길동", "유재석", "박명수", "정형돈", "정준하", "강호동", "이수근" };
		
		System.out.println(Arrays.toString(list));
		
		Arrays.sort(list);
		
		System.out.println(Arrays.toString(list));
		
	}

	private static void 기본정렬() {
		
		int[] list = new int[] { 1, 4, 5, 2, 7, 8, 3, 9, 6 };
		
		System.out.println(Arrays.toString(list));
		
		Arrays.sort(list);
		
		System.out.println(Arrays.toString(list));
		
	}

}

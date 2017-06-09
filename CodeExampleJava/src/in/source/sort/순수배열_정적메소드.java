package in.source.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator.OfInt;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class 순수배열_정적메소드 {

	public static void main(String[] args) {
		
		//http://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=220300763889&categoryNo=0&parentCategoryNo=71&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search

		//기본정렬();
		//기본정렬_문자열();
		
		//Array_메소드();
		//Arrays_메소드();
		
		//버블정렬();
		//버블정렬_문자열();
		//버블정렬_문자열_영어();
		//버블정렬_객체();
		//버블정렬_객체2();
		
		
		선택정렬();

	}

	private static void 선택정렬() {

		int[] ns = { 5, 3, 4, 1, 2 };
		
		for (int i=0; i<ns.length-1; i++) {
			for (int j=i+1; j<ns.length; j++) {
				
				if (ns[i] > ns[j]) {
					int temp = ns[i];
					ns[i] = ns[j];
					ns[j] = temp;
				}
				
			}
		}
		
		System.out.println(Arrays.toString(ns));
		
	}

	private static void 버블정렬_객체2() {
		
		Student[] list = new Student[] {
				new Student("홍길동", 100, 80, 85),
				new Student("유재석", 88, 90, 75),
				new Student("박명수", 85, 88, 100),
				new Student("정준하", 75, 89, 68),
				new Student("정형돈", 98, 88, 77)
		};		
		System.out.println(Arrays.toString(list));
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=0; j<list.length-1-i; j++) {
				if (list[j].getTotal() > list[j+1].getTotal()) {
					Student temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;					
				}
			}
		}
		
		System.out.println(Arrays.toString(list));
		
	}

	private static void 버블정렬_객체() {
		
		Person[] list = new Person[] {
				new Person("홍길동", 30),
				new Person("유재석", 25),
				new Person("박명수", 35),
				new Person("정준하", 20),
				new Person("정형돈", 40),
		};
		System.out.println(Arrays.toString(list));
		
		//Arrays.sort(list);
		
		for (int i=0; i<list.length-1; i++) {
			for (int j=0; j<list.length-1-i; j++) {
				if (list[j].getAge() > list[j+1].getAge()) {
					Person temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;					
				}
			}
		}
		
		System.out.println(Arrays.toString(list));
		
	}

	private static void 버블정렬_문자열_영어() {
		
		//String[] names = { "abc", "abb", "aba", "bbb", "eee", "ccc", "aaa", "ddd" };
		String[] names = { "abc", "abb", "aba", "bbb", "Eee", "ccc", "aaa", "Ddd" };
		
		for (int i=0; i<names.length-1; i++) {
			for (int j=0; j<names.length-1-i; j++) {
				//if (names[j].compareTo(names[j+1]) > -1) {
				if (names[j].compareToIgnoreCase(names[j+1]) > -1) {
					
					String temp = names[j];
					names[j] = names[j+1];
					names[j+1] = temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(names));
		
	}

	private static void 버블정렬_문자열() {
		
		String[] names = { "홍길동", "김길동", "나길동", "최길동", "다길동", "홍나연", "홍길순", "홍가지" };
		
		for (int i=0; i<names.length-1; i++) {
			for (int j=0; j<names.length-1-i; j++) {
				if (names[j].compareTo(names[j+1]) > -1) {
					
					String temp = names[j];
					names[j] = names[j+1];
					names[j+1] = temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(names));
		
	}

	private static void 버블정렬() {
		
		//배열의 왼쪽부터 시작으로 인접하는 두 항목의 값을 비교해서 원하는 순서(오름차순, 내림차순)로 되어 있지 않으면 서로 위치를 교환하는 방식
		//과정이 끝나면 제일 큰값(작은값)이 가장 오른쪽 끝으로 이동하게 된다.
		//각 비교 + 이동 단계가 1단계씩 진행될 때마다 오른쪽 끝부터 1개씩 정렬이 완료된다.
		
		//버블 정렬(오름차순)
		//Step 0 : 	[ 5, 4, 3, 2, 1 ]
		//Step 1 : 	[ 4, 5, 3, 2, 1 ]
		//					[ 4, 3, 5, 2, 1 ]
		//					[ 4, 3, 2, 5, 1 ]
		//					[ 4, 3, 2, 1, 5 ] x 4회
		//Step 2 :		[ 3, 4, 2, 1, 5 ]
		//					[ 3, 2, 4, 1, 5 ]
		//					[ 3, 2, 1, 4, 5 ] x 3회
		//Step 3 :		[ 2, 3, 1, 4, 5 ]
		//					[ 2, 1, 3, 4, 5 ] x 2회
		//Step 4 : 	[ 1, 2, 3, 4, 5 ] x 1회
		
		int[] ns = { 5, 3, 4, 1, 2 };
		
		for (int i=0; i<ns.length-1; i++) { //Step이 진행할 때마다 방 길이를 1개씩 제거
			//System.out.println("Step : " + (i + 1));
			for (int j=0; j<ns.length-1-i; j++) { //비교하는 방번호로 사용
				//System.out.println("Sub Step : " + (j + 1));
				if (ns[j] > ns[j+1]) {
					int temp = ns[j];
					ns[j] = ns[j+1];
					ns[j+1] = temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(ns));
		
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
		
		//System.out.println(sp.);
		
		
		
		//같은 값 채워넣기
		String[] listD = new String[5];
		Arrays.fill(listD, "임시");
		System.out.println(Arrays.toString(listD));
		System.out.println();
		
		Arrays.fill(listD, 1, 4, "미정");
		System.out.println(Arrays.toString(listD));
		System.out.println();
		
		
		//누적 정렬하기
		Arrays.parallelSort(listD);
		System.out.println(Arrays.toString(listD));
		System.out.println();
		
		
		Arrays.parallelPrefix(listD, new BinaryOperator<String>() {

			@Override
			public String apply(String t, String u) {
				
				return u + t;
			}
		});		
		System.out.println(Arrays.toString(listD));
		System.out.println();
		
		
		
		int[] nums2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(nums2));
		
		Arrays.parallelPrefix(nums2, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				
				return left + right;
			}
		});
		System.out.println(Arrays.toString(nums2));
		System.out.println();
		
		
		
		
		//그냥 정렬하기
		int[] nums3 = { 1, 5, 2, 4, 3, 9, 7, 8, 6, 5, 1, 3 };
		System.out.println(Arrays.toString(nums3));
		
		//Arrays.sort(nums3);
		Arrays.sort(nums3, 3, 6);
		
		System.out.println(Arrays.toString(nums3));
		System.out.println();
		
		
		
		IntStream intStream = Arrays.stream(nums3);
		
		IntStream intStream2 = intStream.distinct();
		
		
		
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


class Person {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.setAge(age);
	}
	
	
	
	@Override
	public String toString() {
		
		return String.format("%s(%d)", this.name, this.getAge());
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
}


class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		
		return this.kor + this.eng + this.math;
	}
	
	@Override
	public String toString() {
	
		return String.format("%s(국:%d, 영:%d, 수:%d, 총점:%d)"
											, this.name
											, this.kor
											, this.eng
											, this.math
											, this.kor + this.eng + this.math);
	}
	
}








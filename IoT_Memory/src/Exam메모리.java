import java.util.ArrayList;
import java.util.Scanner;

public class Exam메모리 {

	
	public static int num=5;
	public  int num2=10;
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello Arduino");

		Exam메모리 ex1 = new Exam메모리();
		ex1.addNumber(5, 3);

		new Exam메모리().addNumber(5, 3); ///// 위의 2줄코드 와 같은 뜻이다.

		// addNumber(5, 3);

		ArrayList<String> list = new ArrayList<String>();
		list.add("나예호");

		ArrayList<int[]> list2 = new ArrayList<int[]>();

		int[] ages = new int[27];
		list2.add(ages);
		list2.add(new int[] { 1, 3, 5 });

		
		printLunch();
		
		
		
		
		
		
		Scanner sc;
		sc = new Scanner(System.in);

		int[] array;
		array = new int[3]; // 배열은 생성 시 크기를 지정

		int[] array2 = new int[] { 1, 2, 3 };

		String name = "나예호";
		String name2 = new String("나예호2");

	}

	public void addNumber(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	public static void printLunch() {
		System.out.println("닭갈비");
	}
}
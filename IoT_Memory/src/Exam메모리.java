import java.util.ArrayList;
import java.util.Scanner;

public class Exam�޸� {

	
	public static int num=5;
	public  int num2=10;
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello Arduino");

		Exam�޸� ex1 = new Exam�޸�();
		ex1.addNumber(5, 3);

		new Exam�޸�().addNumber(5, 3); ///// ���� 2���ڵ� �� ���� ���̴�.

		// addNumber(5, 3);

		ArrayList<String> list = new ArrayList<String>();
		list.add("����ȣ");

		ArrayList<int[]> list2 = new ArrayList<int[]>();

		int[] ages = new int[27];
		list2.add(ages);
		list2.add(new int[] { 1, 3, 5 });

		
		printLunch();
		
		
		
		
		
		
		Scanner sc;
		sc = new Scanner(System.in);

		int[] array;
		array = new int[3]; // �迭�� ���� �� ũ�⸦ ����

		int[] array2 = new int[] { 1, 2, 3 };

		String name = "����ȣ";
		String name2 = new String("����ȣ2");

	}

	public void addNumber(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	public static void printLunch() {
		System.out.println("�߰���");
	}
}
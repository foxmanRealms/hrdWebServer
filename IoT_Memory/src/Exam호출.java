
public class Examȣ�� {

	public static void main(String[] args) {

		Exam�޸�.printLunch();
		new Exam�޸�().addNumber(5, 3);
		
		System.out.println(Exam�޸�.num);
		System.out.println(new Exam�޸�().num2);
		
		
		Exam�޸�.num=1000;
		new Exam�޸�().num2=1000;
		
		// static ������ 
		// stack ������ �ö� �ִ�
		// �׷��� ������, �ٸ� Ŭ�������� ���� �����ϸ� 
		// ��� Ŭ������ �ݿ��� �ȴ�. 
		
		
		System.out.println(Exam�޸�.num);
		System.out.println(new Exam�޸�().num2);
		
	}

}

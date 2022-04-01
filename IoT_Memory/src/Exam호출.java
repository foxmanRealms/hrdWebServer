
public class Exam호출 {

	public static void main(String[] args) {

		Exam메모리.printLunch();
		new Exam메모리().addNumber(5, 3);
		
		System.out.println(Exam메모리.num);
		System.out.println(new Exam메모리().num2);
		
		
		Exam메모리.num=1000;
		new Exam메모리().num2=1000;
		
		// static 변수는 
		// stack 영역에 올라가 있다
		// 그렇기 때문에, 다른 클래스에서 값을 수정하면 
		// 모든 클래스에 반영이 된다. 
		
		
		System.out.println(Exam메모리.num);
		System.out.println(new Exam메모리().num2);
		
	}

}

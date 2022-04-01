package inter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	// 실행하는 메소드를 정의 
	public String execute(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException ;
		
	
	
}

package stuPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class FilterProcess1 extends HttpServlet {

	public void service (HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		// 要使用的变量
		String subject, way;
		String address;
		ArrayList<Student> students = new ArrayList<Student>();
		
		// 获取用户选择的筛选科目和筛选方式
		subject = req.getParameter("filtersubject");
		way = req.getParameter("filterway");
		Student.initialize();
		
		// 根据不同的筛选方式执行不同的数据库操作
		try {
			if (way.equals("1"))
				students = Student.getspecific(90, 100, subject);
			else if (way.equals("2"))
				students = Student.getspecific(80, 90, subject);
			else if (way.equals("3"))
				students = Student.getspecific(70, 80, subject);
			else if (way.equals("4"))
				students = Student.getspecific(60, 70, subject);
			else if (way.equals("5"))
				students = Student.getspecific(0, 60, subject);
		} catch (NotFoundException e) {
			System.out.println(e);
		}
		
		Student.terminate();
		
		// 将ArrayList传给jsp
		req.setAttribute("students", students);
		req.setAttribute("way", way);
		req.setAttribute("subject", subject);
		
		address = "./JSP/FilterResult.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, res);
	
	}
}
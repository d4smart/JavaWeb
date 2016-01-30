package stuPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class InquireProcess1 extends HttpServlet {

	public void service (HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		// 要使用的变量
		String way,value;
		String address;
		ArrayList<Student> students = new ArrayList<Student>();
		
		// 获取jsp中传来的数据（查询方式和对应的值）
		way = req.getParameter("inquireway");
		value = req.getParameter("inquirevalue");
		
		Student.initialize();
		
		// 按不同的查询方式执行对应的数据库操作
		try {
			if (way.equals("1"))
				students = Student.find(value, "findClassID");
			else if (way.equals("2")) {
				Student student = Student.find(value);
				students.add(student);
			}
			else if (way.equals("3"))
				students = Student.find(value, "findName");
			else if (way.equals("4"))
				students = Student.find(value, "all");
			
		} catch (NotFoundException  e) {
			System.out.println(e);
		}
		
		Student.terminate();
		
		// 将ArrayList传给jsp显示
		req.setAttribute("students", students);
		req.setAttribute("way", way);
		req.setAttribute("value", value);
		
		address = "./JSP/InquireResult.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, res);
		
	}
	
}

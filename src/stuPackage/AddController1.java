package stuPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class AddController1 extends HttpServlet {

	public void service (HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		String way;
		String address = null;
		ArrayList<Student> students=new ArrayList <Student>();
		
//		System.out.println(req.getServletPath());
		
		// 获取jsp中选择的录入方式
		way = req.getParameter("selectedway");
		
		// 根据不同的录入方式执行对应的操作
		if (way.equals("1")) { //按班级录入
			String selectedClass = req.getParameter("content");
			
			// 找到指定班级的学生
			try {
				Student.initialize();
				students = Student.find(selectedClass, "findClassID");
				Student.terminate();
			} catch (NotFoundException e) {
				System.out.println(e);
			}
			
			// 设置属性，jsp中可用对应方法获取
			req.setAttribute("way", way);
			req.setAttribute("selectedClass", selectedClass);
			req.setAttribute("students", students);
			
			// 对应跳转地址
			address = "./JSP/Add1.jsp";
//			System.out.println(selectedClass+" "+way);
		}
		else if (way.equals("2")) { //按课程录入
			String selectedCourse = req.getParameter("content");
			
			// 找到所有学生
			try {
				Student.initialize();
				students = Student.find(selectedCourse, "all");
				Student.terminate();
			} catch (NotFoundException e) {
				System.out.println(e);
			}
			
			// 设置属性，jsp中可用对应方法获取
			req.setAttribute("way", way);
			req.setAttribute("selectedCourse", selectedCourse);
			req.setAttribute("students", students);
			
			address = "./JSP/Add2.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, res);
	}

}

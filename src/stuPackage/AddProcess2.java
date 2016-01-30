package stuPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class AddProcess2 extends HttpServlet {

	public void service (HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		int number = 0;
		String subject = (String) req.getSession().getAttribute("course"); //获取选择的课程
		
		try {
			number = Integer.parseInt((String)req.getSession().getAttribute("num")); //获取学生数
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		
		Student.initialize();
		
		// 获取jsp的form表单中的数据并写入数据库
		for (int i = 0; i < number; i++) {
			// 转换成对应名称以匹配form表单中的name
			String id = "id" + i;
			String name1 = "name" + i;
			String classid = "class" + i;
			String course = subject + i;
			
			// 获取form表单中的数据
			String studentID = req.getParameter(id);
			String name = req.getParameter(name1);
			String classID = req.getParameter(classid);
			int courseScore = Integer.parseInt(req.getParameter(course));
			
			Student student = null;
			
			// 创建对应Student实例
			try {
				student = Student.find(studentID);
			} catch (NotFoundException e1) {
				System.out.println(e1);
			}
			student.setName(name);
			student.setClassID(classID);
			student.setScore(subject, courseScore);
			
			// 写入修改后的数据
			try {
				student.update();
			} catch (NotFoundException e) {
				System.out.println(e);
			}
		}
		Student.terminate();
		
		req.setAttribute("selectedway", "2");
		req.setAttribute("content", subject);
		
		String address = "/JSP/Add.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, res);
		
	}

}

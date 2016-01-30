package stuPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class AddProcess1 extends HttpServlet {

	public void service (HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
//		System.out.println("Start!");
		int number = 0;
		String classID = (String)req.getSession().getAttribute("classID"); //获取选择的班级
//		System.out.println("classID: " + classID);
		
		
		
		try {
			String num = (String)req.getSession().getAttribute("num"); //获取学生数
//			System.out.println("Num: " + a);
			number = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		
//		System.out.println("Number is: "+number);
		
		Student.initialize();
		for (int i = 0; i < number; i++) {
			// 转换成对应名称以获取jsp中的数据
			String id = "id" + i;
			String name1 = "name" + i;
			String math = "math" + i;
			String physics = "physics" + i;
			String oop = "oop" + i;
			String sport = "sport" + i;
			
			// 获取对应数据
			String studentID = req.getParameter(id);
			String name = req.getParameter(name1);
			int mathScore = Integer.parseInt(req.getParameter(math));
			int physicsScore = Integer.parseInt(req.getParameter(physics));
			int oopScore = Integer.parseInt(req.getParameter(oop));
			int sportScore = Integer.parseInt(req.getParameter(sport));
			
			// 创建对应实例
			Student student = new Student(studentID, name, classID, mathScore, physicsScore, oopScore, sportScore);
			
			// 写入数据库
			try {
				student.update();
			} catch (NotFoundException e) {
				System.out.println(e);
			}
		}
		
		Student.terminate();
		
		req.setAttribute("selectedway", "1");
		req.setAttribute("content", classID);
		
		String address = "/JSP/Add.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, res);
		
	}

}

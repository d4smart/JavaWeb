package stuPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class CountProcess extends HttpServlet {

	public void service (HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		// 要使用的变量
		ArrayList<Student> students = new ArrayList<Student>();
		DecimalFormat df = new DecimalFormat("0.0"); //数据格式化类
		int a[] = { 90, 80, 70, 60, 0 }; //筛选对应下界
		int b[] = { 100, 90, 80, 70, 60 }; //筛选对应上界
		String sub[] = {"math","physics","oop","sport"}; //筛选对应科目
		
		Student.initialize();
		int total = 0;
		try {
			total = Student.find("all", "all").size(); //数据库中学生总数
		} catch (NotFoundException e) {
			System.out.println(e);
		}
//		System.out.println(total);
		
		// 获取各分数段人数所占百分比并传给jsp（取一位小数，以String方式传输  如：12.5%->"12.5"）
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				
				try {
					students = Student.getspecific(a[i], b[i], sub[j]);
				} catch (NotFoundException e) {
					System.out.println(e);
				}
				
				double pecent = (double)students.size()/total * 100.0;
				String percent = df.format(pecent);
				req.setAttribute(sub[j]+(i+1), percent);
//				System.out.println(percent);
				
			}
		}
		
		Student.terminate();
		
		// 跳转到对应jsp
		String address = "./JSP/CountResult.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(address);
		dispatcher.forward(req, res);
		
	}
}
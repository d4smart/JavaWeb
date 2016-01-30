package stuPackage;
import java.sql.*;
import java.util.*;

public class StudentDA 
{
	// Student实例
	static Student astudent;
	
	// 数据库连接使用的对象
	static String url="jdbc:odbc:StudentDB1"; 
	static Connection aConnection;
	static Statement aStatement;
	
	// 用于暂存数据
	static String stuID;
	static String name;
	static String classID;
	static int mathScore;
	static int physicsScore;
	static int oopScore;
	static int sportScore;
	
	// 连接数据库
	public static Connection initialize()
	{
		try
		{
			// 加载程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			// 创建连接
			aConnection=DriverManager.getConnection(url,"","");
			aStatement=aConnection.createStatement();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return aConnection;
	}
	
	
	// 与数据库断开连接
	public static void terminate()
	{
		try
		{
			aStatement.close();
			aConnection.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	// 通过StudentID（主键）查找学生记录，返回一个Student实例
	public static Student find(String key) throws NotFoundException {
		astudent = null;
		String sql = "SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
				" WHERE studentID='"+key+"'";
		
		try {
			ResultSet rs=aStatement.executeQuery(sql);
			if(rs.next())
			{
				// 获取属性
				stuID=rs.getString("studentID");
				name=rs.getString("name");
				classID=rs.getString("classID");
				mathScore=rs.getInt("mathScore");
				physicsScore=rs.getInt("physicsScore");
				oopScore=rs.getInt("oopScore");
				sportScore=rs.getInt("sportScore");
				
				// 创建实例
				astudent=new Student(stuID,name,classID,mathScore,physicsScore,oopScore,sportScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return astudent;	//返回
	}
	
	// find函数：在找不到相关记录时会返回一个异常
	// type为查找类型，有三种选择"findName"，"findClassID"，"all"分别对应3种查询方式
	// 返回的数据放在一个ArrayList里面
	public static ArrayList find(String key,String type) throws NotFoundException
	{
		astudent=null;
		ArrayList<Student> students=new ArrayList <Student>();
		String sql="";
		
		// 判断查找类型
		if(type.equals("findName"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" WHERE name='"+key+"'"+
					" ORDER BY studentID";
		}
		if(type.equals("findClassID"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" WHERE classID='"+key+"'"+
					" ORDER BY studentID";
		}
		if(type.equals("all"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" ORDER BY studentID";
		}
		
		try
		{
			ResultSet rs=aStatement.executeQuery(sql);
			
			// 获取查找到的学生记录并添加到ArrayList中
			if(rs.next())
			{
				stuID=rs.getString("studentID");
				name=rs.getString("name");
				classID=rs.getString("classID");
				mathScore=rs.getInt("mathScore");
				physicsScore=rs.getInt("physicsScore");
				oopScore=rs.getInt("oopScore");
				sportScore=rs.getInt("sportScore");
				
				astudent=new Student(stuID,name,classID,mathScore,physicsScore,oopScore,sportScore);
				students.add(astudent);
			}
			else
			{
				throw(new NotFoundException("There is no such record!"));
			}
			while(rs.next())
			{
				stuID=rs.getString("studentID");
				name=rs.getString("name");
				classID=rs.getString("classID");
				mathScore=rs.getInt("mathScore");
				physicsScore=rs.getInt("physicsScore");
				oopScore=rs.getInt("oopScore");
				sportScore=rs.getInt("sportScore");
				
				astudent=new Student(stuID,name,classID,mathScore,physicsScore,oopScore,sportScore);
				students.add(astudent);
			}
			
			rs.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		// 返回Arraylist
		return students;
	}
	
	
	// add函数：录入功能，当数据表中存在相关数据则返回一个异常
	public static void add(Student astudent) throws DuplicateException
	{
		Student student;
		
		// 获取学生属性
		stuID=astudent.getStudentID();
		name=astudent.getName();
		classID=astudent.getClassID();
		mathScore=astudent.getMathScore();
		physicsScore=astudent.getPhysicsScore();
		oopScore=astudent.getOopScore();
		sportScore=astudent.getSportScore();
		
		String sql="INSERT INTO UserT (studentID,name,classID,mathScore,physicsScore,oopScore,sportScore) "+
					"VALUES ('"+stuID+"','"+name+"','"+classID+"','"+mathScore+"','"+physicsScore+"','"+oopScore+"','"
					+sportScore+"')";
		
		//System.out.println(sql);
		
		// 若数据库中已有此记录，返回异常；没有就录入数据库
		try
		{
			student=find(stuID);
			throw(new DuplicateException("This record is already exits!"));
		}
		catch(NotFoundException e)
		{
			try
			{
				int result=aStatement.executeUpdate(sql);
			}
			catch(SQLException ee)
			{
				System.out.println(ee);
			}
		}
	}
	
	
	// delete函数：删除功能，当找不到相关数据时会返回一个异常
	public static void delete(Student astudent) throws NotFoundException
	{
		stuID=astudent.getStudentID();
		Student student;
		String sql="DELETE FROM UserT "+"WHERE studentID='"+stuID+"'";
		
		// 查找有无此记录，没有就返回异常。若找到就执行删除操作
		try
		{
			try
			{
				student=find(stuID);
				int result=aStatement.executeUpdate(sql);
			}
			catch(NotFoundException e)
			{
				throw(new NotFoundException("Cannot Found the Record While deleting!"));
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	
	// update函数：更新学生信息，当找不到相关记录时，会返回一个异常
	public static void update(Student astudent) throws NotFoundException
	{
		Student student;
		
		// 获取属性
		stuID=astudent.getStudentID();
		name=astudent.getName();
		classID=astudent.getClassID();
		mathScore=astudent.getMathScore();
		physicsScore=astudent.getPhysicsScore();
		oopScore=astudent.getOopScore();
		sportScore=astudent.getSportScore();
		
		String sql="UPDATE UserT SET studentID='"+stuID+"',name='"+name+"',classID='"+classID+"',mathScore='"+mathScore
					+"',physicsScore='"+physicsScore+"',oopScore='"+oopScore+"',sportScore='"+sportScore
					+"' WHERE studentID='"+stuID+"'";
//		System.out.println(sql);
		
		// 若找到学生记录就更新数据
		try
		{
			try
			{
				student=find(stuID);
				int result=aStatement.executeUpdate(sql);
			}
			catch(NotFoundException e)
			{
				throw (new NotFoundException("Cannot Found the Record while updating!"));
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("\nupdate"+e);
		}
	}

	// 获取指定科目指定分数段的学生数据，以ArrayList返回，并从高到低排列
	// 挑选出 botton <= score < top
	// project可以传入“math”，“physics”，“oop”，“sport”
	public static ArrayList getspecific(int botton,int top,String project) throws NotFoundException
	{
		astudent=null;
		ArrayList<Student> students=new ArrayList <Student>();
		String sql="";
		
		// 判断科目，匹配对应的sql语句
		if(project.equals("math"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" WHERE mathScore>="+botton+" AND mathScore<"+top+
					" ORDER BY mathScore DESC";
		}
		if(project.equals("physics"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" WHERE physicsScore>="+botton+" AND physicsScore<"+top+
					" ORDER BY physicsScore DESC";
		}
		if(project.equals("oop"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" WHERE oopScore>="+botton+" AND oopScore<"+top+
					" ORDER BY oopScore DESC";
		}
		if(project.equals("sport"))
		{
			sql="SELECT studentID,name,classID,mathScore,physicsScore,oopScore,sportScore FROM UserT"+
					" WHERE sportScore>="+botton+" AND sportScore<"+top+
					" ORDER BY sportScore DESC";
		}
		
		// 执行数据库操作并将结果放入ArrayList
		try
		{
			ResultSet rs=aStatement.executeQuery(sql);
			
			if(rs.next())
			{
				stuID=rs.getString("studentID");
				name=rs.getString("name");
				classID=rs.getString("classID");
				mathScore=rs.getInt("mathScore");
				physicsScore=rs.getInt("physicsScore");
				oopScore=rs.getInt("oopScore");
				sportScore=rs.getInt("sportScore");
				
				astudent=new Student(stuID,name,classID,mathScore,physicsScore,oopScore,sportScore);
				students.add(astudent);
			}
			else
			{
				throw(new NotFoundException("There is no such record!"));
			}
			
			while(rs.next())
			{
				stuID=rs.getString("studentID");
				name=rs.getString("name");
				classID=rs.getString("classID");
				mathScore=rs.getInt("mathScore");
				physicsScore=rs.getInt("physicsScore");
				oopScore=rs.getInt("oopScore");
				sportScore=rs.getInt("sportScore");
				
				astudent=new Student(stuID,name,classID,mathScore,physicsScore,oopScore,sportScore);
				students.add(astudent);
			}
			
			rs.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		// 返回ArrayList
		return students;
	}
}
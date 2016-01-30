package stuPackage;
import java.util.*;
public class Student 
{
	// Student的对象属性（信息+分数）
	private String studentID;
	private String name;
	private String classID;
	private int mathScore;
	private int physicsScore;
	private int oopScore;
	private int sportScore;
	
	// 构造方法
	public Student(String studentID,String name,String classID,
			int mathScore, int physicsScore, int oopScore, int sportScore)
	{
		setStudentID(studentID);
		setName(name);
		setClassID(classID);
		setMathScore(mathScore);
		setPhysicsScore(physicsScore);
		setOopScore(oopScore);
		setSportScore(sportScore);
	}

	// getters,setters方法
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getPhysicsScore() {
		return physicsScore;
	}
	public void setPhysicsScore(int physicsScore) {
		this.physicsScore = physicsScore;
	}
	public int getOopScore() {
		return oopScore;
	}
	public void setOopScore(int oopScore) {
		this.oopScore = oopScore;
	}
	public int getSportScore() {
		return sportScore;
	}
	public void setSportScore(int sportScore) {
		this.sportScore = sportScore;
	}
	// 为获取和设置特定分数数据而设计的方法
	public int getScore(String subject) {
		if (subject.equals("Math"))
			return mathScore;
		else if (subject.equals("Physics"))
			return physicsScore;
		else if (subject.equals("Oop"))
			return oopScore;
		else if (subject.equals("Sport"))
			return sportScore;
		return 0;
	}
	public void setScore(String subject, int score) {
		if (subject.equals("Math"))
			setMathScore(score);
		else if (subject.equals("Physics"))
			setPhysicsScore(score);
		else if (subject.equals("Oop"))
			setOopScore(score);
		else if (subject.equals("Sport"))
			setSportScore(score);
	}
	
	// 获取学生信息
	public String getDetial() {
		String info = getStudentID()+" "+getName()+"\t"+getClassID()+" "+
				getMathScore()+" "+getPhysicsScore()+" "+getOopScore()+
				" "+getSportScore();
		return info;
	}

	// 数据库静态方法
	public static void initialize()
	{
		StudentDA.initialize();
	}
	public static void terminate()
	{
		StudentDA.terminate();
	}
	public static Student find(String key) throws NotFoundException {
		return StudentDA.find(key);
	}
	public static ArrayList find(String key,String type) throws NotFoundException
	{
		return StudentDA.find(key,type);
	}
	
	// 数据库实例方法
	public void add() throws DuplicateException
	{
		StudentDA.add(this);
	}
	public void delete() throws NotFoundException
	{
		StudentDA.delete(this);
	}
	public void update() throws NotFoundException
	{
		StudentDA.update(this);
	}
	public static ArrayList getspecific(int botton,int top,String project) throws NotFoundException
	{
		return StudentDA.getspecific(botton,top,project);
	}
	
}

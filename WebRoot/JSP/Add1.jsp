<%-- 按班级录入页面 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="stuPackage.*" %>

<html>
  <head>
    <title>AddByClass</title>
    <style type="text/css">
	.total{position:absolute;
	left:400px;
	width:569px;
	height:600px;
	background-color:teal;}
	img{
	position:relative;
	}
	.submit{
	margin-top:10px;}
	</style>
  </head>
 
  
  <body bgcolor=silver>
  <div class="total">
		<img src="/JavaWeb/IMG/title2.png" style="height: 201px; width: 569px; ">
    <% 
    String way = (String)request.getAttribute("way"); 
    String selectedClass = (String)request.getAttribute("selectedClass");
    ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
    session.setAttribute("num", String.valueOf(students.size()));
    session.setAttribute("classID", selectedClass);
    %>
    <p align="center">您选中的班级是： <%=selectedClass %></p>
    <p align="center">数据库中一共有<%=students.size() %> 个记录</p>
    <form align="center" valign="center" action="../JavaWeb/AddProcess1" method="post" style="height: 158px; ">
    <table align="center">
    <tr align="center">
    <th>学号</th>
    <th>姓名</th>
    <th>Math</th>
    <th>Physics</th>
    <th>Oop</th>
    <th>Sport</th>
    </tr>
    <% 
    for (int i = 0; i < students.size(); i++) {
    	Student student = students.get(i);
    %>
    <tr>
    <td><input type="text" size=10 value="<%= student.getStudentID()%>" name="id<%=i %>" 
    																readOnly="true"></td>
    <td><input type="text" size=10 value="<%= student.getName()%>"	name="name<%=i %>"></td>
    <td><input type="text" size=3  value="<%= student.getMathScore()%>"	name="math<%=i %>"></td>
    <td><input type="text" size=3  value="<%= student.getPhysicsScore()%>" name="physics<%=i %>"></td>
    <td><input type="text" size=3  value="<%= student.getOopScore()%>"	name="oop<%=i %>"></td>
    <td><input type="text" size=3  value="<%= student.getSportScore()%>" name="sport<%=i %>"></td>
    </tr>
    <%} %>
    </table>
    <input class="submit"type="submit" value="提交" name="submit" style="height: 33px; ">
    </form>
    </div>
  </body>
</html>

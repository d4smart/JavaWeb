<%-- 按课程录入页面 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="stuPackage.*" %>

<html>
  <head>
    <title>按课程录入</title>
 <style type="text/css">
	.total{position:absolute;
	left:400px;
	width:569px;
	min-height:700px;
	
	background-color:teal;}
	.pic{
	position:relative;
	}
	.submit{
	margin-top:10px;}
	.form{position:relative;}
	</style>
  </head>
  
  <body bgcolor=silver>
  <div class="total">
		<img src="/JavaWeb/IMG/title3.png" alt="pic" class="pic" style="height: 201px; width: 569px; ">
    <% 
    String way = (String)request.getAttribute("way"); 
    String selectedCourse = (String)request.getAttribute("selectedCourse");
    ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
    session.setAttribute("num", String.valueOf(students.size()));
    session.setAttribute("course", selectedCourse);
    %>
    <p align="center">您选择的课程是: <%=selectedCourse %></p>
    <p align="center">数据库中共有 <%=students.size() %> 个记录</p>
    <div class="form">
    <form action="../JavaWeb/AddProcess2" method="post" align="center" style="height: 162px; ">
    <table align="center">
    <tr align="center">
    <th>学号</th>
    <th>姓名</th>
    <th>班级</th>
    <th><%= selectedCourse %></th>
    </tr>
    <% 
    for (int i = 0; i < students.size(); i++) {
    	Student student = students.get(i);
    %>
    <tr align="center">
    <td><input type="text" size=10 value="<%= student.getStudentID()%>" name="id<%=i %>" 
    																readOnly="true"></td>
    <td><input type="text" size=10 value="<%= student.getName()%>" name="name<%=i %>"></td>
    <td><input type="text" size=3 value="<%= student.getClassID()%>" name="class<%=i %>"></td>
    <td><input type="text" size=3  value="<%= student.getScore(selectedCourse)%>" name="<%= selectedCourse%><%=i %>"></td>
    </tr>
    <%} %>
    </table>
    <input class="submit" type="submit" value="提交" name="submit">
    </form>
    </div>
    </div>
  </body>
</html>

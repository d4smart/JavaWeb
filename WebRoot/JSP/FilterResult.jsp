<%-- 筛选结果显示页面 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="stuPackage.*" %>
<%
	ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
	String way = (String)request.getAttribute("way");
	String subject = (String)request.getAttribute("subject");
%>

<html>
<head>
	<title>Filter result</title>
	<style type="text/css">
	.total{position:absolute;
	left:400px;
	width:569px;
	min-height:300px;
	
	background-color:teal;}
	.pic{
	position:relative;
	}
	
	</style>
</head>
<body bgcolor=silver>
<div class="total" align="center">
		<img src="/JavaWeb/IMG/title2.png" alt="pic" class="pic" style="height: 201px; width: 569px; ">
	<% if (way.equals("1")) {%>
	<h2>There are <%=students.size() %> records who's <%=subject %> score ≥90 </h2>
	<% } else if (way.equals("2")) { %>
	<h2>There are <%=students.size() %> records who's <%=subject %> score between 80~90 </h2>
	<% } else if (way.equals("3")) { %>
	<h2>There are <%=students.size() %> records who's <%=subject %> score between 70~80 </h2>
	<% } else if (way.equals("4")) { %>
	<h2>There are <%=students.size() %> records who's <%=subject %> score between 60~70 </h2>
	<% } else if (way.equals("5")) { %>
	<h2>There are <%=students.size() %> records who's <%=subject %> score ≤60 </h2>
	<% } %>

	<table align="center" border="2">
	    <tr>
	    <th>StudentID</th>
	    <th>Name</th>
	    <th>Class</th>
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
	    <td><%= student.getStudentID()%></td>
	    <td><%= student.getName()%></td>
	    <td><%= student.getClassID()%></td>
	    <td><%= student.getMathScore()%></td>
	    <td><%= student.getPhysicsScore()%></td>
	    <td><%= student.getOopScore()%></td>
	    <td><%= student.getSportScore()%></td>
	    </tr>
	    <%} %>
	 </table>
</body>
</html>

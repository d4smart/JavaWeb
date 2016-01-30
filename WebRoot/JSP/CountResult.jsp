<%-- 统计结果显示页面 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% String[] header = {"≥90","80~90","70~80","60~70","≤60"}; %>

<html>
<head>
	<title>Count result</title>
	<style type="text/css">
	.total{position:absolute;
	left:400px;
	width:569px;
	min-height:500px;
	
	background-color:teal;}
	.pic{
	position:relative;
	}
	</style>
</head>
<body bgcolor=silver>
<div class="total" align="center">
		<img src="/JavaWeb/IMG/title3.png" alt="pic" class="pic" style="height: 201px; width: 569px; ">
		
	<h2>Database statistics (analysis by percent)</h2>
	
	<table border="2">
	<tr>
	<th>Score </th>
	<th>Math</th>
	<th>Physics</th>
	<th>Oop</th>
	<th>Sport</th>
	</tr>
	
	<%
	for (int i = 0; i < 5; i++) {
	%>
	<tr>
	<td><%=header[i] %></td>
	<td><%=request.getAttribute("math"+(i+1)) %>%</td>
	<td><%=request.getAttribute("physics"+(i+1)) %>%</td>
	<td><%=request.getAttribute("oop"+(i+1)) %>%</td>
	<td><%=request.getAttribute("sport"+(i+1)) %>%</td>
	</tr>
	<% } %>
	
	</table>
</body>
</html>

<%-- 查询成绩页面，选择查询方式和对应的值 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Inquire page</title>
	<style type="text/css">
	.total{position:absolute;
	left:400px;
	width:569px;
	min-height:350px;
	
	background-color:teal;}
	.pic{
	position:relative;
	}
	
	</style>
</head>
<body bgcolor=silver>
<div class="total" align="center">
		<img src="/JavaWeb/IMG/title3.png" alt="pic" class="pic" style="height: 201px; width: 569px; ">
	<form action="../InquireProcess1" method="post">
	<table>
	<tr>
	<td>查询方式： </td>
	<td>
		<select name="inquireway">
		<option value="1" selected>班级</option>
		<option value="2">学号</option>
		<option value="3">姓名</option>
		<option value="4">全部</option>
		</select>
	</td>
	</tr>
	<tr>
	<td>Selected value: </td>
	<td><input type="text" name="inquirevalue" size=10></td>
	</tr>
	</table>
	<p><input type="submit" value="提交" name="submit"></p>
	</form>
</body>
</html>
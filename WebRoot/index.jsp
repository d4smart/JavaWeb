<%-- 学生信息管理系统首页 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<title>学生信息管理系统</title>
	<style type="text/css">
	.total{
	position:absolute;
	left:100px;
	top:80px;
	}
	.table{
	position:relative;
	left:280px;
	top:390px;
	z-index:2;
	}
	.system{
	position:relative;
	z-index:1;
	}
	input{
	width:120px;
	height:30px;
	font-size:20px;
	background-color:aqua;
	}
	</style>
</head>
<body bgcolor=silver>
<div class="total">
   	
   	<div class="table">
   	<table width=700 height=50 >
	<tr>
	<td><input type="submit" value="录入或修改" onclick="location.href='./JSP/Add.jsp'"></td>
	<td><input type="button" value="查询成绩" onclick="location.href='./JSP/Inquire.jsp'"></td>
	<td><input type="button" value="成绩筛选" onclick="location.href='./JSP/Filter.jsp'"></td>
	<td><input type="button" value="成绩统计" onclick="location.href='./CountProcess'"></td>
	</table>
	</div>
	<div class="system">
   	<img  alt="pic" src="IMG/title.png">
   	</div>
</div>
</body>
</html>
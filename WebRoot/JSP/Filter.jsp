<%-- 成绩筛选首页面 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Filter page</title>
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
<div class="total">
		<img src="/JavaWeb/IMG/title3.png" alt="pic" class="pic" style="height: 201px; width: 569px; ">
	<form action="../FilterProcess1" method="post" align="center">
	<table align="center">
	<tr>
	<td>筛选科目： </td>
	<td>
		<select name="filtersubject">
		<option value="math" selected>math</option>
		<option value="physics">physics</option>
		<option value="oop">oop</option>
		<option value="sport">sport</option>
		</select>
	</td>
	</tr>
	<tr>
	<td>筛选条件： </td>
	<td>
		<select name="filterway">
		<option value="1" selected>≥90</option>
		<option value="2">80~90</option>
		<option value="3">70~80</option>
		<option value="4">60~70</option>
		<option value="5">≤60</option>
		</select>
	</td>
	</tr>
	</table>
	<p><input type="submit" value="提交" name="submit"></p>
	</form>
</body>
</html>
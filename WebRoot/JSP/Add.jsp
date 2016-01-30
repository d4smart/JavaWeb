<%-- 录入或修改首页，选择方式和对应内容 --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<title>录入</title>
	<style type="text/css">
	.total{position:absolute;
	left:400px;
	width:569px;
	height:500px;
	background-color:teal;}
	img{
	position:relative;
	}
	</style>
</head>
<body bgcolor=silver>
	<div class="total">
		<img src="/JavaWeb/IMG/title2.png" style="height: 201px; width: 569px; ">
		<form action="../AddController1" method="post">
		<table align="center" border="2" bordercolor="#0000FF" style="height: 252px; ">
		<tr>
		<td style="font-size:23px" >请选择筛选(录入或修改方式) </td>
		<td align="center">
			<select name="selectedway" style="height: 41px; width: 88px"style="font-size:23px">
			<option value="1" selected >班级</option>
			<option value="2">课程</option>
			</select>
		</td>
		</tr>
		<tr>
		<td align="center" style="font-size:23px">请输入课程或班级 </td>
		<td ><input type="text" name="content" style="width: 136px; "></td>
		</tr>
		<tr>
		<td align="center"><input type="reset"  value="重置" name="reset" style="height: 45px; width: 73px; "style="font-size:20px"></td>
		<td align="center"><input type="submit" value="提交" name="submit"  style="height: 45px; width: 67px; "style="font-size:20px"></td>
		</tr>
		</table>
		</form>
	</div>
</body>
</html>
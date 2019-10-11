<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl标签库 -->
<%
	pageContext.setAttribute("currentPath", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<link
	href="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/css/layui.css"
	rel="stylesheet">
<title>车牌识别</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
</head>
<body>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD background=images/title_bg1.jpg>当前位置:---》》所在地统计</TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>
	<form action="${currentPath}/finds">
		<input type="text"  name="car_location" placeholder="输入省份" style="height:28px">
		<button type="submit" class="layui-btn layui-btn-xs" style="height:28px">查询</button>
	</form>
	<form action="${currentPath}/findByColor" method="post">
		<input type="text" name="car_cor" placeholder="输入车牌颜色" style="height:28px">
		<button type="submit" class="layui-btn layui-btn-xs" style="height:28px">查询</button>
	</form>
<div class="layui-table-box" >
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1 class="layui-table">
			<tr>
				<th align="center" data-field="id" style="background-color:	#A9A9A9">车牌号码</th>
				<th align="center" data-field="id" style="background-color:	#A9A9A9">车牌颜色</th>
				<th align="center" data-field="id" style="background-color:	#A9A9A9">车牌所属地</th>
				<th align="center" data-field="id" style="background-color:	#A9A9A9">识别耗时</th>
				<th align="center" data-field="id" style="background-color:	#A9A9A9">编辑</th>
			</tr>
			<c:forEach items="${pageInfo.list }" var="cars">
				<tr>
					<td align="center" data-field="id">${cars.allCarNum}</td>
					<td align="center" data-field="id">${cars.allCarCor}</td>
					<td align="center" data-field="id">${cars.carLocation}</td>
					<td align="center" data-field="id">${cars.carTime}</td>
					<td align="center" data-field="id"><a href="${currentPath}/deleteCar?id=${cars.carId}"
						onclick="return del();"><button type="button" class="layui-btn layui-btn-danger layui-btn-xs">删除</button></a></td>
				</tr>
			</c:forEach>
	</table>


	共${pageInfo.total }条记录， 当前显示第${pageInfo.pageNum }页 总${pageInfo.pages }页
	<a href="${pageContext.request.contextPath}/index1?currentPage=1">首页</a>
	<c:if test="${pageIfno.hasPreviousPage }">
		<a
			href="${pageContext.request.contextPath}/index1?currentPage=${pageInfo.pageNum-1}">
		</a>
	</c:if>
	<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
		<c:if test="${page_Num == pageInfo.pageNum }">
			<a href="#">${page_Num }</a>
		</c:if>
		<c:if test="${page_Num != pageInfo.pageNum }">
			<a href="${pageContext.request.contextPath}/index1?currentPage=${page_Num }">${page_Num }</a>
		</c:if>
	</c:forEach>
	<c:if test="${pageInfo.hasNextPage }">
		<a href="${pageContext.request.contextPath}/index1?currentPage=${pageInfo.pageNum+1 }">>></a>
	</c:if>
	<a href="${pageContext.request.contextPath}/index1?currentPage=${pageInfo.pages}">末页</a>
	</div>
<script type="text/javascript" src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
 </BODY>
 </HTML>
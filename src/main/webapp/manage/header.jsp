<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<link
	href="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/css/layui.css"
	rel="stylesheet">
</HEAD>
<BODY>
	<TABLE cellSpacing=0 cellPadding=0 width="100%"
		background="images/header_bg.jpg" border=0>
		
		<TR height=56>
				<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo" style="font-size:20px">管理后台</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">当前用户：${manage.username }</a></li>
				<li class="layui-nav-item"><a href="password.do" target=main>修改密码</a></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="loginout.do" onclick="if (confirm('确定要退出吗？')) return true; else return false;" target=_top>退了</a></li>
			</ul>
		</div>
	</div>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
		<TR bgColor=#1c5db6 height=4>
			<TD></TD>
		</TR>
	</TABLE>
	<script type="text/javascript" src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
</BODY>
</HTML>



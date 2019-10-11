<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background=images/title_bg1.jpg>当前位置:</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background=images/shadow_bg.jpg></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
		<TR height=100>
			<TD align=middle width=100><IMG
				height=100 src="images/admin_p.gif" width=90></TD>
			<TD width=60>&nbsp;</TD>
			<TD>
				<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>


					<TR>
						<TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">用户名：${manage.username }</TD>
					</TR>
					<TR>
						<TD>欢迎来到后台</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD colSpan=3 height=10></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
		<TR height=20>
			<TD></TD>
		</TR>
		<TR height=22>
			<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
				align=middle background=images/title_bg2.jpg>您的相关信息</TD>
		</TR>
		<TR bgColor=#ecf4fc height=12>
			<TD></TD>
		</TR>
		<TR height=20>
			<TD></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
		<div class="layui-col-md4 layui-col-sm6">
			<div class="layadmin-contact-box">
				<div class="layui-col-md4 layui-col-sm6">
					<a href="javascript:;">
						<div class="layadmin-text-center">
							<script type="text/html" template="">
                <img src="{{ layui.setter.base }}style/res/template/character.jpg">
              </script>
							<img src="images/timg.jpg" style="border-radius: 50%">
						</div>
					</a>
				</div>

				<div class="layui-col-md8 layadmin-padding-left20 layui-col-sm6"
					style="">
					<a href="javascript:;">
						<h3 class="layadmin-title"></h3>
					</a>
					<div class="layadmin-address">

						<br><br> 登录账号：${manage.username }<br> <br> 真实姓名：${manage.name }
						<br><br>
						<addr title="phone">添加时间：</addr>
						${manage.createtime } <br><br> 用户角色：
						<c:if test="${manage.role==1}">系统管理员</c:if>
						<c:if test="${manage.role==2}">工作人员</c:if>
						<c:if test="${manage.role==3}">技术人员</c:if>

					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript"
			src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
	</TABLE>
</BODY>
</HTML>

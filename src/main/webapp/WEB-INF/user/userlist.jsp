<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<link
	href="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/css/layui.css"
	rel="stylesheet">
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD background=images/title_bg1.jpg>当前位置:---》》${title }</TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>

<form action="${url }" method="post">

<input class="layui-btn layui-btn-xs"  onclick="javascript:window.location.href='${url2}add.do';"  type="button" value="添加人员" style="height: 28px;width: 100px;" />


<input name="username" type="text"  value="${username }" placeholder="请输入用户名：" style="height:28px">
<input type="submit"  value="查询" class="layui-btn layui-btn-xs" style="height:28px"/>


</form>
<div class="layui-table-box" >
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1 class="layui-table">
  	
  	<TR >
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">用户名</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">密码</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">姓名</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">手机号码</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">添加时间</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">用户角色</TD>
    <TD align="center"data-field="id" style="background-color:	#A9A9A9"> 
  	操作
    </TD>
    </TR>
    <c:forEach items="${list}"  var="bean">

    <TR >
    <TD align="center" data-field="id">${bean.username }</TD>
    <TD align="center" data-field="id">${bean.password }</TD>
    <TD align="center" data-field="id">${bean.name }</TD>
    <TD align="center" data-field="id">${bean.tej }</TD>
    <TD align="center" data-field="id">${bean.createtime }</TD>
    <TD align="center" data-field="id">
    <c:if test="${bean.role==2 }">工作人员</c:if>
    <c:if test="${bean.role==3 }">技术人员</c:if>
    </TD>
    <TD align="center"data-field="id"> 
  	
	  <a href="${url2 }update3.do?id=${bean.id }" class="layui-btn">查看</a>
      &nbsp;
      <a href="${url2 }update.do?id=${bean.id }" class="layui-btn layui-btn-normal">更新</a>
      &nbsp;
      <a href="${url2 }delete.do?id=${bean.id }" onclick="return confirm('确定要删除吗?');" class="layui-btn layui-btn-danger">删除</a>
      &nbsp;
 
    </TD>
    </TR>
    </c:forEach>
    
    <TR >
    <TD align="center" colspan="21" >${pagerinfo }</TD>

  	
    </TR>
    
    
    </TABLE>
    </div>
<script type="text/javascript" src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
 </BODY></HTML>

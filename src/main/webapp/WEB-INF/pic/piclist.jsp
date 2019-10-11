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



<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1>
  	
  	<TR >
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">图片</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">图片说明</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">图片链接</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9"> 
  	操作
    </TD>
    </TR>
    <c:forEach items="${list}"  var="bean">

    <TR >
    <TD align="center" data-field="id"> <img  src="<%=basePath %>${bean.path }" width="200" height="200" /></TD>
    <TD align="center" data-field="id">${bean.info }</TD>
    <TD align="center" data-field="id">${bean.href }</TD>
    <TD align="center" data-field="id">   	
     <a href="${url2 }update.do?id=${bean.id }" class="layui-btn layui-btn-normal">更新</a>
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
 </BODY>
 </HTML>

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

<input class="layui-btn layui-btn-xs"   onclick="javascript:window.location.href='${url2}add.do';"  type="button" value="添加车位" style="height: 28px;width: 100px;" />


<input name="chepai" type="text"  value="${chepai }" placeholder="请输入车位号：" style="height:28px">
<input type="submit"  value="查询" class="layui-btn layui-btn-xs" style="height:28px"/>


</form>
<div class="layui-table-box" >
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1 class="layui-table">
  	
  	<TR >
    <TD align="center" data-field="id" style="background-color:	#A9A9A9" >车位号</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车架号</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">适用</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位类型</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">租金(元/天)</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位状态</TD>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9"> 
  	操作
    </TD>
    </TR>
    <c:forEach items="${list}"  var="bean">

    <TR >
    <TD align="center" data-field="id">${bean.chepai }</TD>
    <TD align="center" data-field="id">${bean.chejia }</TD>
    <TD align="center" data-field="id">${bean.pinpai }</TD>
    <TD align="center" data-field="id">${bean.xinghao }</TD>
    <TD align="center" data-field="id">${bean.zujin }</TD>
    <TD align="center" data-field="id">${bean.status }</TD>
    <TD align="center" data-field="id">   	
	  <a href="${url2 }update3.do?id=${bean.id }" class="layui-btn">查看</a>
      &nbsp;
      <c:if test="${bean.status=='车位空闲'}">
      <a href="${url2 }update.do?id=${bean.id }" class="layui-btn layui-btn-normal">更新</a>
      &nbsp;
      <a href="${url2 }delete.do?id=${bean.id }" onclick="return confirm('确定要删除吗?'); " class="layui-btn layui-btn-danger">删除</a>
      &nbsp;
 	  </c:if>
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

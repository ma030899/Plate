<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
     <form action="${url }" method="post" onsubmit="return checkform()" enctype="multipart/form-data">
<div class="layui-table-box" >
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1 class="layui-table">
  	
  	<TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位号:</TD>
    <TD align="center" data-field="id"> 
 	${bean.chepai }
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车架号:</TD>
    <TD align="center" data-field="id"> 
    ${bean.chejia }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">适用:</TD>
    <TD align="center" data-field="id"> 
    ${bean.pinpai }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位型号:</TD>
    <TD align="center" data-field="id">
    ${bean.xinghao }
 
    </TD>
    </TR>
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位图片:</TD>
    <TD align="center" data-field="id"> 
   <img  src="<%=basePath %>${bean.pic }" width="200" height="200" />
    </TD>
    </TR>
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位价值(元):</TD>
    <TD align="center" data-field="id"> 
    ${bean.price }
 
    </TD>
    </TR>
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">行驶证号:</TD>
    <TD align="center" data-field="id">
    ${bean.xsz }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">付费类型:</TD>
    <TD align="center" data-field="id"> 
    ${bean.yanse }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">租金(元/天):</TD>
    <TD align="center" data-field="id"> 
    ${bean.zujin }
 
    </TD>
    </TR>
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">添加时间:</TD>
    <TD align="center" data-field="id"> 
    ${bean.ctime }
 
    </TD>
    </TR>
    
    
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9"> 操作：</TD>
    <TD align="center" data-field="id">
				<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" class="layui-btn layui-btn-sm layui-btn-normal" />
    
    </TD>
    </TR>
    
    </TABLE>
    </form>
 </BODY></HTML>

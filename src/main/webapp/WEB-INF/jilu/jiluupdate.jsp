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
     <form action="${url }" method="post" onsubmit="return checkform()">
<div class="layui-table-box" >
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1 class="layui-table">
  	
  	<TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位号:</TD>
    <TD align="center" data-field="id"> 
    ${bean.chepai }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">用戶姓名:</TD>
    <TD align="center" data-field="id">
    ${bean.xingming }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">身份证号码:</TD>
    <TD align="center" data-field="id"> 
 
 	${bean.sfz }
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">联系电话:</TD>
    <TD align="center" data-field="id"> 
 	${bean.dianhua }
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">身份证复印件:</TD>
    <TD align="center" data-field="id">
 	<img  src="<%=basePath %>${bean.sfz2 }" width="200" height="200" />
    </TD>
    </TR>
    
     <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">驾驶证复印件:</TD>
    <TD align="center" data-field="id"> 
 	<img  src="<%=basePath %>${bean.jsz }" width="200" height="200" />
    </TD>
    </TR>
    
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">备注:</TD>
    <TD align="center" data-field="id">
 
    	<input  style="border: 0; background: transparent;text-align: center;" type="text" name="beizhu" value="${bean.beizhu }"  readonly="readonly"  size="50"  />
 
    </TD>
    </TR>
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">出库时间:</TD>
    <TD align="center" data-field="id"> 

    	<input  style="border: 0; background: transparent;text-align: center;" type="text" name="shijian1" value="${bean.shijian1 }"  readonly="readonly"  size="50"  />
    </TD>
    </TR>   
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">入库时间:</TD>
    <TD align="center" data-field="id">
  
 	<input  style="border: 0; background: transparent;text-align: center;" type="text" name="shijian2"  display="block" value="${shijian2 }"  readonly="readonly"  size="50"  />
    </TD>
    </TR> 
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位价值:</TD>
    <TD align="center" data-field="id"> 
 	 <input  style="border: 0; background: transparent;text-align: center;" type="text" name="zujin" value="${bean.car.zujin }"  readonly="readonly"  size="50"  />
    </TD>
    </TR>   
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">已占天数（天）:</TD>
    <TD align="center" data-field="id"> <div  text-align="center">
 	 <input style="border: 0; background: transparent; text-align: center;"  type="text" name="tianshu" value="${tianshu }"  readonly="readonly"  size="50"  />
    </div></TD>
    </TR>    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">总价格:</TD>
    <TD align="center" data-field="id"> 
 	 <input style="border: 0; background: transparent;text-align: center;"  type="text"  name="tzujinbefore" value="${tzujinbefore}" readonly="readonly"  size="50"  />
    </TD>
    </TR>
        <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">会员折后总价格（元）:</TD>
    <TD align="center" data-field="id"> 
 	 <input style="border: 0; background: transparent;text-align: center;"  type="text" name="tzujin" value="${tzujin}"  readonly="readonly"  size="50"  />
    </TD>
    </TR>
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">操作:</TD>
    <TD align="center" data-field="id"> 
     <input type="submit" value="提交" style="width: 60px" class="layui-btn layui-btn-sm" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" class="layui-btn layui-btn-sm layui-btn-normal" />
    
    </TD>
    </TR>
    
       </TABLE>
     </div>
       </form>

<script type="text/javascript" src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
 </BODY>
 </HTML>

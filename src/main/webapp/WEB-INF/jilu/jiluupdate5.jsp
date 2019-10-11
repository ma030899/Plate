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
<script language="javascript" type="text/javascript">

function checkform()
{	
	if (document.getElementById('weixiuid').value=="")
	{
		alert("维护费不能为空");
		return false;
	}
	
	//验证正整数
	var reg1 =  /^\d+$/; 
	if (document.getElementById('weixiuid').value.match(reg1) == null)
	{
		alert("维护费必须为正整数");
		return false;	
	}
	return true;
}
</script>

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
   ${bean.beizhu }
 
    </TD>
    </TR>
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">出库时间:</TD>
    <TD align="center" data-field="id"> 
   ${bean.shijian1 }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">入库时间:</TD>
    <TD align="center" data-field="id"> 
    ${bean.shijian2 }
 	
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位价值:</TD>
    <TD align="center" data-field="id">  
 	${bean.car.zujin }
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">已占天数（天）:</TD>
    <TD align="center" data-field="id"> 
    ${bean.tianshu }
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">总价格:</TD>
    <TD align="center" data-field="id">
 	${bean.tzujin }
    </TD>
    </TR>
    
    
<%--     
    <TR height=>
    <TD align="center" >工作人员:</TD>
    <TD align="center"> 
 	${bean.work.name }
    </TD>
    </TR> --%>
    
    
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">维护费(元):</TD>
    <TD align="center" data-field="id">  
 	 <input  type="text" name="weixiu" id="weixiuid" value="0"  size="50"  />(如无损伤则为0)
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

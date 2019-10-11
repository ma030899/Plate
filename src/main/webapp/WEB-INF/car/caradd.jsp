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
	 
	

	if (document.getElementById('chepaiid').value=="")
	{
		alert("车位号不能为空");
		return false;
	}
	if (document.getElementById('chejiaid').value=="")
	{
		alert("车架号不能为空");
		return false;
	}
	if (document.getElementById('pinpaiid').value=="")
	{
		alert("适用不能为空");
		return false;
	}
	if (document.getElementById('xinghaoid').value=="")
	{
		alert("型号不能为空");
		return false;
	}
	if (document.getElementById('uploadfileid').value=="")
	{
		alert("车位图片不能为空");
		return false;
	}
	if (document.getElementById('priceid').value=="")
	{
		alert("车位价值不能为空");
		return false;
	}
	if (document.getElementById('xszid').value=="")
	{
		alert("行驶证号不能为空");
		return false;
	}
	if (document.getElementById('yanseid').value=="")
	{
		alert("付费类型不能为空");
		return false;
	}
	if (document.getElementById('zujinid').value=="")
	{
		alert("租金不能为空");
		return false;
	}
	
	
	//验证正整数
	var reg1 =  /^\d+$/;
	 
	if (document.getElementById('zujinid').value.match(reg1) == null)
	{
		alert("租金必须为正整数");
		return false;
		
	}
	
	return true;
	
}


</script>

</HEAD>
<BODY>
  <TR height=28>
    <TD background=images/title_bg1.jpg>当前位置:---》》${title }</TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>
     <form action="${url }" method="post" onsubmit="return checkform()" enctype="multipart/form-data">
<div class="layui-table-box" >
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1 class="layui-table">
  	
  	<TR >
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位号:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="chepai"  id='chepaiid'  size="50" style="height:40;border:0" placeholder="请输入车位号："  />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车架号:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="chejia"  id='chejiaid'  size="50" style="height:40;border:0" placeholder="请输入车架号："  />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">适用:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="pinpai"  id='pinpaiid'  size="50" style="height:40;border:0" placeholder="请输入适用类型："  />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位型号:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="xinghao"  id='xinghaoid'  size="50" style="height:40;border:0" placeholder="请输入车位型号："  />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位图片:</TD>
    <TD align="center" data-field="id"> 
    <input name="prodFile"  type="file"  id='uploadfileid'  size="50" style="height:40;border:0"  />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">车位价值(元):</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="price"  id='priceid'  size="50" style="height:40;border:0" placeholder="请输入车位价值："  />
 
    </TD>
    </TR>
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">行驶证号:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="xsz"  id='xszid' size="50" style="height:40;border:0" placeholder="请输入形式证号："   />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">付费类型:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="yanse"  id='yanseid'  size="50" style="height:40;border:0" placeholder="请输入付费类型：" />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">租金(元/天):</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="zujin"  id='zujinid'  size="50" style="height:40;border:0" placeholder="请输入车位租金："  />
 
    </TD>
    </TR>
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9"> 操作：</TD>
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

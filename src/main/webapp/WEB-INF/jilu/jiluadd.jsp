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
	 
	

	if (document.getElementById('xingmingid').value=="")
	{
		alert("客户姓名不能为空");
		return false;
	}
	if (document.getElementById('sfzid').value=="")
	{
		alert("身份证号码不能为空");
		return false;
	}
	
	if (document.getElementById('sfzid').value.length<6)
	{
		alert("身份证长度必须等于18位");
		return false;
	}
	
	
	if (document.getElementById('dianhuaid').value=="")
	{
		alert("联系电话不能为空");
		return false;
	}

	if (document.getElementById('uploadfile1id').value=="")
	{
		alert("身份证复印件不能为空");
		return false;
	}
	if (document.getElementById('uploadfile2id').value=="")
	{
		alert("驾驶证复印件不能为空");
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
    ${car.chepai }
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">用戶姓名:</TD>
    <TD align="center" data-field="id">  
    <input  type="text" name="xingming"  id='xingmingid'  size="50" style="height:40;border:0" placeholder="请输入用户姓名："  />
 
    </TD>
    </TR>
    
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">身份证号码:</TD>
    <TD align="center" data-field="id">  
    <input  type="text" name="sfz"  id='sfzid'  size="50"style="height:40;border:0" placeholder="输入身份证号码："  />
 
    </TD>
    </TR>  
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">联系电话:</TD>
    <TD align="center" data-field="id">  
    <input  type="text" name="dianhua"  id='dianhuaid'  size="50" style="height:40;border:0" placeholder="请输入联系方式："  />
 
    </TD>
    </TR>
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">身份证复印件:</TD>
    <TD align="center" data-field="id">  
    <input name="prodFile1"  type="file"  id='uploadfile1id'  size="50" style="height:40;border:0" placeholder="上传身份证复印件："  />
 
    </TD>
    </TR>
     <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">驾驶证复印件:</TD>
    <TD align="center" data-field="id"> 
    <input name="prodFile2"  type="file"  id='uploadfile2id'  size="50" style="height:40;border:0" placeholder="上传驾驶证复印件："  />
 
    </TD>
    </TR> 
    <TR height=>
    <TD align="center" data-field="id" style="background-color:	#A9A9A9">备注:</TD>
    <TD align="center" data-field="id"> 
    <input  type="text" name="beizhu"    size="50" style="height:40;border:0" placeholder="备注："  />
 
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

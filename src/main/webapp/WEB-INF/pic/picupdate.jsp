<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	if (document.getElementById('chepaiid').value=="")
	{
		alert("车牌号不能为空");
		return false;
	}
	if (document.getElementById('chejiaid').value=="")
	{
		alert("车架号不能为空");
		return false;
	}
	if (document.getElementById('pinpaiid').value=="")
	{
		alert("品牌不能为空");
		return false;
	}
	if (document.getElementById('xinghaoid').value=="")
	{
		alert("型号不能为空");
		return false;
	}

	if (document.getElementById('priceid').value=="")
	{
		alert("车价不能为空");
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
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background=images/title_bg1.jpg>当前位置:---》》${title }</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background=images/shadow_bg.jpg></TD>
		</TR>
	</TABLE>
	<form action="${url }" method="post" onsubmit="return checkform()"
		enctype="multipart/form-data">
		<div class="layui-table-box">
			<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=1
				class="layui-table">
				<TR height=>
					<TD align="center" data-field="id"
						style="background-color: #A9A9A9">展示图片:</TD>
					<TD align="center" data-field="id"><img
						src="<%=basePath %>${bean.path }" width="200" height="200" /></TD>
				</TR>
				<TR height=>
					<TD align="center" data-field="id"
						style="background-color: #A9A9A9">重新上传:</TD>
					<TD align="center" data-field="id"><input name="prodFile"
						type="file" id='uploadfileid' size="50" /></TD>
				</TR>
				<TR height=>
					<TD align="center" data-field="id"
						style="background-color: #A9A9A9">说明:</TD>
					<TD align="center" data-field="id"><input type="text"
						name="info" value="${bean.info }" id='priceid' size="50" /></TD>
				</TR>
				<TR height=>
					<TD align="center" data-field="id"
						style="background-color: #A9A9A9">图片链接:</TD>
					<TD align="center" data-field="id"><input type="text"
						name="href" value="${bean.href }" id='xszid' size="50" /></TD>
				</TR>
				<TR height=>
					<TD align="center" data-field="id"
						style="background-color: #A9A9A9">操作:</TD>
					<TD align="center" data-field="id"><input type="submit"
						value="提交" style="width: 60px" class="layui-btn layui-btn-sm" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						onclick="javascript:history.go(-1);" style="width: 60px"
						type="button" value="返回"
						class="layui-btn layui-btn-sm layui-btn-normal" /></TD>
				</TR>
			</TABLE>
		</div>
	</form>
	<script type="text/javascript"
		src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
</BODY>
</HTML>

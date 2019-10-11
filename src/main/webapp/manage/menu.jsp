<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<SCRIPT language=javascript>
	function expand(el)
	{
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none')
		{
			childObj.style.display = 'block';
		}
		else
		{
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>
<BODY>
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
		style="background-color:#333744;" border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<c:if test="${manage.role==1}">
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
								
									<A class=menuParent onclick=expand(1)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-friends"></i>人员管理</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>
							<TR height=20>
							
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="userlist.do" target=main style="color:white">人员管理</A>
								</TD>
							</TR>


							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>


						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(2)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-find-fill"></i>车位管理</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="carlist.do" target=main style="color:white;">车位管理</A>
								</TD>
							</TR>


							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="carlist2.do" target=main style="color:white;">车牌识别失效管理</A>
								</TD>
							</TR>


							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(3)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-senior"></i>网站公告</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="gonggaolist.do" target=main style="color:white;">网站公告管理</A>
								</TD>
							</TR>

							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>



						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(4)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-website"></i>展示图片</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="piclist.do" target=main style="color:white;">展示图片管理</A>
								</TD>
							</TR>

							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>


						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(5)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-app"></i>报表统计</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="rilist.do" target=main style="color:white;">日收入统计</A>
								</TD>
							</TR>


							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="yuelist.do" target=main style="color:white;">月收入统计</A>
								</TD>
							</TR>


							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-face-smile" style="color:white"></i></TD>
								<TD><A class=menuChild href="carlist4.do" target=main style="color:white;">车辆收入统计</A>
								</TD>
							</TR>


							<TR height=4>
								<TD colSpan=2></TD>
							</TR>
						</TABLE>
					</c:if>
					<!-- 工作1 -->
					<c:if test="${manage.role==2}">
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(1)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-engine" style="color:white"></i>车辆出库</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="carlist3.do" target=main style="color:white;"> 车辆出库管理</A>
								</TD>
							</TR>


							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="jilulist.do" target=main style="color:white;">出库管理</A>
								</TD>
							</TR>


							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="jilulist2.do" target=main style="color:white;">技术确认查询</A>
								</TD>
							</TR>


							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="jilulist5.do" target=main style="color:white;">确认管理</A>
								</TD>
							</TR>


							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>



						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(2)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-tree" style="color:white"></i>预定车位/入库</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="yudinglist.do" target=main style="color:white;">待处理预定</A>
								</TD>
							</TR>
							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="yudinglist2.do" target=main style="color:white;">已处理预定</A>
								</TD>
							</TR>
							<TR height=4>
								<TD colSpan=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(3)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-edit"></i>留言管理</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="liuyanlist.do" target=main style="color:white;">待处理留言</A>
								</TD>
							</TR>
							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="liuyanlist2.do" target=main style="color:white;">已处理留言</A>
								</TD>
							</TR>
							<TR height=4>
								<TD colSpan=3></TD>
							</TR>

						</TABLE>
						

						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(4)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-fire"></i>客户信息</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="userlist2.do" target=main style="color:white;">客户信息查询</A>
								</TD>
							</TR>
							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>											
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(5)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-template"></i>会员管理</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="userlist3.do" target=main style="color:white;">会员信息</A>
								</TD>
							</TR>
												<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="userlist4.do" target=main style="color:white;">普通客户</A>
								</TD>
							</TR>
							<TR height=4>
								<TD colSpan=2></TD>
							</TR>
						</TABLE>
						<!-- 车牌识别部分 -->
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(6)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-edit"></i>车牌信息</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child6 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="provice.action" target=main style="color:white;">所在地统计</A>
								</TD>
							</TR>
							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="color.action" target=main style="color:white;">车牌颜色统计</A>
								</TD>
							</TR>

                           <TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="index1" target=main style="color:white;">历史纪录</A>
								</TD>
							</TR>
							<TR height=4>
								<TD colSpan=3></TD>
							</TR>

						</TABLE>
						<!-- 车牌识别部分 -->
					</c:if>
					<c:if test="${manage.role==3}">
						<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
							<TR height=22>
								<TD>
									<A class=menuParent onclick=expand(1)
									href="javascript:void(0);" style="color:white;"><i class="layui-icon layui-icon-set"></i>车辆状态</A>
								</TD>
							</TR>
							<TR height=4>
								<TD></TD>
							</TR>
						</TABLE>
						<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
							width=150 border=0>

							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="jilulist3.do" target=main style="color:white;">待确认车辆</A>
								</TD>
							</TR>
							<TR height=20>
								<TD align=middle width=30><i class="layui-icon layui-icon-right" style="color:white"></i></TD>
								<TD><A class=menuChild href="jilulist4.do" target=main style="color:white;">已确认车辆</A>
								</TD>
							</TR>
							<TR height=4>
								<TD colSpan=2></TD>
							</TR>

						</TABLE>
					</c:if>
					</TD>
					<TD width=1 bgColor=#d1e6f7></TD>
					</TR>
				</TABLE><script type="text/javascript" src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.4/layui.js"></script>
</BODY>
</HTML>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentPath", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>车牌识别</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script type="text/javascript">
	function showPreview(source) {
		var file = source.files[0];
		if (window.FileReader) {
			var fr = new FileReader();
			console.log(fr);
			var portrait = document.getElementById('portrait');
			fr.onloadend = function(e) {
				portrait.src = e.target.result;
			};
			fr.readAsDataURL(file);
			portrait.style.display = 'block';
		}
	}
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- 修改(替换图片) -->
	<!-- 修改(替换图片) -->
	<!-- 新增    采用模态框-->
	<div class="modal modal-info fade" id="modal-info"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">选中车牌图片</h4>
				</div>
				<div class="modal-body">
					<form action="addUser" method="post" enctype="multipart/form-data">
						<small class="label label-info"><i
							class="fa fa-fw fa-user"></i>用户名称：</small> <input style="color: black;"
							type="text" name="userName" /><br /> <br /> <small
							class="label label-info"><i
							class="fa fa-fw fa-file-image-o"></i>上传用户入库/出库/库中车辆图片：</small> <input type="file"
							name="file" id="file0" onchange="showPreview(this)" /><br /> <br />
						<img id="portrait" src=""
							style="display: none; width: 500px; height: 500px;" /><br /> <br />
						<button type="button" class="btn btn-outline pull-left"
							data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-outline"></input>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- 新增 -->
	<!-- 详情 -->
	<!-- 详情 -->
	<div class="wrapper" style="background-color: grey">
		<header class="main-header">
			<a href="#" class="logo" style="background-color: #2ae0c8"> <span
				class="logo-lg " class="fa fa-photo"
				style="background-color: #2ae0c8"><b>快速上传信息</b></span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation"
				style="background-color: #2ae0c8">
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="dist/img/1999.jpg" class="user-image" alt="User Image">
								<span class="hidden-xs">欢迎进入车牌识别系统</span>
						</a></li>
					</ul>
				</div>
			</nav>
		</header>


		<aside class="main-sidebar"">
			<section class="sidebar">
				<ul class="sidebar-menu" data-widget="tree" id="mydiv"
					style="margin-top: 50px">
					<li><a style="color: white; line-height: 50px" href="index1"><i
							class="fa fa-book"></i> <span>历史纪录</span></a></li>
					<li><a style="color: white; line-height: 50px"
						href="echarts/test.action"><i class="fa fa-fw fa-bar-chart"></i>
							<span>颜色统计</span></a></li>
					<li><a style="color: white; line-height: 50px"
						href="provice.action"><i
							class="fa fa-fw fa-location-arrow"></i> <span>所在地统计</span></a></li>
					<li><a style="color: white; line-height: 50px"
						href="user/login1"><i class="fa fa-edit"></i> <span>退出系统</span></a></li>
					<li><a style="color: white; line-height: 50px" href="#"><i
							class="fa fa-book"></i> <span>Documentation</span></a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>



		<!-- 主体部分 -->
		<div class="content-wrapper"
			style="background-image: url(dist/img/2.jpg); background-size: cover">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1 style="color: rgb(241, 247, 241)">本地上传</h1>

				<!-- Main content -->
				<section class="content container-fluid"
					style="background-color: rgba(221, 217, 217, 0.1)">
					<!--------------------------
        | 代码写这里 |
        -------------------------->
					<!-- 选择图片 -->
					<div class="selimg">
						<div class="box box-primary"
							style="background-color: rgba(221, 217, 217, 0.5)">
							<div class="box-header with-border">
								<h3 class="box-title" style="color: white">请选择图片</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form" name="form0" id="form0"
							
								style="margin-top: 30px;">
								<div class="box box-widget"
									style="background-color: rgba(221, 217, 217, 0.4)">
									<div class="box-header with-border" style="margin-top: 30px;">

										<!-- /.user-block -->
										<div class="box-tools"
											style="background-color: rgba(221, 217, 217, 0.4)">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-minus"></i>
											</button>
											<button type="button" class="btn btn-box-tool"
												data-widget="remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
										<!-- /.box-tools -->
									</div>
									<!-- /.box-header -->
									<div class="box-body">
										<table>
											<tr>
												<th width="5%">编号</th>
												<th width="5%">姓名</th>
												<th width="5%">图片名称</th>
												<th width="5%">图片</th>
												<th width="5%">操作</th>
											</tr>
											<c:forEach items="${pageInfo.list }" var="user">
												<tr>
													<td>${user.id}</td>
													<td>${user.userName}</td>
													<td>${user.userImg}</td>
													<td style="padding-right: 30px"><img
														class="img-responsive pad" id="portrait"
														src="${currentPath}/upload/${user.userImg}"></td>
													<th><a href="${currentPath}/deleteUser?id=${user.id}"
														onclick="return confirm('确认删除？')"><button
																type="button" class="btn btn-warning"
																data-toggle="modal" data-target="#modal-warning">删除</button></a>&nbsp;&nbsp;
														<a href="${currentPath}/toUpdateUser?id=${user.id}">
															<button type="button" class="btn btn-primary"
																style="background-color: salmon;">修改</button>
													</a> <a href="${currentPath}/findById?id=${user.id}">
															<button type="button" class="btn btn-primary"
																style="background-color: salmon;">详情</button>
													</th>
												</tr>
											</c:forEach>
										</table>
										<div class="row"
											style="margin-right: 15px; margin-left: 15px; margin-top: 50px">
											<div class="col-sm-5" style="margin-top: 20px">
												<div class="dataTables_info" id="example1_info"
													role="status" aria-live="polite" style="color: #d81b60">共${pageInfo.total }条记录，
													当前显示第${pageInfo.pageNum }页 总${pageInfo.pages }页</div>
											</div>
											<div class="col-sm-7">
												<div class="dataTables_paginate paging_simple_numbers">
													<ul class="pagination">
														<li class="paginate_button"><a
															href="${pageContext.request.contextPath}/index?currentPage=1">首页</a></li>
														<c:if test="${pageIfno.hasPreviousPage }">
															<li class="paginate_button"><a
																href="${pageContext.request.contextPath}/index?currentPage=${pageInfo.pageNum-1}">

															</a></li>
														</c:if>
														<c:forEach items="${pageInfo.navigatepageNums }"
															var="page_Num">
															<c:if test="${page_Num == pageInfo.pageNum }">
																<li class="paginate_button"><a href="#">${page_Num }</a></li>
															</c:if>
															<c:if test="${page_Num != pageInfo.pageNum }">
																<li class="paginate_button"><a
																	href="${pageContext.request.contextPath}/index?currentPage=${page_Num }">${page_Num }</a></li>
															</c:if>
														</c:forEach>
														<c:if test="${pageInfo.hasNextPage }">
															<li class="paginate_button"><a
																href="${pageContext.request.contextPath}/index?currentPage=${pageInfo.pageNum+1 }">>></a></li>
														</c:if>
														<li class="paginate_button"><a
															href="${pageContext.request.contextPath}/index?currentPage=${pageInfo.pages}">末页</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
						</div>
						<!-- 图片显示 -->
						<div class="box-footer"
							style="text-align: center; background-color: rgba(221, 217, 217, 0.1);">
							<button type="button" class="btn btn-info" data-toggle="modal"
								data-target="#modal-info" style="background-color: salmon">
								<i class="fa fa-fw fa-plus"></i>新增
							</button>
							<a href="index1"><button type="button" class="btn btn-info"
									style="background-color: salmon">查看</button></a>
						</div>
					</div>
					</form>
		</div>
		</section>
	</div>
	</div>
	<footer class="main-footer">
		<div class="pull-right hidden-xs">C C I T</div>
		<strong>Copyright © 2019 <a href="#">CCIT</a>.
		</strong> All rights reserved.
	</footer>
	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="dist/js/adminlte.min.js"></script>
	<script type="text/javascript">
		    var mydiv = document.getElementById("mydiv");//获得div里的车牌图片
		var myimg = mydiv.getElementsByTagName("img");//获得div的各车牌图片- 数组
		for (var i = 0; i < myimg.length; i++) {
			var myimge = document.getElementById("dao");//获得显示图片
			myimg[i].onclick = function() {
				myimge.src = this.src;//替换图片   
			}
		}
	</script>
	<!-- 鼠标悬停图片变大 （juqery放大镜）-->
	<!-- 获取图片路径 -->
	<script>
		function showSelected(obj) {
			var rootpath = 'http://localhost/';
			res = obj.src.replace(rootpath, '');
			//分离路径和图片
			document.getElementById("dao").src = obj.src;
			console.log(obj.src);
		}
	</script>
</body>
</html>
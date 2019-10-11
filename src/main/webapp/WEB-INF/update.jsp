<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }"
	scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>车牌识别</title>
<!-- Tell the browser to be responsive to screen width -->
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
<style>
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<a href="#" class="logo"> <span class="logo-lg"><b>修改车辆图片</b></span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation">
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="dist/img/1999.jpg" class="user-image" alt="User Image">
								<!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">常州信息职业技术学院</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img src="dist/img/1999.jpg"
									class="img-circle" alt="User Image">

									<p>
										常州信息职业技术学院 <small>2019.05.03</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<aside class="main-sidebar" style="background-color: grey">
			<section class="sidebar" style="height:auto">
				<ul class="sidebar-menu tree" data-widget="tree" id="mydiv">
					<iframe id="iframe" src="http://www.jq22.com/demo/hkwzy201711121551" frameborder="0" width="100%" height="742px"></iframe>
				</ul>
			</section>
		</aside>
		<div class="content-wrapper"
			style="background-image: url(dist/img/2.jpg); background-size: cover">
			<section class="content container-fluid" style="text-align: center">

				<!--------------------------
        | 代码写这里 |
        -------------------------->
				<div class="box box-primary"
					style="width: 100%; background-color: rgba(221, 217, 217, 0.5)">
					<div class="box-header with-border">
						<h3 class="box-title">修改车主车图</h3>
					</div>
					<form role="form" action="updateUser" method="post"
						enctype="multipart/form-data">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputPassword1"><i
									class="fa fa-fw fa-user"></i>车主姓名</label> <input type="text"
									style="width: 20%; margin-left: 550px; border: 1px solid red"
									class="form-control" name="userName" value="${user.userName }"
									id="exampleInputEmail1" placeholder="请输入车主姓名">
							</div>
							<div class="form-group" style="float: left; margin-left: 100px">
								<label for="exampleInputFile"><i class="fa fa-fw fa-car"></i>原始图片</label>
								<img style="margin-top: 25px"
									src="${baseUri}/upload/${user.userImg}" width="400px"
									height="400px" />
							</div>
							<div class="form-group" style="float: left; margin-left: 100px">
								<input type="file" name="file" onchange="showPreview(this)"
									id="exampleInputFile"> <img id="portrait" src=""
									style="display: none; width: 400px; height: 400px;" />
								<!-- 隐藏 -->
								<input type="hidden" name="id" value="${user.id}" />
								<!-- 隐藏 -->
							</div>
						</div>
						<div class="box-footer"
							style="background-color: rgba(221, 217, 217, 0.5)">
							<button type="submit" id="sub" class="btn btn-danger">提交</button>
						</div>
					</form>
				</div>
			</section>

		</div>
		
		<aside class="control-sidebar control-sidebar-dark"></aside>

	</div>
	<footer class="main-footer">
			<div class="pull-right hidden-xs">C C I T</div>
			<strong>Copyright &copy; 2019 <a href="#">CCIT</a>.
			</strong> All rights reserved.
		</footer>
	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="dist/js/adminlte.min.js"></script>
	<script>
		
	</script>
</body>
</html>
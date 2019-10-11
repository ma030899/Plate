<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>注册</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b>注册</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">车牌识别系统注册</p>

   <mvc:form class="login" action="verify" name="register"
		modelAttribute="user" method="post">
		<div class="form-group has-feedback">
        <mvc:input type="text" path="username" placeholder="用户名"
			name="username" class="form-control" />
		
        <span class="glyphicon glyphicon-user form-control-feedback">
		<mvc:errors path="username" style="color: RED" />
		</span>
      </div>
      <div class="form-group has-feedback">
        <mvc:input type="email" path="email" placeholder="邮箱地址" name="email" class="form-control" />
        <span class="glyphicon glyphicon-envelope form-control-feedback">
		<mvc:errors path="email" style="color: RED" />
		</span>
      </div>
      <div class="form-group has-feedback">
        <mvc:input type="password" path="password" placeholder="密码"
			name="password" class="form-control" />
        <span class="glyphicon glyphicon-lock form-control-feedback">
		<mvc:errors path="password" style="color: RED" />
		</span>
      </div>
	  <div class="form-group has-feedback">
       <input type="password" placeholder="再次输入密码" name="password2" class="form-control" />
        <span class="glyphicon glyphicon-lock form-control-feedback">
		
		</span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox">记住我
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" class="btn btn-primary btn-block btn-flat" onclick="Regis()">注册</button>
		   <button type="button" class="btn btn-primary btn-block btn-flat" onclick="window.location.href='/PlateRecognition/login'">返回</button>
        </div>
        <!-- /.col -->
      </div>
    </mvc:form>
	<script type="text/javascript">
		function Regis() {
			var pwd1 = document.forms[0][2].value;
			var pwd2 = document.forms[0][3].value;
			if (pwd1 !== pwd2) {
				alert('两次密码不符，请重新输入');
				document.forms[0][3].focus();
			} else {
				register.action = "verify";
				register.submit();
			}

		}
	</script>
  </div>
</div>

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>

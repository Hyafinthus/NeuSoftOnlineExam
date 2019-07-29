<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>教师登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery-3.2.1.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<style type="text/css">
			.vertical-center {
				min-height: 100vh;
				display: flex;
				align-items: center;
			}
		</style>
	</head>
	<body>
		<!-- <ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="login.html">Login</a></li>
			<li role="presentation"><a href="menu.html">Menu</a></li>
			<li role="presentation"><a href="#">Messages</a></li>
		</ul> -->
		<!-- <ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="#">Home</a></li>
			<li role="presentation"><a href="#">Profile</a></li>
			<li role="presentation"><a href="#">Messages</a></li>
		</ul> -->
		<div class="container">
			<div class="row">

				<div class="col-lg-7 vertical-center">
					<div class="center-vertical">
						<h1 style="font-size: 100px;">考试系统 <small style="font-size: 40px;">登录</small>
							</h1>
					</div>
				</div>

				<div class="col-lg-4 vertical-center">
					<div class="jumbotron">
						<form action="login/teacher" name="myform"  id="form" method="post">
							<div class="form-group">
								<label for="teacher_id">账号</label>
								<input type="text" class="form-control" name="teacher_id" id="teacher_id" placeholder="请输入账号">
							</div>
							<div class="form-group">
								<label for="teacher_password">密码</label>
								<input type="password" class="form-control" name="teacher_password" id="teacher_password" placeholder="请输入密码">
							</div>
							<button id="btn" type="button" class="btn btn-default">登录</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$("#btn").click(function() {
			var uid = $("#teacher_id").val();
			var pwd = $("#teacher_password").val();
			// var param = '{"id":"'+uid+'","password":"'+pwd+'"}';
			if(uid==null || uid==''){
				//alert("邮箱不能为空");
				alert("账号不能为空");
			}
			else if(pwd==null ||pwd==''){
				//rt("密码不能为空");
				alert("密码不能为空");
			}
			else{
				//提交
				var form = document.getElementById("form");
				form.submit();
			}
		});
	</script>
</html>
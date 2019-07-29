<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>
			教师主页
		</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-3.2.1.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script type="text/javascript">
			var now = new Date();

			var hour = now.getHours();
			var greethour = "";
			if (hour < 8 && hour >= 5) {
				greethour = "早上好"
			} else if (hour < 11 && hour >= 8) {
				greethour = "上午好"
			} else if (hour < 13 && hour >= 11) {
				greethour = "中午好"
			} else if (hour < 18 && hour >= 13) {
				greethour = "下午好"
			} else if (hour < 21 && hour >= 18) {
				greethour = "晚上好"
			} else if (hour < 24 && hour >= 21 || hour < 5 && hour >= 0) {
				greethour = "夜深了"
			}
			//http://localhost:8080/exam/menu/personal
			function greet() {
				$.ajax({
					url: "/exam/menu/personal",
					datatype: "json",
					contentType: "application/json;charset=UTF-8",
					success: function(data) {
						$("#greeting").html(data[1] + "老师，" + greethour);
						$("#tname").html(data[1]);
						$("#tid").html(data[0]);
						console.log(data[1]);
					},
					error: function(status) {

					}
				});
			}
			window.onload = function() {
				greet();
			}
		</script>
	</head>
	<body>
		<div class="container-fluid" style="height: 90px;">
			<h1 style="font-size: 45px;">
				<div id="greeting">

				</div>
			</h1>
		</div>
		<div class="container">
			<ul class="nav nav-pills">
				<li role="presentation" class="active"><a href="teachermenu.html">个人信息</a></li>
				<li role="presentation"><a href="questionsmanagement.html">题目管理</a></li>
				<li role="presentation"><a href="#">考试安排</a></li>
				<li role="presentation"><a href="#">学生信息</a></li>
				<li role="presentation"><a href="#">考试安排</a></li>
			</ul>

			<div class="container" style="width: 700px;float: left;">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>工号</th>
							<th>姓名</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="href"><button type="button" class="btn btn-primary btn-xs">修改</button></a></td>
							<td>
								<div id="tid">

								</div>
							</td>
							<td>
								<div id="tname">

								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>

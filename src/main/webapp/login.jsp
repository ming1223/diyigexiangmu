<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.oraclewdp.big.model.Admin" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="charset=UTF-8">
<head>
<title>登陆</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bower_components/bootswatch/dist/materia/bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid" style="width: 80%;">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">

						<%
							Admin admin = (Admin) request.getAttribute("admin");

							if (admin != null) {
						%>
						<form method="post" action="loginAdmin" autocomplete="off"  id="forVcode">
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="用户名" name="name" value="<%=admin.getName()%>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPwd"
										placeholder="密码" name="pwd">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputVcode" class="col-sm-2 col-form-label text-right">验证码</label>
								<div class="col-sm-4">
									<input class="form-control" id="inputVcode"
										   placeholder="验证码" name="Vcode">
									<%=request.getAttribute("cw")%>
								</div>

								<div class="col-sm-6">
									<img src="vcode.png">
								</div>

							</div>

							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">登陆</button>
								</div>
							</div>
						</form>
						<%
							} else {
						%>


						<form method="post" action="loginAdmin">
							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="用户名" name="name">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPwd"
										placeholder="密码" name="pwd">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputVcode" class="col-sm-2 col-form-label text-right">验证码</label>
								<div class="col-sm-4">
									<input class="form-control" id="inputVcode"
										   placeholder="验证码" name="Vcode">
								</div>
								<div class="col-sm-4">
									<img src="vcode.png" id="Vcode" title="点击切换图片">
								</div>

							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">登陆</button>
								</div>
							</div>
						</form>
						<%
							}
						%>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.slim.js"></script>
<script type="text/javascript">
	$(function () {
		$("#Vcode").click(function () {
			$("#Vcode").attr("src","vcode.png?t="+Math.random());
        });
    });
</script>
</body>
</html>
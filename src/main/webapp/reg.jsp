<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="charset=UTF-8">

<head>
<title>注册</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bower_components/bootswatch/dist/materia/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link
	href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.custom-file-label::after {
	content: "浏览";
}
</style>

</head>
<body>
	<div class="container-fluid" style="width: 80%;">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
					
						<%
							Admin user =(User) request.getAttribute("user");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						if(user!=null){
						
						%>
						<form method="post" enctype="multipart/form-data" action="reg">
						<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="用户名" name="name"  value="<%=user.getName() %>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPwd"
										placeholder="密码" name="pwd" <%=user.getPwd() %>>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputAge" class="col-sm-2 col-form-label text-right">年龄</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputAge"
										placeholder="年龄" name="age" value="<%=user.getAge() %>>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputBirthday"
									class="col-sm-2 col-form-label text-right">生日</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputBirthday"
										placeholder="生日" name="birthday" readonly="readonly" value="<%= sdf.format(user.getBirthday()) %>>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPhoto"
									class="col-sm-2 col-form-label text-right">头像</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="inputPhoto"
												aria-describedby="inputGroupFileAddon04" name="photo">
											<label class="custom-file-label" for="inputGroupFile04">请选择文件</label>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">注册</button>
								</div>
							</div>
						</form>
						<%
						}
						%><%
						else{
						%>
						<form method="post" enctype="multipart/form-data" action="reg">
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
										placeholder="密码" name="pwd" >
								</div>
							</div>
							<div class="form-group row">
								<label for="inputAge" class="col-sm-2 col-form-label text-right">年龄</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputAge"
										placeholder="年龄" name="age" >
								</div>
							</div>
							<div class="form-group row">
								<label for="inputBirthday"
									class="col-sm-2 col-form-label text-right">生日</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputBirthday"
										placeholder="生日" name="birthday" readonly="readonly" >
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPhoto"
									class="col-sm-2 col-form-label text-right">头像</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="inputPhoto"
												aria-describedby="inputGroupFileAddon04" name="photo">
											<label class="custom-file-label" for="inputGroupFile04">请选择文件</label>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">注册</button>
								</div>
							</div>
						</form>
						<%
						}%>
							
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.slim.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script type="text/javascript">
		$('#inputBirthday').datepicker({
					language: 'zh-CN',
				format:'yyyy-mm-dd',
				autoclose:true,
			    defaultViewDate: {
				    year:new Date().getFullYear()-18
				    }
					});

		</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="charset=UTF-8">
<head>
<title>大类</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bower_components/bootswatch/dist/materia/bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">

						<form method="post" action="smallTypeAdd">
							<div class="form-group row">
								<label for="inputEmail"
									class="col-sm-2 col-form-label text-right">大类</label>
								<div class="col-sm-10">
									<select name="bid" class="form-control" id="inputid">

									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3"
									class="col-sm-2 col-form-label text-right">小类</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="小类" name="name">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.js"></script>
	<script type="text/javascript">
		/*var xhr = new XMLHttpRequest();
		xhr.open("GET", "findAllBigType");
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					//console.dir(xhr.responseText);
					eval(xhr.responseText);
				}
			}

		}*/
		function fillSel(types) {
			for (var i = 0; i < types.length; i++) {
				var op = new Option(types[i].name, types[i].id);
				document.getElementById("inputid").appendChild(op);
			}
		}
		$.ajax({
			type : "GET",
			url : "findAllBigType",
			jsonpCallback : "fillSel",
			dataType:"jsonp"
		});
	</script>
</body>
</html>
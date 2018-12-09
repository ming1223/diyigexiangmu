<%@page import="java.util.List"%>
<%@page import="com.oraclewdp.big.model.Book"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" id="zt" />
	<link rel="stylesheet" type="text/css" href="bower_components/fontawesome/web-fonts-with-css/css/fontawesome-all.css">
<link
	href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript"
	src="bower_components/jquery.cookie/jquery.cookie.js"></script>
<script type="text/javascript">
	if ($.cookie("ff")) {
		$("#zt").attr(
				"href",
				"bower_components/bootswatch/dist/" + $.cookie("ff")
						+ "/bootstrap.css");
		$("#dd").val($.cookie("ff"));
	} else {
		$("#zt").attr("href",
				"bower_components/bootswatch/dist/solar/bootstrap.css");
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">

					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link" href="#">Link
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="http://example.com"
								id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown
									link</a>
								<div class="dropdown-menu"
									aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a
										class="dropdown-item" href="#">Another action</a> <a
										class="dropdown-item" href="#">Something else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Separated link</a>
								</div></li>
						</ul>
						<form class="form-inline">
							<input class="form-control mr-sm-2" type="text" />
							<button class="btn btn-primary my-2 my-sm-0" type="submit">
								Search</button>
						</form>
						<ul class="navbar-nav ml-md-auto">
							<li class="nav-item active"><a class="nav-link"
								href="javascript:void(0)"> <select id="dd"
									class="custom-select">
										<option>solar</option>
										<option>lux</option>
										<option>pulse</option>
										<option>slate</option>
								</select>
							</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="http://example.com"
								id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown
									link</a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a
										class="dropdown-item" href="#">Another action</a> <a
										class="dropdown-item" href="#">Something else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Separated link</a>
								</div></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-success">
					<div class="card-header" style="padding: 0px">
						<form class="form-inline" action="bookList" method="post" id="biaodan">
							<label class="sr-only" for="inlineFormInputName2">书名</label> <input
								type="text" class="form-control mb-2 mr-sm-2"
								id="inlineFormInputName2" placeholder="书名" name="shuming" value="<%=request.getParameter("shuming")==null?"":request.getParameter("shuming")%>"> <label
								class="sr-only" for="inlineFormInputGroupUsername2">大类</label>
							<div class="input-group mb-2 mr-sm-2">
							<select class="form-control" id="inputid" name="bid" >
							<option value="-1">--请选择--</option>
							
							</select>
								
							</div>
							<label class="sr-only" for="inlineFormInputGroupUsername2">小类</label>
							<div class="input-group mb-2 mr-sm-2">
							<select class="form-control" id="inputxid" name="xid">
							  <option value="-1">---请选择--</option>
							
							</select>
								
							</div>

							<button type="submit" class="btn btn-primary mb-2">查找</button>
						</form>
					</div>

					<div>
						<table class="table table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th>类别</th>
									<th>类型</th>
									<th>书名</th>
									<th>价格</th>
									<th>作者</th>
									<th>字数</th>
									<th>简介</th>
									<th>图片</th>
									<th>出版社</th>
									<th>出版日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<%
									Book book = new Book();
									List<Book> ls = (List<Book>) request.getAttribute("ls");
									for (Book Book : ls) {
								%>
								<tr>

									<td><%=Book.getId()%></td>
									<td><%=Book.getXid()%></td>
									<td><%=Book.getShuming()%></td>
									<td><%=Book.getJiage()%></td>
									<td><%=Book.getZuozhe()%></td>
									<td><%=Book.getZishu()%></td>
									<td><%=Book.getJianjie()%></td>
									<td><img src="upload/<%=Book.getTupian()%>" width="300px"
										height="300px"></td>
									<td><%=Book.getChuban()%></td>
									<td><%=Book.getRiqi()%></td>
									<td>
									<a href="#modal-container-875486" data-toggle="modal" class="fa fa-trash fa-1x" title="删除" onclick="window.delId='<%=Book.getId()%>'"></a>
										&nbsp;&nbsp;&nbsp; <a class="fa fa-edit fa-1x" title="修改"
															  href="toEdit?id=<%=Book.getId()%>"></a></td>
								</tr>
								<%
									}
								%>
							</tbody>

						</table>
						<div class="card-footer" style="padding: 0px">
							<nav>
								<ul class="pagination" style="margin-bottom: 0px">
									<%
										//全部页数
										int totalPage = (Integer) request.getAttribute("totalPage");
										//那一页
										int currentPage = (Integer) request.getAttribute("currentPage");
										if (currentPage == 1) {
									%>
									<li class="page-item disabled"><a class="page-link"
										href="#">上一页</a></li>
									<%
										} else {
									%>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=currentPage - 1%>">上一页</a></li>
									<%
										}
									%>
									<%
										if (totalPage <= 5) {
											for (int i = 1; i <= totalPage; i++) {
									%>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=i%>"><%=i%></a></li>
									<%
										}
										} else if (currentPage <= 3) {
									%>
									<li class="page-item"><a class="page-link"
										href="book?currentPage=1">1...</a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=2">2</a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<3">3</a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=4">4</a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=totalPage%>">...<%=totalPage%></a></li>
									<%
										} else if (currentPage <= totalPage - 3) {
									%>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=1">1...</a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=currentPage - 1%>"><%=currentPage - 1%></a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=currentPage%>"><%=currentPage%></a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=currentPage + 1%>"><%=currentPage + 1%></a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=totalPage%>">...<%=totalPage%></a></li>
									<%
										} else {
									%>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=1">1...</a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=totalPage - 3%>"><%=totalPage - 3%></a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=totalPage - 2%>"><%=totalPage - 2%></a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=totalPage - 1%>"><%=totalPage - 1%></a></li>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=totalPage%>"><%=totalPage%></a></li>
									<%
										}
									%>
									<%
										if (currentPage == totalPage) {
									%>
									<li class="page-item disabled"><a class="page-link"
										href="#">下一页</a></li>
									<%
										} else {
									%>
									<li class="page-item"><a class="page-link"
										href="bookList?currentPage=<%=currentPage + 1%>">下一页</a></li>
									<%
										}
									%>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="jumbotron">
						<h2>Hello, world!</h2>
						<p>This is a template for a simple marketing or informational
							website. It includes a large callout called the hero unit and
							three supporting pieces of content. Use it as a starting point to
							create something more unique.</p>
						<p>
							<a class="btn btn-primary btn-large" href="#">Learn more</a>
						</p>
					</div>
				</div>
			</div>
			</div>
		</div>
			<div class="modal fade" id="modal-container-875486" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								删除确认
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							是否删除
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary" onclick="del(event)">
								确认
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								取消
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		<script type="text/javascript"
			src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
		<script type="text/javascript">
		$(function() {
			$("#dd").change(
					function(evt) {
						$("#zt").attr(
								"href",
								"bower_components/bootswatch/dist/"
										+ $(evt.target).val()
										+ "/bootstrap.css");
						$.cookie("ff", $(evt.target).val(), {
							expires : 7
						});
					});
			$('a[href="bookList?currentPage=<%=currentPage%>"]').parent("li").addClass("active");
			$.ajax({
				type : "GET",
				url : "findAllBigType",
				jsonpCallback : "fillSel",
				dataType : "jsonp"
			});
			$("#inputid").change(function() {
				$.ajax({
					type : "GET",
					url : "shuBigType",
					jsonpCallback : "fillSels",
					data : "bid=" + $(this).val(),
					dataType : "jsonp"
				});
			});
			$('a[class="page-link"][href^="bookList?currentPage="]').click(function(){
				$(this).attr("href",$(this).attr("href")+"&"+$("#biaodan").serialize());
				})
		});
		
		$("#dd").val($.cookie("ff"));


		
		function fillSel(types) {
			for (var i = 0; i < types.length; i++) {
				var op = new Option(types[i].name, types[i].id);
				document.getElementById("inputid").appendChild(op);
				
			}
				 $("#inputid").val('<%=request.getAttribute("bid")%>');
			console.log(<%=request.getAttribute("bid")%>);
		
			 
			  $("#inputid").trigger("change");
		}
		
		function fillSels(types) {
			document.getElementById("inputxid").innerHTML = '<option value="-1">---请选择--</option>';
			for (var i = 0; i < types.length; i++) {
				var op = new Option(types[i].name, types[i].id);
				document.getElementById("inputxid").appendChild(op);
			}
			  $("#inputxid").val('<%=request.getAttribute("xid")%>');
		}
		function del(event){
				window.location.href="bookDle?id="+window.delId;
			}
		
	</script>
</body>
</html>
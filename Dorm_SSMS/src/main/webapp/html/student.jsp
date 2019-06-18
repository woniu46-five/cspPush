<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<script src="../js/jquery.min.js"></script>

<script src="../js/menu.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript">
		
		 function allclazz() {
			 $.ajax({
					url : '../clazz/total',
					type : 'post',
					data : {
						
					},
					success : function(data) {
					var content = "";
						content+="<select style='margin-left: 20px;' name='clazz.cname' >";
						for(var i =0;i<data.length;i++){
							
							content+="<option>"+data[i].cname+"</option>";
						}
						content+="</select>";
						$("#myclazz").html(content); 
					}
				
				});	
		}
	allclazz();
	 function alldorm() {
		 $.ajax({
				url : '../dorm/total',
				type : 'post',
				data : {
					
				},
				success : function(data) {
				var content = "";
					content+="<select style='margin-left: 20px;' name='dorm.daddress' >";
					for(var i =0;i<data.length;i++){
						if(data[i].typeid==1){
						content+="<option>"+data[i].daddress+"</option>";
						}
					}
					content+="</select>";
					$("#mydorm").html(content);
				}
			
			});	
	}
alldorm();

function man() {
	 $.ajax({
			url : '../dorm/total',
			type : 'post',
			data : {
				
			},
			success : function(data) {
			var content = "";
				content+="<select style='margin-left: 20px;' name='dorm.daddress' >";
				for(var i =0;i<data.length;i++){
					if(data[i].typeid==1){
					content+="<option>"+data[i].daddress+"</option>";
					}
				}
				content+="</select>";
				$("#mydorm").html(content);
			}
		
		});	
}
function woman() {
	 $.ajax({
			url : '../dorm/total',
			type : 'post',
			data : {
				
			},
			success : function(data) {
			var content = "";
				content+="<select style='margin-left: 20px;' name='dorm.daddress' >";
				for(var i =0;i<data.length;i++){
					if(data[i].typeid==2){
					content+="<option>"+data[i].daddress+"</option>";
					}
				}
				content+="</select>";
				$("#mydorm").html(content);
			}
		
		});	
}

	
		
		
		function all(page) {

			$.ajax({
				url : '../student/all',
				type : 'post',
				data : {
					"currentpage" : page,
					"count" : 2
				},
				success : function(data) {
				var content = "";
				content+="	<table class='table table-striped table-hover table-bordered'>"+
				"<thead>"+
					"<tr>"+
						"<th>学生姓名</th>"+
						"<th>性别</th>"+
						"<th>班级</th>"+
						"<th>所在房间</th>"+
						"<th>联系电话</th>"+
						
					"</tr>"+
				"</thead>";	
				for(var i=0;i<data.length;i++){
					content+="<tr onclick='myclick("+data[i].sid+")'>"+
						"<td>"+data[i].sname+"</td>"+
						"<td>"+data[i].ssex+"</td>"+
						"<td>"+data[i].clazz.cname+"</td>"+
						"<td>"+data[i].dorm.daddress+"</td>"+
						"<td>"+data[i].telphone+"</td>"+
					"</tr>";
				}
				content+="</table>";
				$("#allstudent").html(content);
				$("#currentpage").html(page);
				}
				
			
			});
		}
all(1);
function myclick(id) {
	alert(id);
	$("#myid").val(id);
}
function allpage() {
	 $.ajax({
			url : '../student/allpage',
			type : 'post',
			data : {
				"count" : 2
			},
			success : function(data) {
				
			
				$("#totalpage").html(data.toatalpage);
			}
		
		});	
}
allpage();
function nextpage(){
	var current=$("#currentpage").html();
	var currentPage=parseInt(current);
	var total=$("#totalpage").html();
	var totalPage=parseInt(total);
	if(currentPage < totalPage){
		all(currentPage + 1);
	}
}
function prepage(){
	var current=$("#currentpage").html();
	var currentPage=parseInt(current);
	
	if(currentPage > 1){
		all(currentPage - 1);
	}
}
function endpage(){
	var total=$("#totalpage").html();
	var totalPage=parseInt(total);
	all(totalPage);
}
function firstpage() {
	all(1);
}
function sdelete() {
	
	 $.ajax({
			url : '../student/delete',
			type : 'post',
			data : {
				"sid" : $("#myid").val()
			},
			success : function(data) {
				window.location.reload();
			
				
			}
		
		});	
}

function show() {
	
	 $.ajax({
			url : '../student/show',
			type : 'post',
			data : {
				"sid" : $("#myid").val()
			},
			success : function(data) {
				var content="";
				content+="	<table>"+
					"<tr>"+
				"<td><span style='margin-left: 80px;'>姓名</span></td>"+

				"<td><span style='margin-left: 20px;'>"+data.sname+"</span></td>"+
				"<td><span style='margin-left: 60px;'>头像</span></td>"+

				"<td colspan='3'><img src='/imgUrl/"+data.simg+"'"+
					"width='100px' height='100px' /></td>"+
			"</tr>"+
			"<tr>"+
				"<td><span style='margin-left: 80px;'>性别</span></td>"+

				"<td><span style='margin-left: 20px;'>"+data.ssex+"</span></td>"+

			"</tr>"+
			"<tr>"+
				"<td><span style='margin-left: 80px;'>班级</span></td>"+

				"<td><span style='margin-left: 20px;'>"+data.clazz.cname+"</span></td>"+
				"<td><span style='margin-left: 60px;'>联系电话</span></td>"+

				"<td><span style='margin-left: 20px;'>"+data.telphone+"</span></td>"+
			"</tr>"+
			"<tr>"+
				"<td><span style='margin-left: 80px;'>房间</span></td>"+

				"<td><span style='margin-left: 20px;'>"+data.dorm.daddress+"</span></td>"+
				"<td><span style='margin-left: 60px;'>入住时间</span></td>"+

				"<td><span style='margin-left: 20px;'>"+data.sdate+"</span></td>"+
			"</tr>"+ 

		"</table>";
			
				$("#myshow").html(content);
			}
		
		});	
}
function changeroom() {
	 $.ajax({
			url : '../student/show',
			type : 'post',
			data : {
				"sid" : $("#myid").val()
			},
			success : function(data) {
				var content="";
				content+=
				"<table>"+

				"<tr>"+
					"<td><span style='margin-left: 100px;'>姓名</span></td>"+
					"<td><span style='margin-left: 20px;'>"+data.sname+"</span></td>"+
					"<td><span style='margin-left: 100px;'>性别</span></td>"+
					"<td><span style='margin-left: 20px;'>"+data.ssex+"</span></td>"+
				"</tr>"+

				"<tr>"+
					"<td><span style='margin-left: 100px;'>班级</span></td>"+
					"<td><span style='margin-left: 20px;'>"+data.clazz.cname+"</span></td>"+
					"<td><span style='margin-left: 100px;'>原房间</span></td>"+
					"<td><span style='margin-left: 20px;' id='oldroom'>"+data.dorm.daddress+"</td>"+
				"</tr>"+
				"<tr>"+
					"<td><span style='margin-left: 100px;'>新房间</span></td>"+
					"<div>"+
						"<td id='newroom'><select style='margin-left: 20px;'>"+
							"<option>正常</option>"+
							"<option>设施损坏</option>"+
					"</select></td>"+
					"</div>"+
				"</tr>"+

			"</table>";
				$("#change").html(content);
				newdorm();
				
			}
		
		});	
}
function newdorm() {
	 $.ajax({
			url : '../dorm/total',
			type : 'post',
			data : {
				
			},
			success : function(data) {
			
				var oldroom=$("#oldroom").html();
		
			var content = "";
				content+="<select style='margin-left: 20px;' name='dorm.daddress' id='daddressdorm' >";
				for(var i =0;i<data.length;i++){
					if(data[i].daddress!=oldroom)
					content+="<option>"+data[i].daddress+"</option>";
				
				}
				content+="</select>";
				$("#newroom").html(content);
			}
		
		});	
}
	function changedrom () {
	
		 $.ajax({
				url : '../student/change',
				type : 'post',
				data : {
					"sid" : $("#myid").val(),
					"dorm.daddress" : $("#daddressdorm").val()
				},
				success : function(data) {
					changeroom();
					var current=$("#currentpage").html();
					var currentPage=parseInt(current);
					all(currentPage);
			
				}
			
			});	
		
	}
	
function select() {
	
	 $.ajax({
			url : '../student/select',
			type : 'post',
			data : {
				"sname" : $("#thisname").val(),
				"dorm.daddress" : $("#thisdorm").val(),
				"clazz.cname" : $("#thisclazz").val()
			},
			success : function(data) {
				var content = "";
				content+="	<table class='table table-striped table-hover table-bordered'>"+
				"<thead>"+
					"<tr>"+
						"<th>学生姓名</th>"+
						"<th>性别</th>"+
						"<th>班级</th>"+
						"<th>所在房间</th>"+
						"<th>联系电话</th>"+
						
					"</tr>"+
				"</thead>";	
				for(var i=0;i<data.length;i++){
					content+="<tr onclick='myclick("+data[i].sid+")'>"+
						"<td>"+data[i].sname+"</td>"+
						"<td>"+data[i].ssex+"</td>"+
						"<td>"+data[i].clazz.cname+"</td>"+
						"<td>"+data[i].dorm.daddress+"</td>"+
						"<td>"+data[i].telphone+"</td>"+
					"</tr>";
				}
				content+="</table>";
				$("#allstudent").html(content);
			}
		
		});	
}
	



		</script>

</head>

<body>
	<input type="hidden" id="myid">
	<div class="modal fade" id="myModa2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h5 class="modal-title" id="myModalLabel"
						style="text-align: center;">学生退房</h5>
				</div>
				<div class="modal-body">
					<font size="6" color="#11B6B6" style="margin-left: 200px;">确定要退房吗？</font>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="sdelete()">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h6 class="modal-title" id="myModalLabel"
						style="text-align: center;">学生添加</h6>
				</div>
				<form action="../student/add" enctype="multipart/form-data" method="post">
					<div class="modal-body">

						<table>
							<tr>
								<td><span style="margin-left: 80px;">姓名</span></td>

								<td><input type="text" name="sname"
									style="margin-left: 20px;"></td>
								<td><span style="margin-left: 60px;">选择头像</span></td>

								<td><input type="file" name="img"
									style="margin-left: 20px;"></td>
							</tr>
							<tr>
								<td><span style="margin-left: 80px;">性别</span></td>

								<td><span style="margin-left: 20px;" >男</span> <input
									type="radio" value="男" name="ssex" checked="checked" onclick="man()" > 女 <input
									type="radio" value="女" name="ssex" onclick="woman()"></td>
								<td></td>

							</tr>
							<tr>
								<td><span style="margin-left: 80px;">班级</span></td>
								<td id="myclazz"></td>


								<td></td>


							</tr>
							<tr>
								<td><span style="margin-left: 80px;">房间</span></td>

								<td id="mydorm"></td>
								<td><span style="margin-left: 60px;">联系电话</span></td>

								<td><input type="text" name="telphone"
									style="margin-left: 20px;"></td>
							</tr>
							<tr>
								<td><span style="margin-left: 80px;">入住时间</span></td>

						


								<td><input type="date" name="sdate"
									style="margin-left: 20px;"></td>
							</tr>
						</table>

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="提交" />
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModa3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h6 class="modal-title" id="myModalLabel"
						style="text-align: center;">学生信息一览</h6>
				</div>

				<div class="modal-body" id="myshow">

			



				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div class="modal fade" id="myModa4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h6 class="modal-title" id="myModalLabel"
						style="text-align: center;">学生换房</h6>
				</div>

				<div class="modal-body" id="change">
				
			




				</div>

				<div class="modal-footer">

					<button class="btn btn-primary" onclick="changedrom()">确定</button>

					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>

				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>







	<div class="top"></div>
	<div id="header">
		<div class="logo">宿舍后台管理系统</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><shiro:principal /></li>
				<li><a href="">修改密码</a></li>
				<li><a href="">设置</a></li>
				<li><a href="../logout">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
			
						<shiro:hasRole name="user">
				<li>
						<h4 class="M1">
							<span></span>资料管理
						</h4>
						<div class="list-item none">
							<a href="student.jsp" onclick="clzz()">学生管理</a>
							 <a href='nightfall.jsp'>夜归管理</a>
							<shiro:hasRole name="admin">
							 <a href='clazz.jsp'>班级管理</a>
							</shiro:hasRole>	
						</div>
					</li>
					</shiro:hasRole>
			
				
				<shiro:hasRole name="user">
					<li>
						<h4 class="M1">
							<span></span>房间管理
						</h4>
						<div class="list-item none">
							<a href='room.jsp'>房间信息</a>

						</div>
					</li>
				</shiro:hasRole>
			</ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
				<ul>
					<li><img src="../images/home.png"></li>
					<li style="margin-left: 25px;">您当前的位置：</li>
					<li><a href="#">资料管理</a></li>
					<li>></li>
					<li><a href="#">学生管理</a></li>
				</ul>
			</div>
			<div class="main">

				<div id="allstudent"
					style="width: 90%; margin-left: 5%; overflow-y: scroll; height: 300px; overflow-y: scroll; border: 1px; border-style: solid;">

				</div>

				<div style="width: 50%; float: left;">
					<nav aria-label="Page navigation" style="margin-left: 15%;">
						<ul class="pagination">
							<li><a href="#" onclick="firstpage()">首页</a></li>
							<li><a href="#" aria-label="Previous" onclick="prepage()">
									<span aria-hidden="true">&laquo;</span>
							</a></li>

							<li><a href="#" id="currentpage">0</a></li>

							<li><a href="#">/</a></li>
							<li><a href="#" id="totalpage">4</a></li>

							<li><a href="#" aria-label="Next" onclick="nextpage()">
									<span aria-hidden="true">&raquo;</span>
							</a></li>
							<li><a href="#" onclick="endpage()">尾页</a></li>
						</ul>
					</nav>
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModal" style="margin-left: 15%;">学生入住</button>
					<!-- 模态框（Modal） -->

					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModa2" style="margin-left: 15%;" >学生退房</button>
					<!-- 模态框（Modal） -->
					</br> </br> </br>
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModa3" style="margin-left: 15%;" onclick="show()">学生信息</button>
					<!-- 模态框（Modal） -->

					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModa4" style="margin-left: 15%;" onclick="changeroom()">学生换房</button>
					<!-- 模态框（Modal） -->

				</div>
				<div style="width: 40%; float: left; margin-top: 30px;">
					查询学生信息
					
						<table class="table table-bordered">
							<tr>
								<td>学生姓名</td>
								<td><input type="text" id="thisname"></td>
							</tr>
							<tr>
								<td>班级</td>
								<td><input type="text" id="thisclazz"></td>
							</tr>
							<tr>
								<td>所在房间</td>
								<td><input type="text" id="thisdorm"></td>
							</tr>


						</table>
						
						<button class="btn btn-primary" onclick="select()">提交</button>
						
				</div>

			</div>
		</div>
	</div>

	<script>
			navList(12);
		</script>
</body>

</html>
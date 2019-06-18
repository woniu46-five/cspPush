<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<script src="../js/jquery.min.js"></script>

<script src="../js/menu.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/style.css">
</head>

<body>
		

	<div class="modal fade" id="myModa2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h5 class="modal-title" id="myModalLabel"
						style="text-align: center;">班级删除</h5>
				</div>
				<div class="modal-body">
					<font size="6" color="#11B6B6" style="margin-left: 200px;">确定要删除吗？</font>
				</div>
				
					<input type="hidden" id="myid" name="cid">
			
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="cdelete()">提交</button>
				
				</div>
					
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h6 class="modal-title" id="myModalLabel"
						style="text-align: center;">班级添加</h6>
				</div>
					<form action="../clazz/add">
					<div class="modal-body">

						<table>
							<tr>
								<td><span style="margin-left: 100px;">班级名称</span></td>

								<td><input type="text" name="cname"
									style="margin-left: 100px;"></td>
							</tr>
							<tr>
								<td><span style="margin-left: 100px;">带班老师</span></td>

								<td id="myteacher"></td>
							</tr>
							<tr>
								<td><span style="margin-left: 100px;">开班时间</span></td>

								<td><input type="date" name="cdate"
									style="margin-left: 100px;"></td>
							</tr>
						</table>

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					
						<input type="submit"  class="btn btn-primary"  value="确定">
						
						
					</div>
				</form>
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
					<li><a href="#">班级管理</a></li>
				</ul>
			</div>
			<div class="main">

				<div id="myclazz"
					style="width: 80%; margin-left: 10%; margin-left: 10%; overflow-y: scroll; height: 300px; overflow-y: scroll; border: 1px; border-style: solid;">

				</div>
				<nav aria-label="Page navigation" style="margin-left: 10%;">
					<ul class="pagination">
						<li><a href="#" onclick="firstpage()">首页</a></li>
						<li><a href="#" aria-label="Previous" onclick="prepage()">
								<span aria-hidden="true">&laquo;</span>
						</a></li>

						<li><a href="#" id="currentpage">0</a></li>

						<li><a href="#">/</a></li>
						<li><a href="#" id="totalpage">4</a></li>

						<li><a href="#" aria-label="Next" onclick="nextpage()"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
						<li><a href="#" onclick="endpage()">尾页</a></li>
					</ul>
				</nav>

				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModal" style="margin-left: 30%;">添加班级</button>
				<!-- 模态框（Modal） -->

				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModa2" style="margin-left: 30%;">删除班级</button>
				<!-- 模态框（Modal） -->



			</div>
		</div>
	</div>

	<script>
			navList(12);
		</script>
	<script type="text/javascript">
	 function allteacher() {
		 $.ajax({
				url : '../teacher/all',
				type : 'post',
				data : {
					
				},
				success : function(data) {
					var content = "";
					content+="<select style='margin-left: 100px;' name='tname' >";
					for(var i =0;i<data.length;i++){
						content+="<option>"+data[i].tname+"</option>";
					}
					content+="</select>";
					$("#myteacher").html(content);
				}
			
			});	
	}
allteacher();
	

		function all(page) {

			$.ajax({
				url : '../clazz/all',
				type : 'post',
				data : {
					"currentpage" : page,
					"count" : 2
				},
				success : function(data) {
				var content = "";
				content+="<table class='table table-striped table-hover table-bordered'>"+
				"<thead>"+
					"<tr>"+
						"<th>班级名称</th>"+
						"<th>开班时间</th>"+
						"<th>代班老师</th>"+
					"</tr>"+
				"</thead>";
				for(var i =0;i<data.length;i++){
						var clazz = data[i];
				
						content+="	<tr onclick='myclick("+data[i].cid+")'>"+
						"<td>"+clazz.cname+"</td>"+
						"<td>"+clazz.cdate+"</td>"+
						"<td>"+clazz.teachers.tname+"</td>"+	
						
						"</tr>";
				}
				content+="</table>";
				$("#currentpage").html(page);
				$("#myclazz").html(content);
				}
			
			});
		}
all(1);
	
 function allpage() {
	 $.ajax({
			url : '../clazz/allpage',
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

function myclick(id) {
	alert(id);
	$("#myid").val(id);
}

function cdelete() {
	
	 $.ajax({
			url : '../clazz/delete',
			type : 'post',
			data : {
				"cid" : $("#myid").val()
			},
			success : function(data) {
				if(data==null||data.length<1){
					window.location.reload();
				}
				else{
					$('#myModa2').modal('hide');
					alert(data);
				}
			
				
			}
		
		});	
}


	</script>
</body>

</html>
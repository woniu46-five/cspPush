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
			$(document).on('show.bs.modal', '.modal', function(event) {
				$(this).appendTo($('body'));
			}).on('shown.bs.modal', '.modal.in', function(event) {
				setModalsAndBackdropsOrder();
			}).on('hidden.bs.modal', '.modal', function(event) {
				setModalsAndBackdropsOrder();
			});

			function setModalsAndBackdropsOrder() {
				var modalZIndex = 1040;
				$('.modal.in').each(function(index) {
					var $modal = $(this);
					modalZIndex++;
					$modal.css('zIndex', modalZIndex);
					$modal.next('.modal-backdrop.in').addClass('hidden').css('zIndex', modalZIndex - 1);
				});
				$('.modal.in:visible:last').focus().next('.modal-backdrop.in').removeClass('hidden');
			}
			

			function all(page) {

				$.ajax({
					url : '../dorm/all',
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
							"<th>房间地址</th>"+
							"<th>可容纳人数</th>"+
							"<th>已住人数</th>"+
							"<th>房租</th>"+
							"<th>房间状态</th>"+
							"<th>房东</th>"+
							"<th>房东电话</th>"+
							"<th>房间类型</th>"+
							
						"</tr>"+
					"</thead>";
					for(var i =0;i<data.length;i++){
							var dorm = data[i];
						
						
							content+="	<tr onclick='myclick("+data[i].did+")'>"+
							"<td>"+dorm.daddress+"</td>"+
							"<td>"+dorm.dcount+"</td>"+
							"<td>"+dorm.students.length+"</td>"+	
							"<td>"+dorm.houseowner.hprice+"</td>";
						
							if(dorm.breakdowns==null||dorm.breakdowns.length<1){
								content+="<td>正常</td>";
							}
							else
								{
							
								var exits =true;
								for(var j=0;j<dorm.breakdowns.length;j++){
									
									if(dorm.breakdowns[j].flag==0){
										exits=false;
									}
								}
								if(exits==true){
									
									content+="<td>正常</td>";
								}
								else
								{
									
									content+="<td>设施损坏</td>";
								}
								}
							
							content+=	
							"<td>"+dorm.houseowner.hname+"</td>"+
							"<td>"+dorm.houseowner.htelphone+"</td>"+
							"<td>"+dorm.type.typename+"</td>"+
							
							"</tr>";
					}
					content+="</table>";
					$("#currentpage").html(page);
					$("#mydorm").html(content);
					}
				
				});
			}
	all(1);
	
	 function allpage() {
		 $.ajax({
				url : '../dorm/allpage',
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
	
		
		function rdelete() {
			
			 $.ajax({
					url : '../dorm/delete',
					type : 'post',
					data : {
						"did" : $("#myid").val()
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
		function myclick(id) {
			alert(id);
			$("#myid").val(id);
		}
		function mytest(id) {
			alert(id);
			$("#myid2").val(id);
		}
		function show() {
			 $.ajax({
					url : '../dorm/show',
					type : 'post',
					data : {
						"did" : $("#myid").val()
					},
					success : function(data) {
						
						var content1 ="";
						
						content1+="<table>"+
						"<tr>"+
						"<td><span style='margin-left: 80px;'>房间地址</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.daddress+"</span></td>"+
						"<td><span style='margin-left: 60px;'>房间户型</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.unit.uname+"</span></td>"+
					"</tr>"+
					"<tr>"+
						"<td><span style='margin-left: 80px;'>可容纳人数</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.dcount+"</span></td>"+
						"<td><span style='margin-left: 60px;'>已住人数</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.students.length+"</span></td>"+
					"</tr>"+
					"<tr>"+
						"<td><span style='margin-left: 80px;'>房租</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.houseowner.hprice+"</span></td>"+
						"<td><span style='margin-left: 60px;'>支付方式</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.houseowner.hmtype+"</span></td>"+
					"</tr>"+
					"<tr>"+
						"<td><span style='margin-left: 80px;'>房东</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.houseowner.hname+"</span></td>"+
						"<td><span style='margin-left: 60px;'>房东电话</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.houseowner.htelphone+"</span></td>"+
					"</tr>"+
					"<tr>"+
						"<td><span style='margin-left: 80px;'>房间状态</span></td>";
						
						if(data.breakdowns==null||data.breakdowns.length<1){
							content1+="<td><span style='margin-left: 20px;'>正常</span></td>";
						}
						else
							{
							
							var exits =true;
							for(var i=0;i<data.breakdowns.length;i++){
								if(data.breakdowns[i].flag==0){
									exits=false;
								}
							}
							if(exits==true){
								
								content1+="<td><span style='margin-left: 20px;'>正常</span></td>";
							}
							else{
								
								content1+="<td><span style='margin-left: 20px;'>设施损坏</span></td>";
							}
							}
						
						
						
						content1+="<td><span style='margin-left: 60px;'>房间类型</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.type.typename+"</span></td>"+
					"</tr>"+
					"<tr>"+
						"<td><span style='margin-left: 80px;'>租房日期</span></td>"+

						"<td><span style='margin-left: 20px;'>"+data.houseowner.hdate+"</span></td>"+
					"</tr>"+
				"</table>";
					
						
						if(data.students.length>0){
						content1+=
							"<div  style='width: 80%; height: 200px; overflow-y: scroll; '>"+

						
						
							"<table class='table table-striped table-hover table-bordered' style='margin-left: 10%; width: 90%;'>"+
							"<thead>"+
								"<tr>"+
								"<th>学生姓名</th>"+
									"<th>所在班级</th>"+
									"<th>联系电话</th>"+
								"</tr>"+
							"</thead>";
						}
						for(var i=0;i<data.students.length;i++){
							content1+=
							"<tr>"+
								"<td>"+data.students[i].sname+"</td>"+
								"<td>"+data.students[i].clazz.cname+"</td>"+
								"<td>"+data.students[i].telphone+"</td>"+
							"</tr>";
						
					
						}
						if(data.students.length>0){
							content1+="	</table>"+
							"</div>";
						}
						
					
						$("#mydiv1").html(content1);
						
					}
				
				});	
		}
		function facility() {
			
			 $.ajax({
					url : '../dorm/show',
					type : 'post',
					data : {
						"did" : $("#myid").val()
					},
					success : function(data) {
						var content="";
						if(data.breakdowns.length>0){
						content+="<div style='width: 100%; height: 150px; overflow-y: scroll; '>"+
						"<table class='table table-striped table-hover table-bordered'>"+
						"<thead>"+
							"<tr>"+
								"<td>损坏描述</td>"+
								"<td>损坏日期</td>"+
								"<td>是否解决</td>"+
							"</tr>"+
						"</thead>";
						}
						
						for(var i=0;i<data.breakdowns.length;i++) {
							content+="<tr onclick='mytest("+data.breakdowns[i].bid+")'>"+
								"<td>"+data.breakdowns[i].bdescription+"</td>"+
								"<td>"+data.breakdowns[i].bdate+"</td>";
								if(data.breakdowns[i].flag==0){
									content+="<td>未解决</td>";
								}
								else{
									content+="<td>以解决</td>";
								}
								
								content+="</tr>";
						}
						if(data.breakdowns.length>0){
							content+="</table>";
						}
					
						
						$("#mybreakdown").html(content);
					}
				
				});	
		}
		
		function addbreak() {
			
			 $.ajax({
					url : '../dorm/addbreak',
					type : 'post',
					data : {
						"did" : $("#myid").val(),
						"bdate":$("#bdate").val(),
						"bdescription":$("#bdescription").val()
						
					},
					success : function(data) {
						facility();
						var current=$("#currentpage").html();
						var currentPage=parseInt(current);
						all(currentPage);
						
					}
				
				});	
		}
		function rbreak() {
			
			 $.ajax({
					url : '../dorm/rbreak',
					type : 'post',
					data : {
						"bid" : $("#myid2").val(),
						
						
					},
					success : function(data) {
						facility();
						var current=$("#currentpage").html();
						var currentPage=parseInt(current);
						all(currentPage);
						$('#myModa5').modal('hide');
					}
				
				});	
		}
		function select() {
		
			 $.ajax({
					url : '../dorm/select',
					type : 'post',
					data : {
						"address" : $("#address").val(),
						"breakdowns":$("#breakdowns").val(),
						"personal":$("#personal").val(),
						"dormtype":$("#dormtype").val()
						
					},
					success : function(data) {
						var content = "";
						content+="<table class='table table-striped table-hover table-bordered'>"+
						"<thead>"+
							"<tr>"+
								"<th>房间地址</th>"+
								"<th>可容纳人数</th>"+
								"<th>已住人数</th>"+
								"<th>房租</th>"+
								"<th>房间状态</th>"+
								"<th>房东</th>"+
								"<th>房东电话</th>"+
								"<th>房间类型</th>"+
								
							"</tr>"+
						"</thead>";
						for(var i =0;i<data.length;i++){
								var dorm = data[i];
							
							
								content+="	<tr onclick='myclick("+data[i].did+")'>"+
								"<td>"+dorm.daddress+"</td>"+
								"<td>"+dorm.dcount+"</td>"+
								"<td>"+dorm.students.length+"</td>"+	
								"<td>"+dorm.houseowner.hprice+"</td>";
							
								if(dorm.breakdowns==null||dorm.breakdowns.length<1){
									content+="<td>正常</td>";
								}
								else
									{
								
									var exits =true;
									for(var j=0;j<dorm.breakdowns.length;j++){
										
										if(dorm.breakdowns[j].flag==0){
											exits=false;
										}
									}
									if(exits==true){
										
										content+="<td>正常</td>";
									}
									else
									{
										
										content+="<td>设施损坏</td>";
									}
									}
								
								content+=	
								"<td>"+dorm.houseowner.hname+"</td>"+
								"<td>"+dorm.houseowner.htelphone+"</td>"+
								"<td>"+dorm.type.typename+"</td>"+
								
								"</tr>";
						}
						content+="</table>";
						
						$("#mydorm").html(content);
						
					}
				
				});	
		}
		
		
		
			
			
		</script>
	</head>

	<body>

		<div class="modal fade" id="myModa2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h5 class="modal-title" id="myModalLabel" style="text-align: center;">房间删除</h5>
					</div>
					<div class="modal-body">
						<font size="6" color="#11B6B6" style="margin-left: 200px;">确定要删除吗？</font>
							<input type="hidden" id="myid" name="cid">
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="rdelete()">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h6 class="modal-title" id="myModalLabel" style="text-align: center;">房间添加</h6>
					</div>
					<form action="../dorm/add">
						<div class="modal-body">

							<table>
								<tr>
									<td><span style="margin-left: 80px;">房间地址</span></td>

									<td><input type="text" name="daddress" style="margin-left: 20px;" ></td>
									<td><span style="margin-left: 60px;">房间户型</span></td>

									<td><select style="margin-left: 20px;" name="unit.uname">
											<option>一室一厅</option>
											<option>二室一厅</option>
											<option>三室一厅</option>
											<option>二室二厅</option>
										</select></td>
								</tr>
								<tr>
									<td><span style="margin-left: 80px;" >可容纳人数</span></td>

									<td><input type="text" name="dcount" style="margin-left: 20px;"></td>
									<td><span style="margin-left: 60px;">房间类型</span></td>

									<td>
										<select style="margin-left: 20px;" name="type.typename">
											<option>男生宿舍</option>
											<option>女生宿舍</option>
										</select>
									</td>
								</tr>
								<tr>
									<td><span style="margin-left: 80px;">房租</span></td>

									<td><input type="text" name="houseowner.hprice" style="margin-left: 20px;"></td>
									<td><span style="margin-left: 60px;">支付方式</span></td>

									<td><input type="text" name="houseowner.hmtype" style="margin-left: 20px;"></td>
								</tr>
								<tr>
									<td><span style="margin-left: 80px;">房东</span></td>

									<td><input type="text" name="houseowner.hname" style="margin-left: 20px;"></td>
									<td><span style="margin-left: 60px;">房东电话</span></td>

									<td><input type="text" name="houseowner.htelphone" style="margin-left: 20px;"></td>
								</tr>
								<tr>
									<td><span style="margin-left: 80px;">房间状态</span></td>

									<td>
										<select style="margin-left: 20px;" >
											<option>正常</option>
											<option>设施损坏</option>
										</select>
									</td>
									<td><span style="margin-left: 60px;">租房日期</span></td>

									<td><input type="date" name="houseowner.hdate" style="margin-left: 20px;"></td>
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
		<div class="modal fade" id="myModa3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h6 class="modal-title" id="myModalLabel" style="text-align: center;">房间信息查看</h6>
					</div>

					<div id="mydiv1" class="modal-body">
						

					

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

					</div>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<div class="modal fade" id="myModa4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h6 class="modal-title" id="myModalLabel" style="text-align: center;">班级添加</h6>
					</div>

					<div class="modal-body">
					<div id="mybreakdown">
					
						</div>
						损坏日期：<input type="date" id="bdate" /><br />
						损坏描述：<textarea rows="2" cols="20" id="bdescription"></textarea>
						
						
						

					</div>

					<div class="modal-footer">
					
						<button type="button" class="btn btn-primary" onclick="addbreak()">添加设施损坏记录</button>
						<button class="btn btn-primary" data-toggle="modal" data-target="#myModa5" style="margin-left: 15%;margin-right: 15%; ">处理已损坏设施</button>
						<!-- 模态框（Modal） -->
						<button type="button" class="btn btn-primary" data-dismiss="modal"  >关闭</button>
						
					</div>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		
		
		
		<div class="modal fade" id="myModa5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h5 class="modal-title" id="myModalLabel" style="text-align: center;">维修设施</h5>
					</div>
					<div class="modal-body">
						<font size="5" color="#11B6B6" style="margin-left: 200px;">房间设施真的维修好了吗？</font>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="rbreak()">确定</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		
		
		
		<input type="hidden" id="myid2">
		<div class="top"></div>
		<div id="header">
			<div class="logo">宿舍后台管理系统</div>
			<div class="navigation">
				<ul>
					<li>欢迎您！</li>
				
					<li><shiro:principal /></li>
				
					<li>
						<a href="">修改密码</a>
					</li>
					<li>
						<a href="">设置</a>
					</li>
					<li>
						<a href="../logout">退出</a>
					</li>
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
						<li style="margin-left:25px;">您当前的位置：</li>
						<li>
							<a href="#">房间管理</a>
						</li>
						<li>></li>
						<li>
							<a href="#">房间信息</a>
						</li>
					</ul>
				</div>
				<div class="main">

					<div id="mydorm" style="width: 90%; margin-left:5%; overflow-y: scroll;height: 300px; overflow-y: scroll; border: 1px; border-style: solid ;">

						
					</div>

					<div style="width: 50%; float: left;">
						<nav aria-label="Page navigation" style="margin-left: 15%;">
							<ul class="pagination">
								<li>
									<a href="#" onclick="firstpage()">首页</a>
								</li>
								<li>
									<a href="#" aria-label="Previous" onclick="prepage()">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>

								<li>
									<a href="#" id="currentpage">0</a>
								</li>

								<li>
									<a href="#">/</a>
								</li>
								<li>
									<a href="#" id="totalpage">4</a>
								</li>

								<li>
									<a href="#" aria-label="Next" onclick="nextpage()"> <span aria-hidden="true">&raquo;</span>
									</a>
								</li>
								<li>
									<a href="#" onclick="endpage()">尾页</a>
								</li>
							</ul>
						</nav>
						<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="margin-left: 15%;">&nbsp;&nbsp;&nbsp;添加房间&nbsp;&nbsp;&nbsp;</button>
						<!-- 模态框（Modal） -->

						<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModa2" style="margin-left: 15%;">&nbsp;&nbsp;&nbsp;删除房间&nbsp;&nbsp;&nbsp;</button>
						<!-- 模态框（Modal） -->
						</br>
						</br>
						</br>
						<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModa3" style="margin-left: 15%;" onclick="show()">查看房间信息</button>
						<!-- 模态框（Modal） -->

						<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModa4" style="margin-left: 15%; " onclick="facility()">查看房间设施</button>
						<!-- 模态框（Modal） -->

					</div>
					<div style="width: 40%; float:  left; margin-top: 30px;">
						查询房间信息
						
							<table class="table table-bordered">
								<tr>
									<td>房间地址</td>
									<td><input type="text" name="address" id="address"></td>
								</tr>
								<tr>
									<td>房间状态</td>
									<td>
										<select name="breakdowns" id="breakdowns">
											<option>不限</option>
											<option>正常</option>
											<option>设施损坏</option>
										</select>
									</td>
								</tr>
									
								<tr>
									<td>可住房间</td>
									<td>
										<select name="personal" id="personal">
											<option>不限</option>
											<option>可住房间</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>房间类型</td>
									<td>
										<select name="dormtype" id="dormtype">
											<option>不限</option>
											<option>男生宿舍</option>
											<option>女生宿舍</option>
										</select>
									</td>
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
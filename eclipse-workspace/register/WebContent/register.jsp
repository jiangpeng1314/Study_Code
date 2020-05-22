<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		var username=false;
		var password=false;
		var passwordSure=false;
		//check username
		$(":text:eq(0)").blur(function(){
			if($(this).val()==""){
				$(this).next().css("color","red").html("X");
				username=false;
			}else{
				$(this).next().css("color","green").html("√");
				username=true;
			}
		});
		//check password
		$(":password:eq(0)").blur(function(){
			if(!$(this).val().match(/^\w{6,12}/)){
				$(this).next().css("color","red").html("X");
				password=false;
			}else{
				$(this).next().css("color","green").html("√");
				password=true;
			}
		});
		//sure password
		$(":password:eq(1)").blur(function(){
			if($(this).val()==""||$(this).val()!=$(":password:eq(0)").val()){
				$(this).next().css("color","red").html("X");
				passwordSure=false;
			}else{
				$(this).next().css("color","green").html("√");
				passwordSure=true;
			}
		});
		//
		$(":submit").click(function(){
			if(username==false||password==false||passwordSure==false||$(":file").val()==""){
				alert("请添加完整信息");
				return false;
			}
		})
		
		
		
		
	})
</script>
</head>
<body>
<form action="register" method="post" enctype="multipart/form-data">
	用户名:<input type="text" name="username" ><span></span><br/>
	密码:<input type="password" name="password"><span></span><br/>
	确认密码:<input type="password" name="passwordSure"><span></span><br/>
	头像:<input type="file" name="file"><br/>
	<input type="submit" value="注册">
</form>
</body>
</html>
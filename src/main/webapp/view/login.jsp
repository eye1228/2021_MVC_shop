<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div#mydiv{
		text-align: center;
		border: 1px solid; 
		padding:10px;
		width:400px;
		
	}
	table,div{
		margin:20px auto;
	}
</style>
<script type="text/javascript">
	function login_go(f){
		
		if(f.id.value==""|| f.pw.value==""){
			alert("id 혹은 패스워드를 입력하세요.");
			f.id.value="";
			f.pw.value="";
			f.id.focus();
			return;
		}	
		f.action = "/MyController?cmd=login_ok";
		f.submit();
	}
	function join_go(f){
		alert("회원가입합니다.");
		f.action = "/MyController?cmd=join_ok";
		f.submit();
	}
</script>
</head>
<body>
	<%@ include file="top.jsp" %>
	
	<div id="mydiv">	

		
		<form method="post">
			<fieldset>
			<legend><h2>Login</h2></legend>
			<table>
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="pw" ></td>
					</tr>
				</tbody>			
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="로그인" onclick="login_go(this.form)">
							<input type="button" value="회원가입" onclick="join_go(this.form)">
						</td>
					</tr>
				</tfoot>
			</table>
			</fieldset>
		</form>
	</div>
	
	
</body>
</html>
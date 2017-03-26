<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.8.18.custom.min.js"></script>
<link href="jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
	$(function(){
		$("#birthday").datepicker({
			minDate: new Date(1980, 0, 01),
			maxDate: new Date(2020, 11, 31),
			yearRange :'-40:+30',
			changeMonth: true,
			changeYear: true,
			dateFormat: 'yy-mm-dd'
		});
	});
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户添加页面</title>
</head>
<body>

<%
	String token = UUID.randomUUID().toString();
	session.setAttribute("token_session", token);
 %>
	<h3>客户添加页面</h3>
	<hr/>
	<form action='${pageContext.request.contextPath }/add' method='post'>
		<table>
			<tr>
				<td>姓名:</td>
				<td>
					<input type='text' name='name' >
				</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<input type="radio" name="gender" value="男">男
					<input type="radio" name="gender" value="女">女
				</td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td>
					<input type="text" name="birthday" id="birthday">
				</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>电话:</td>
				<td>
					<input type="text" name="cellphone">
				</td>
			</tr>
			<tr>
				<td>爱好:</td>
				<td>
					<input type="hidden" name="token" value="${token_session }">
					<input type="checkbox" name="preference" value="打球">打球
					<input type="checkbox" name="preference" value="学习">学习
					<input type="checkbox" name="preference" value="睡觉">睡觉
				</td>
			</tr>
			<tr>
				<td>类型:</td>
				<td>
					<select name="type">
						<option value="普通客户">普通客户</option>
						<option value="超级会员">超级会员</option>
						<option value="钻石会员">钻石会员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>个人简历:</td>			
				<td>
					<textarea rows="5" cols="30" name="description" style="resize:none">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户个人信息</title>
</head>
<body>


	<h3>客户个人信息</h3>
	<hr/>
	<form action='${pageContext.request.contextPath }/update' method='post'>
		<table>
			<tr>
				<td>姓名:</td>
				<td>
					<input type="hidden" name="id" value="${customerinfo.id }">
					<input type='text' name='name' value="${customerinfo.name }">
				</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<input type="radio" name="gender" value="男" 
						<c:if test="${customerinfo.gender=='男' }">
							checked="checked"
						</c:if>
					>男
					<input type="radio" name="gender" value="女"
						<c:if test="${customerinfo.gender=='女' }">
							checked="checked"
						</c:if>
					>女
				</td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td>
					<input type="text" name="birthday" id="birthday" value="${customerinfo.birthday }">
				</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>
					<input type="text" name="email" value="${customerinfo.email}">
				</td>
			</tr>
			<tr>
				<td>电话:</td>
				<td>
					<input type="text" name="cellphone" value="${customerinfo.cellphone }">
				</td>
			</tr>
			<tr>
				<td>爱好:</td>
				<td>
					<input type="checkbox" name="preference" value="打球" 
						<c:if test="${fn:contains(customerinfo.preference,'打球') }">
							checked="checked"
						</c:if>	
					>打球
					
					<input type="checkbox" name="preference" value="学习"
						<c:if test="${fn:contains(customerinfo.preference,'学习') }">
							checked="checked"
						</c:if>	
					>学习
					<input type="checkbox" name="preference" value="睡觉"
						<c:if test="${fn:contains(customerinfo.preference,'睡觉') }">
							checked="checked"
						</c:if>	
					>睡觉
				</td>
			</tr>
			<tr>
				<td>类型:</td>
				<td>
					<select name="type">
						<option value="普通客户" 
							<c:if test="${customerinfo.type=='普通客户' }">
								selected="selected"
							</c:if>
						>普通客户</option>
						<option value="超级会员"
							<c:if test="${customerinfo.type=='超级会员' }">
								selected="selected"
							</c:if>
						>超级会员</option>
						<option value="钻石会员"
							<c:if test="${customerinfo.type=='钻石会员' }">
								selected="selected"
							</c:if>
						>钻石会员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>个人简历:</td>			
				<td>
					<textarea rows="5" cols="30" name="description" style="resize:none">
					${customerinfo.description }
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="确定">
				</td>
			</tr>
		</table>
	</form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isDelete(id){
		var isconfirm =window.confirm("你确定要删除?");
		if(isconfirm){
			location.href="${pageContext.request.contextPath }/deleteOne?id="+id;
		}
		
	}
	//确认全选
	function checkAll(){
		var checkbtn =document.getElementById("checkbtn");
		var checkbtns =document.getElementsByName("checkbtns");
		for(var i=0;i<checkbtns.length;i++){
			checkbtns[i].checked = checkbtn.checked;
		}
	}
	
</script>
</head>
	<!--将用户列表从request域中取出显示所有用户的界面，需要进行判断
		1.如果返回的list为空，则反馈友好信息
		2.如果有则将全部信息反馈给客户
	  -->
<body>

	<c:if test="${empty customers }">
		对不起，没有任何客户信息
	</c:if>
	<c:if test="${not empty customers }">
		<h3 align="center">客户信息表</h3>
		<form action="${pageContext.request.contextPath }/conditionquery" method="post" align="center">
			请选择查询条件：
			<select name="conditionname">	
				<option  value="name">按姓名查找</option>	
				<option  value="cellphone">按手机查找</option>
				<option  value="birthday">按出生日期查找</option>
			</select>
			<input type="text" name="conditionvalue" >
			<input type="submit" value="查找">
		</form>
		<br/>
		<br/>
		<table align="center" border="1" >
			<tr>
				<th>
					<input type="checkbox"  id="checkbtn" onclick="checkAll();">全选
				</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>爱好</th>
				<th>类型</th>
				<th>个人简历</th>
				<th>操作</th>
			</tr>
				<c:forEach items="${customers }" var="customer">
			<tr>
					<td>
						<input type="checkbox" name="checkbtns">
					</td>
					<td>${customer.name }</td>					
					<td>${customer.gender }</td>
					<td>${customer.birthday }</td>
					<td>${customer.email }</td>
					<td>${customer.cellphone }</td>
					<td>${customer.preference }</td>
					<td>${customer.type }</td>
					<td>${customer.description }</td>
					<td>
						<button><a href="javascript:void(0)" onclick="isDelete('${customer.id}')">删除</a></button>
						<button><a href="${pageContext.request.contextPath }/getinfo?id=${customer.id}">更改</a></button>
					</td>
					
			</tr>
				</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/findAll?pageNum=1">首页</a>
		<c:if test="${bean.pageNum!=1 }">
			<a href="${pageContext.request.contextPath}/findAll?pageNum=${bean.pageNum-1}">上一页</a>
		</c:if>
		<!-- 左5右4 -->
		
		<c:forEach begin="${bean.pageNum-5>0?bean.pageNum-5:1 }" end="${bean.pageNum+4>bean.totalPageNum?bean.totalPageNum:bean.pageNum+4 }" var="i">
			<c:if test="${bean.pageNum!=i }">
 				<a href="${pageContext.request.contextPath }/findAll?pageNum=${i}">${i}</a>
			</c:if>
			<c:if test="${bean.pageNum==i }">
 				<font color="red">${i}</font>
			</c:if>
		</c:forEach> 
		<c:if test="${bean.pageNum!=bean.totalPageNum }">
			<a href="${pageContext.request.contextPath}/findAll?pageNum=${bean.pageNum+1}">下一页</a>
		</c:if>
		<a href="${pageContext.request.contextPath }/findAll?pageNum=${bean.totalPageNum}">尾页</a>
	</c:if>
	
</body>
</html>
package hhr.customer_system.web;

import hhr.customer_system.service.CustomerService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.处理乱码
 * 2.得到表单提交过来的id
 * 3.调用业务层处理
 * 4.重定向到查询页面
 */
@WebServlet("/deleteOne")
public class DeleteOneCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//得到用户的id
		String id = request.getParameter("id");
		
		//调用业务层进行处理
		CustomerService cs =new CustomerService();
		cs.delete(id);
		
		//将页面进行重定向
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

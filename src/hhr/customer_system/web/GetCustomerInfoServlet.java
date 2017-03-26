package hhr.customer_system.web;

import hhr.customer_system.domain.Customer;
import hhr.customer_system.service.CustomerService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.解决乱码
 * 2.得到用户的id
 * 3.调用业务层
 * 4.返回结果集进行处理
 */
@WebServlet("/getinfo")
public class GetCustomerInfoServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//得到用户的id并调用业务层
		String id = request.getParameter("id");
		CustomerService cs = new CustomerService();
		Customer customer =cs.query(id);
		
		//将list存放在request域中
		request.setAttribute("customerinfo",customer );
		//将页面跳转到用户的信息页面
		request.getRequestDispatcher("/info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

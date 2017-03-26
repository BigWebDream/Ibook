package hhr.customer_system.web;

import hhr.customer_system.domain.Customer;
import hhr.customer_system.domain.PageBean;
import hhr.customer_system.service.CustomerService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 查看所有用户的servlet
 * 1.解决乱码
 * 2.调用业务层逻辑
 * 3.返回一个list的结果将结果存放到request域中并返回到页面
 */
@WebServlet("/findAll")
public class FindCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获得提交过来的参数信息
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		//调用业务层
		CustomerService cs =new CustomerService();
		
		//得到返回的list结果并返回到页面
//		List<Customer> customers = cs.find();
		PageBean bean =cs.find(pageNum);
		//将查询到的结果放到request域中
		List<Customer> customers = bean.getCustomers();
		request.setAttribute("customers", customers);
		request.setAttribute("bean", bean);
		
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

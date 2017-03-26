package hhr.customer_system.web;

import hhr.customer_system.domain.Customer;
import hhr.customer_system.service.CustomerService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.处理乱码
 * 2.得到表单数据
 * 3.调用业务层
 * 4.将返回的结果集进行显示
 */
@WebServlet("/conditionquery")
public class ConditionQueryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//得到查询的条件
		String conditionname = request.getParameter("conditionname");
		String conditionvalue = request.getParameter("conditionvalue");
		
		//调用业务层
		CustomerService cs =new CustomerService();
		List<Customer> customers=cs.conditionquery(conditionname,conditionvalue);
		//将list数据放在request域中
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

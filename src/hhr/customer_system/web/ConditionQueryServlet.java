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
 * 1.��������
 * 2.�õ�������
 * 3.����ҵ���
 * 4.�����صĽ����������ʾ
 */
@WebServlet("/conditionquery")
public class ConditionQueryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//�õ���ѯ������
		String conditionname = request.getParameter("conditionname");
		String conditionvalue = request.getParameter("conditionvalue");
		
		//����ҵ���
		CustomerService cs =new CustomerService();
		List<Customer> customers=cs.conditionquery(conditionname,conditionvalue);
		//��list���ݷ���request����
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

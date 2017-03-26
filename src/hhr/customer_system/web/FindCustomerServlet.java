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
 * �鿴�����û���servlet
 * 1.�������
 * 2.����ҵ����߼�
 * 3.����һ��list�Ľ���������ŵ�request���в����ص�ҳ��
 */
@WebServlet("/findAll")
public class FindCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//����ύ�����Ĳ�����Ϣ
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		//����ҵ���
		CustomerService cs =new CustomerService();
		
		//�õ����ص�list��������ص�ҳ��
//		List<Customer> customers = cs.find();
		PageBean bean =cs.find(pageNum);
		//����ѯ���Ľ���ŵ�request����
		List<Customer> customers = bean.getCustomers();
		request.setAttribute("customers", customers);
		request.setAttribute("bean", bean);
		
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

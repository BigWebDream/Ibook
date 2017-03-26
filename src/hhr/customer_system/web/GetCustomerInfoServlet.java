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
 * 1.�������
 * 2.�õ��û���id
 * 3.����ҵ���
 * 4.���ؽ�������д���
 */
@WebServlet("/getinfo")
public class GetCustomerInfoServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//�õ��û���id������ҵ���
		String id = request.getParameter("id");
		CustomerService cs = new CustomerService();
		Customer customer =cs.query(id);
		
		//��list�����request����
		request.setAttribute("customerinfo",customer );
		//��ҳ����ת���û�����Ϣҳ��
		request.getRequestDispatcher("/info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

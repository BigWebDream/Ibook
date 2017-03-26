package hhr.customer_system.web;

import hhr.customer_system.service.CustomerService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.��������
 * 2.�õ����ύ������id
 * 3.����ҵ��㴦��
 * 4.�ض��򵽲�ѯҳ��
 */
@WebServlet("/deleteOne")
public class DeleteOneCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//�õ��û���id
		String id = request.getParameter("id");
		
		//����ҵ�����д���
		CustomerService cs =new CustomerService();
		cs.delete(id);
		
		//��ҳ������ض���
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

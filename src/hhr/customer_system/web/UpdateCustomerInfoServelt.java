package hhr.customer_system.web;

import hhr.customer_system.domain.Customer;
import hhr.customer_system.service.CustomerService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 1.��������
 * 2.����õ����û�������װ��Щ����,��checkbox����ǿ��
 * 3.����ҵ�������޸�
 * 4.������ɺ������²�ѯ
 */
@WebServlet("/update")
public class UpdateCustomerInfoServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//�õ��û��ı������з�װ
		Customer bean =new Customer();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ǿ��checkbox�õ�������
		String[] values = request.getParameterValues("preference");
		if(values!=null){
			String preference =Arrays.toString(values); //[���򡣡���]
			//subString ȡֵǰ�պ�
			preference =preference.substring(1, preference.length()-1);
			//���·�װ
			bean.setPreference(preference);
//			System.out.println(values.length+"...."+preference.length());
			 
			
		}
		
		//����ҵ���
		CustomerService cs =new CustomerService();
		cs.update(bean);
		
		//�ض��򵽲�ѯҳ��
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

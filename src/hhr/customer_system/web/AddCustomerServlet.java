package hhr.customer_system.web;

import hhr.customer_system.domain.Customer;
import hhr.customer_system.service.CustomerService;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 *1.�������
 *2.��װ������
 *3.����ҵ�����߼�����
 *4.���û�������Ϣ
 */
@WebServlet("/add")
public class AddCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Customer bean =new Customer();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		//�����ж��ֵ����Ҫ�ֶ����з�װ
		String[] values = request.getParameterValues("preference");
		if(values!=null){
			String preference = Arrays.toString(values);// ��ʽΪ [����...]
			//ȥ�����ߵ�������
			preference=preference.substring(1, preference.length()-1);
			//�ٷ�װ��bean��
			bean.setPreference(preference);
			
		}
		
		//�õ��û���token����������֤
		String token =request.getParameter("token");
//		System.out.println(token);
		String token_session =  (String) request.getSession().getAttribute("token_session");
//		System.out.println(token_session);
		//�ǳ���Ҫ��ɾ��ԭ����session�е�ֵ
		request.getSession().removeAttribute("token_session");
		if(token==null||!token.equals(token_session)){
			
			//˵���ظ��ύ�˱�
			response.getWriter().println("�������Ϲ��..�Ҵ�");
			//��ֹ����������ύ
			return;
		}
		
		//����service�����ҵ������
		CustomerService cs =new CustomerService();
		cs.addCustomer(bean);
		
		//���û�������Ϣ
		response.getWriter().println("success");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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
 *1.解决乱码
 *2.封装表单数据
 *3.调用业务层的逻辑代码
 *4.给用户反馈信息
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
		
		//爱好有多个值，需要手动进行封装
		String[] values = request.getParameterValues("preference");
		if(values!=null){
			String preference = Arrays.toString(values);// 格式为 [打球...]
			//去掉两边的中括号
			preference=preference.substring(1, preference.length()-1);
			//再封装到bean中
			bean.setPreference(preference);
			
		}
		
		//得到用户的token，并进行验证
		String token =request.getParameter("token");
//		System.out.println(token);
		String token_session =  (String) request.getSession().getAttribute("token_session");
//		System.out.println(token_session);
		//非常重要，删掉原来的session中的值
		request.getSession().removeAttribute("token_session");
		if(token==null||!token.equals(token_session)){
			
			//说明重复提交了表单
			response.getWriter().println("你别他妈瞎搞..找锤");
			//终止后面的数据提交
			return;
		}
		
		//调用service层进行业务的完成
		CustomerService cs =new CustomerService();
		cs.addCustomer(bean);
		
		//给用户反馈信息
		response.getWriter().println("success");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

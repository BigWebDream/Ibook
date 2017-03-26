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
 * 1.处理乱码
 * 2.处理得到的用户表单并封装这些数据,对checkbox进行强化
 * 3.调用业务层进行修改
 * 4.更改完成后再重新查询
 */
@WebServlet("/update")
public class UpdateCustomerInfoServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//得到用户的表单并进行封装
		Customer bean =new Customer();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//强化checkbox得到的数据
		String[] values = request.getParameterValues("preference");
		if(values!=null){
			String preference =Arrays.toString(values); //[打球。。。]
			//subString 取值前闭后开
			preference =preference.substring(1, preference.length()-1);
			//重新封装
			bean.setPreference(preference);
//			System.out.println(values.length+"...."+preference.length());
			 
			
		}
		
		//调用业务层
		CustomerService cs =new CustomerService();
		cs.update(bean);
		
		//重定向到查询页面
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

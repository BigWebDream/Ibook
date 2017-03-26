package hhr.customer_system.service;

import java.util.List;

import hhr.customer_system.dao.CustomerDao;
import hhr.customer_system.dao.factory.DaoFactory;
import hhr.customer_system.dao.impl.CustomerDaoImpl;
import hhr.customer_system.domain.Customer;
import hhr.customer_system.domain.PageBean;

public class CustomerService {
	
	//用接口Customer做引用，就可以知道接口中有哪些方法可以调用
	private CustomerDao cDao = DaoFactory.getInstance().createDao(CustomerDao.class);

	//完成客户的添加业务,调用dao去添加
	public void addCustomer(Customer bean) {
			
		cDao.insertCustomer(bean);
		
	}

	//完成客户的查看所有用户的功能，调用dao层
	public PageBean find(int pageNum) {
		
		 PageBean bean =new PageBean();
		int totalCount =cDao.queryTotalNum(); 
		int numPerPage =10;
		int totalPageNum =1;
		
		if(totalCount%numPerPage==0){
			totalPageNum =totalCount/numPerPage;
		}else if(totalCount%numPerPage!=0){
			totalPageNum =totalCount/numPerPage+1;
		}
		List<Customer> list = cDao.queryAll(pageNum,numPerPage);
		bean.setCustomers(list);
		bean.setNumPerPage(numPerPage);
		bean.setPageNum(pageNum);
		bean.setTotalCount(totalCount);
		bean.setTotalPageNum(totalPageNum);
		System.out.println(totalCount);
		return bean;
	}

	public void delete(String id) {
		cDao.deleteOne(id);
	}

	public Customer query(String id) {

				
		return cDao.query(id);	
		
	}

	public void update(Customer bean) {
		cDao.update(bean);
	}

	//条件查询
	public List<Customer> conditionquery(String conditionname, String conditionvalue) {
		
		return cDao.conditionQuery(conditionname,conditionvalue);
		
	}

}

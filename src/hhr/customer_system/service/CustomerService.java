package hhr.customer_system.service;

import java.util.List;

import hhr.customer_system.dao.CustomerDao;
import hhr.customer_system.dao.factory.DaoFactory;
import hhr.customer_system.dao.impl.CustomerDaoImpl;
import hhr.customer_system.domain.Customer;
import hhr.customer_system.domain.PageBean;

public class CustomerService {
	
	//�ýӿ�Customer�����ã��Ϳ���֪���ӿ�������Щ�������Ե���
	private CustomerDao cDao = DaoFactory.getInstance().createDao(CustomerDao.class);

	//��ɿͻ������ҵ��,����daoȥ���
	public void addCustomer(Customer bean) {
			
		cDao.insertCustomer(bean);
		
	}

	//��ɿͻ��Ĳ鿴�����û��Ĺ��ܣ�����dao��
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

	//������ѯ
	public List<Customer> conditionquery(String conditionname, String conditionvalue) {
		
		return cDao.conditionQuery(conditionname,conditionvalue);
		
	}

}

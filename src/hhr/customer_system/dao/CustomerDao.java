package hhr.customer_system.dao;

import hhr.customer_system.domain.Customer;
import hhr.customer_system.domain.PageBean;

import java.util.List;

public interface CustomerDao {

	public abstract void insertCustomer(Customer bean);

	//用于生成全球唯一的ID
	public abstract String generateId();

	public abstract List<Customer> queryAll(int pageNum,int numPerPage);

	public abstract void deleteOne(String id);

	public abstract Customer query(String id);

	public abstract void update(Customer bean);

	public abstract List<Customer> conditionQuery(String conditionname,
			String conditionvalue);

	public abstract int queryTotalNum();

}
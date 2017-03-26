package hhr.customer_system.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import hhr.customer_system.dao.CustomerDao;
import hhr.customer_system.domain.Customer;
import hhr.customer_system.domain.PageBean;
import hhr.customer_system.utils.JdbcUtils;

public class CustomerDaoImpl implements CustomerDao {

	/* (non-Javadoc)
	 * @see hhr.customer_system.dao.CustomerDao#insertCustomer(hhr.customer_system.domain.Customer)
	 */
	@Override
	public void insertCustomer(Customer bean) {
		
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql ="insert into customer values (?,?,?,?,?,?,?,?,?)";
			Object [] params ={generateId(),bean.getName(),bean.getGender(),bean.getBirthday(),
					bean.getEmail(),bean.getCellphone(),bean.getPreference(),bean.getType(),bean.getDescription()};
			runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//用于生成全球唯一的ID
	/* (non-Javadoc)
	 * @see hhr.customer_system.dao.CustomerDao#generateId()
	 */
	@Override
	public String generateId(){
		
		String id =UUID.randomUUID().toString();
		return "hhr-"+id.replace("-", "");
		
	}

	/* (non-Javadoc)
	 * @see hhr.customer_system.dao.CustomerDao#queryAll()
	 */
	@Override
	public List<Customer> queryAll(int pageNum,int numPerPage) {
		
		QueryRunner runner =new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from customer limit ?,?";
		Object [] params={pageNum-1,numPerPage};
		try {
			return runner.query(sql, new BeanListHandler<Customer>(Customer.class),params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see hhr.customer_system.dao.CustomerDao#deleteOne(java.lang.String)
	 */
	@Override
	public void deleteOne(String id) {
		QueryRunner runner =new QueryRunner(JdbcUtils.getDataSource());
		String sql ="delete from customer where id=?";
		try {
			runner.update(sql, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Customer query(String id) {

		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from customer where id=?";
		try {
			return runner.query(sql, new BeanHandler<Customer>(Customer.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Customer bean) {
		
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql="update customer set name=?,gender=?,birthday=?,"
				+ "email=?,cellphone=?,preference=?,"
				+ "type=?,description=? where id=?";
		Object [] params ={bean.getName(),bean.getGender(),bean.getBirthday(),bean.getEmail()
						,bean.getCellphone(),bean.getPreference(),bean.getType(),bean.getDescription()
						,bean.getId()
		};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Customer> conditionQuery(String conditionname,
			String conditionvalue) {
		
		QueryRunner runner =new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select * from customer where "+conditionname+" like ?";
		try {
			return runner.query(sql, new BeanListHandler<Customer>(Customer.class), "%"+conditionvalue+"%");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int queryTotalNum() {

		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql ="select count(*) from customer";
		try {
			long res = (Long) runner.query(sql, new ScalarHandler());
			return (int)res;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

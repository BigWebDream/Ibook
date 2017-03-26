package hhr.customer_system.test;

import java.sql.SQLException;
import java.util.UUID;

import hhr.customer_system.utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class AddCustomer {
	
	@Test
	public void AddCustomer() throws Exception{
		
		QueryRunner runner =new QueryRunner(JdbcUtils.getDataSource());
		String sql= "insert into customer values (?,?,?,?,?,?,?,?,?)";
		for(int i=0;i<100;i++){
			Object [] params ={generateId(),"gaoxiang"+i,"男","1992-01-02","527855623@qq.com","123"+i,"打球,学习","普通客户","hello"};
			runner.update(sql, params);
		}
	}
	public String generateId(){
		
		String id =UUID.randomUUID().toString();
		return "hhr-"+id.replace("-", "");
		
	}

}

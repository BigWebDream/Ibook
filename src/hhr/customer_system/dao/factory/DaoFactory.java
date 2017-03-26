package hhr.customer_system.dao.factory;

import java.util.ResourceBundle;

/*
 * 
 * 这时用于创建dao的工厂类
 */
public class DaoFactory {

	//设计为单例模式，所以构造方法为私有的，不让外部调用
	private DaoFactory(){};
	
	private static DaoFactory instance =new DaoFactory();
	
	public static DaoFactory getInstance(){
		
		return instance;
	}
	
	public <T> T createDao(Class<T> t){
		
//		Customer.class 传进来后，通过t.getSimpleName得到-->customer
		String simpleName = t.getSimpleName();
		//通过ResourceBundle读取配置文件得到实现类的路径
		String className =ResourceBundle.getBundle("dao").getString(simpleName);
		
		try {
			//通过字节码得到该类的一个实例对象
			return  (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

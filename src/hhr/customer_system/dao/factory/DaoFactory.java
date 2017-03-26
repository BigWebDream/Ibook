package hhr.customer_system.dao.factory;

import java.util.ResourceBundle;

/*
 * 
 * ��ʱ���ڴ���dao�Ĺ�����
 */
public class DaoFactory {

	//���Ϊ����ģʽ�����Թ��췽��Ϊ˽�еģ������ⲿ����
	private DaoFactory(){};
	
	private static DaoFactory instance =new DaoFactory();
	
	public static DaoFactory getInstance(){
		
		return instance;
	}
	
	public <T> T createDao(Class<T> t){
		
//		Customer.class ��������ͨ��t.getSimpleName�õ�-->customer
		String simpleName = t.getSimpleName();
		//ͨ��ResourceBundle��ȡ�����ļ��õ�ʵ�����·��
		String className =ResourceBundle.getBundle("dao").getString(simpleName);
		
		try {
			//ͨ���ֽ���õ������һ��ʵ������
			return  (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

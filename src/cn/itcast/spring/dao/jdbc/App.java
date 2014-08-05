package cn.itcast.spring.dao.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("cn/itcast/spring/dao/jdbc/jdbc.xml");
		ICustomerDao dao = (ICustomerDao)app.getBean("customerDao");
		Customer c=new Customer();
		c.setAge(23);
		c.setName("jerry");
		c.setId(1);
//		dao.insertCus(c);
//		dao.updateCus(c);
//		List<Customer> l=dao.queryById(3);
		List<Customer> li=dao.queryAll();
		System.out.println("");
		
	}
}

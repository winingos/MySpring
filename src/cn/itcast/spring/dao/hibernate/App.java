package cn.itcast.spring.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.domain.Customer;

public class App {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"cn/itcast/spring/dao/hibernate/hibernate.xml");
		CustomerDaoService service = (CustomerDaoService) app.getBean("CustomerDaoService");
		List<Customer> lc =new ArrayList<Customer>();
		for (int i = 0; i < 10; i++) {
			Customer c = new Customer();
			lc.add(c);
			c.setAge(23+i);
			if(i==5) break;
			c.setName("test"+i);
		}
		service.addList(lc);
//		dao.insertCus(c);
//		dao.updateCus(c);
//		List<Customer> l = dao.queryById(3);
//		List<Customer> li = dao.queryAll();
		System.out.println("");

	}
}

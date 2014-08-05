package cn.itcast.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.service.ByeService;
import cn.itcast.spring.service.GreetingService;

public class App {

	public static void main(String[] args) {
		// GreetingService gs = new GreetingService();
		// gs.setGreeting("hello world");
		// gs.sayGreeting();

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		GreetingService gs = (GreetingService) ac.getBean("greetingService");
		gs.sayGreeting();
		gs.sayGreeting2();
		
		ByeService bs = (ByeService) ac.getBean("byeService");
		bs.sayBye();
	}

}
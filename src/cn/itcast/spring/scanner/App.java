package cn.itcast.spring.scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
		"cn/itcast/spring/scanner/scanner.xml");
		Scanner sca=(Scanner) ac.getBean("scanner");
		System.out.println(sca.getPassword());

	}

}

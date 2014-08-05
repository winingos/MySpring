package cn.itcast.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * ByeService
 */
public class ByeService implements BeanNameAware,BeanFactoryAware{
	private String bye ;
	
	public ByeService() {
		System.out.println("new ByeService");
	}
		
	
	public String getBye() {
		return bye;
	}

	public void setBye(String bye) {
		System.out.println("setBye------>"+bye);
		this.bye = bye;
	}
	
	
	public void sayBye(){
		System.out.println(bye);
	}
	public void ini() {
		System.out.println("ini---method");
	}


	@Override
	public void setBeanName(String arg0) {
		System.out.println("BeanNameAware.setBeanName"+arg0);
		
	}


	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("BeanFactoryAware.setBeanFactory-->"+arg0);
		
	}
}

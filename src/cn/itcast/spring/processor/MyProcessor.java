package cn.itcast.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * 后处理器
 * @author wn
 *
 */
public class MyProcessor implements BeanPostProcessor {
/**
 * 初始化之前,返回务必是arg0
 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("after :"+arg0+":"+arg1);
		return arg0;
	}
/**
 * 初始化之后
 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("before :"+arg0+":"+arg1);
		return arg0;
	}

}

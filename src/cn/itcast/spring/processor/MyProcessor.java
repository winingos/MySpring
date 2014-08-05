package cn.itcast.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/**
 * ������
 * @author wn
 *
 */
public class MyProcessor implements BeanPostProcessor {
/**
 * ��ʼ��֮ǰ,���������arg0
 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("after :"+arg0+":"+arg1);
		return arg0;
	}
/**
 * ��ʼ��֮��
 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("before :"+arg0+":"+arg1);
		return arg0;
	}

}

package cn.itcast.spring.scanner;

import java.beans.PropertyEditorSupport;

/**
 * ��ַ�༭��
 */
public class AddressEditor extends PropertyEditorSupport {
	
	public void setAsText(String text) throws IllegalArgumentException {
		if(text != null && text.length() > 0){
			String[] ss = text.split("-");
			if(ss != null && ss.length > 3){
				Address a = new Address();
				a.setProvince(ss[0]);
				a.setCity(ss[1]);
				a.setStreet(ss[2]);
				a.setZipCode(ss[3]);
				//��ת���ɵĵ�ַ�������ø���Ӧ��������
				setValue(a);
			}
			else{
				setValue(null);
			}
		}
		else{
			setValue(null);
		}
	}

	
}

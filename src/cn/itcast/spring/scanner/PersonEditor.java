package cn.itcast.spring.scanner;

import java.beans.PropertyEditorSupport;

public class PersonEditor extends PropertyEditorSupport {
	public void setAsText(String test)throws IllegalArgumentException{
		if("".equals(test))  setValue(null);
		String[] valArr = test.split(",");
		if(valArr==null||valArr.length<3) setValue(null);
		Person p = new Person();
		p.setName(valArr[0]);
		p.setAge(valArr[1]);
		p.setSex(valArr[2]);
		 setValue(p);
	}
}

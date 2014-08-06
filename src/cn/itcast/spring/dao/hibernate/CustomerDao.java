package cn.itcast.spring.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast.spring.domain.Customer;
@SuppressWarnings("unchecked")
public class CustomerDao implements ICustomerDao {
	//hibernate模板,封装样板代码
	private HibernateTemplate ht;
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

@Override
public void insertCus(Customer c){
	 ht.save(c);
 }
@Override
public void updateCus(Customer c){
	ht.update(c);
}

	public List<Customer> queryById(int id) {
		String hql="from Customer c where c.id = ?";
		return ht.find(hql, id);
	}

	
	@Override
	public List<Customer> queryAll() {
		String hql="from Customer";
		return ht.find(hql);
	}
}

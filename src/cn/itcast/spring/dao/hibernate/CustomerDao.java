package cn.itcast.spring.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
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
//  在dao层面进行实务的管理
	@Override
	public void updateBat(final List<Customer> lc) {
//		接口回调
		ht.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
//				显式开启实务，实现事务管理。
				Transaction  tx =session.beginTransaction();
				for (Customer c : lc) {
					session.save(c);
				}
				tx.commit();
				return null;
			}
		});
		
	}
}

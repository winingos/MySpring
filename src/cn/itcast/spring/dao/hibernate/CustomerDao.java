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
	//hibernateģ��,��װ�������
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
//  ��dao�������ʵ��Ĺ���
	@Override
	public void updateBat(final List<Customer> lc) {
//		�ӿڻص�
		ht.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
//				��ʽ����ʵ��ʵ���������
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

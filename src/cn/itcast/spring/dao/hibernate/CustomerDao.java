package cn.itcast.spring.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.itcast.spring.domain.Customer;
@SuppressWarnings("unchecked")
public class CustomerDao implements ICustomerDao {
private SessionFactory sf;
public void setSf(SessionFactory sf) {
	this.sf = sf;
}
@Override
public void insertCus(Customer c){
	 sf.getCurrentSession().save(c);
 }
@Override
public void updateCus(Customer c){
	sf.getCurrentSession().update(c);
}

	public List<Customer> queryById(int id) {
		String hql="from Customer c where c.id = ?";
		Session ss=sf.getCurrentSession();
		Query qq =ss.createQuery(hql);
		qq.setInteger(0, id);
		return qq.list();
	}

	
	@Override
	public List<Customer> queryAll() {
		String hql="from Customer";
		return sf.getCurrentSession().createQuery(hql).list();
	}
//  ��dao�������ʵ��Ĺ���
	public void updateBat(final List<Customer> lc) {
//		�ӿڻص�
//		ht.execute(new HibernateCallback() {
//			
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException,
//					SQLException {
////				��ʽ����ʵ��ʵ���������
//				Transaction  tx =session.beginTransaction();
//				for (Customer c : lc) {
//					session.save(c);
//				}
//				tx.commit();
//				return null;
//			}
//		});
		
	}
}

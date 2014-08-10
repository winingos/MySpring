package cn.itcast.spring.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.itcast.spring.domain.Customer;

public class CustomerServiceImpl implements CustomerDaoService {
//	dao
	private ICustomerDao dao;
//	事务模板,封装事务管理的样板代码
	private TransactionTemplate tt ;
	//注入事务模板
	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	//注入dao
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	@Override
	public void save(Customer c){
		dao.insertCus(c);
	}
	@Override
	public List<Customer> queryAll(){
		return dao.queryAll();
	}
	@Override
	public void addList(final List<Customer> lc){
		tt.execute(new TransactionCallback() {
			
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					for (Customer c : lc) {
						dao.insertCus(c);
					}
				} catch (Exception e) {
					e.printStackTrace();
					status.isRollbackOnly();
				}
				return null;
			}
		});
	}
	 
}

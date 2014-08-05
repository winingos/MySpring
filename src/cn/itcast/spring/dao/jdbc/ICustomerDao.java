package cn.itcast.spring.dao.jdbc;

import java.util.List;


public interface ICustomerDao {

	public abstract void insertCus(Customer c);

	public abstract void updateCus(Customer c);
	
	public List<Customer> queryById(int id) ;
	
	public List<Customer> queryAll();

}
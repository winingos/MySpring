package cn.itcast.spring.dao.hibernate;

import java.util.List;

import cn.itcast.spring.domain.Customer;


public interface ICustomerDao {

	public abstract void insertCus(Customer c);

	public abstract void updateCus(Customer c);
	
	public List<Customer> queryById(int id) ;
	
	public List<Customer> queryAll();

}
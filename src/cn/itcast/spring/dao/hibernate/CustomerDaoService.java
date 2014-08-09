package cn.itcast.spring.dao.hibernate;

import java.util.List;

import cn.itcast.spring.domain.Customer;

public interface CustomerDaoService {

	public abstract void save(Customer c);

	public abstract List<Customer> queryAll();

	public abstract void addList(List<Customer> lc);

}
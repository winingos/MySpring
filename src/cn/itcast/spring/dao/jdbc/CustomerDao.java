package cn.itcast.spring.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
@SuppressWarnings("unchecked")
public class CustomerDao extends JdbcDaoSupport implements ICustomerDao {

@Override
public void insertCus(Customer c){
	 String sql="insert into jdbcTable(name,age)values(?,?)"; 
	 getJdbcTemplate().update(sql,new Object[]{c.getName(),c.getAge()});
 }
@Override
public void updateCus(Customer c){
	String sql="update jdbcTable set name=?,age=? where id=?"; 
	getJdbcTemplate().update(sql,new Object[]{c.getName(),c.getAge(),c.getId()});
}

	public List<Customer> queryById(int id) {
		String sql = "select * from jdbcTable where id=?";
		return  getJdbcTemplate().query(sql, new Object[] { id },
				new RowMapper() {
					
					@Override
					public Object mapRow(ResultSet rst, int row) throws SQLException {
						{
								System.out.println("row--->"+row);
								Customer c = new Customer();
								c.setId(rst.getInt("id"));
								c.setName(rst.getString("name"));
								c.setAge(rst.getInt("age"));
								return c;
							}
					}
				
				});

	}

	
	@Override
	public List<Customer> queryAll() {
		String sql="select * from jdbcTable";
		return (List<Customer>) getJdbcTemplate().query(sql, new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rst,int rowcount) throws SQLException{
				Customer c = new Customer();
				c.setId(rst.getInt("id"));
				c.setName(rst.getString("name"));
				c.setAge(rst.getInt("age"));
				System.out.println("rowcount--->" + rowcount);
				return c;
			}
		});
	}

}

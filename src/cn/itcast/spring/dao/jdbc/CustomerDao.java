package cn.itcast.spring.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
@SuppressWarnings("unchecked")
public class CustomerDao implements ICustomerDao {
	private NamedParameterJdbcTemplate jt;
	
 public NamedParameterJdbcTemplate getJt() {
		return jt;
	}

	public void setJt(NamedParameterJdbcTemplate jt) {
		this.jt = jt;
	}

@Override
public void insertCus(Customer c){
	 String sql="insert into jdbcTable(name,age)values(:m,:n)"; 
	 Map map=new HashMap();
	 map.put("m", c.getName());
	 map.put("n", c.getAge());
	 jt.update(sql,map);
 }
@Override
public void updateCus(Customer c){
	String sql="update jdbcTable set name=:m,age=:n where id=:j"; 
	 Map map=new HashMap();
	 map.put("m", c.getName());
	 map.put("n", c.getAge());
	 map.put("j", c.getId());
	jt.update(sql,map);
}

	public List<Customer> queryById(int id) {
		String sql = "select * from jdbcTable where id=:j";
		Map map=new HashMap();
		map.put("j", id);
		return  jt.query(sql, map,
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
		return (List<Customer>) jt.query(sql, new HashMap(),new RowMapper() {
			
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

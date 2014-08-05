package cn.itcast.spring.scanner;

public class Scanner {

	/**
	 * 分散配置
	 */
	
		private String driverClass ;
		private String url ;
		private String username ;
		private String password ;
		
		private Address comAddress ;//公司地址
		private Address homeAddress ;//家庭地址
		private Person empPerson;
		public Person getEmpPerson() {
			return empPerson;
		}
		public void setEmpPerson(Person empPerson) {
			this.empPerson = empPerson;
		}
		public Address getComAddress() {
			return comAddress;
		}
		public void setComAddress(Address comAddress) {
			this.comAddress = comAddress;
		}
		public Address getHomeAddress() {
			return homeAddress;
		}
		public void setHomeAddress(Address homeAddress) {
			this.homeAddress = homeAddress;
		}
		public String getDriverClass() {
			return driverClass;
		}
		public void setDriverClass(String driverClass) {
			this.driverClass = driverClass;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}



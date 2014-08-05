package cn.itcast.spring.service;

/**
 * GreetingService
 */
public class GreetingService {
	private String greeting ;
	private String greeting2 ;
	
	/* byeService */
	private ByeService bs ;

	public ByeService getBs() {
		return bs;
	}

	public void setBs(ByeService bs) {
		this.bs = bs;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public void sayGreeting(){
		System.out.println(greeting);
	}
	public void sayGreeting2(){
		bs.sayBye();
	}

	public String getGreeting2() {
		return greeting2;
	}

	public void setGreeting2(String greeting2) {
		this.greeting2 = greeting2;
	}
}

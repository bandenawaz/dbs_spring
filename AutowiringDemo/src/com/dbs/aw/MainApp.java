package com.dbs.aw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
		
		//lets work with city bean
		City city = con.getBean("city", City.class);
		city.setId(01);
		city.setName("Hyderabad");
		
		State st = con.getBean("state", State.class);
		st.setName("Telangana");
		city.setState(st);
		
		
		city.showCityDetails();

	}

}

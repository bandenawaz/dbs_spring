package com.dbs.mappingdemo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingMain {

	public static void main(String[] args) {
		
		
		//Lets Create Users
		User user = new User();
		User user2 = new User();
		
		user2.setUserName("Sunil");
		user.setUserName("Hafeez");
		
		//Lets create Address
		Address address = new Address();
		address.setStreet("Gachibowli");
		address.setCity("Hyderabad");
		
		Address address2 = new Address();
		address2.setStreet("Hightech City");
		address2.setCity("Secundrabad");
		
		
		//Lets add vehicles
		Vehicle car = new Vehicle();
		car.setName("Audi");
		
		Vehicle jeep = new Vehicle();
		jeep.setName("Compass");
		
		Vehicle bike = new Vehicle();
		bike.setName("Harley Davidson");
		
		Vehicle cycle = new Vehicle();
		cycle.setName("KTM");
		
		//now lets instantiate mobiles
		Mobile sony = new Mobile();
		sony.setBrand("Sony");
		sony.setModel("Xperia Z3");
		
		Mobile iphone = new Mobile();
		iphone.setBrand("Apple");
		iphone.setModel("iphone 13");
		
		Mobile oneplus = new Mobile();
		oneplus.setBrand("Oneplus");
		oneplus.setModel("One Plus 10");
		
		Mobile nothing = new Mobile();
		nothing.setBrand("Nothing");
		nothing.setModel("Nothing mobile");
		
		//lets use associations by setters
		user.setAddress(address);
		user2.setAddress(address2);
		address.setUser(user);
		address2.setUser(user2);
		
		user.getMobile().add(sony);
		user2.getMobile().add(iphone);
		sony.setUser(user);
		iphone.setUser(user2);
		
		user.getVehicle().add(car);
		user2.getVehicle().add(bike);
		car.getUser().add(user);
		bike.getUser().add(user2);
		
		user.getVehicle().add(jeep);
		jeep.getUser().add(user);
		user2.getVehicle().add(cycle);
		cycle.getUser().add(user2);
		
		//Lets add the data to database
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		

	}

}

package com.dbs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MainApp {

	public static void main(String[] args) {
		
		//Lets establish  the connection
		//This is thread safe
		//default configuration file must be hibernate.cfg.xml
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//lets open the session
		Session session = sf.openSession(); //This is not thread safe
		
		List<Book> books = session.createQuery("FROM Book").list();
		//lets begin transaction
		Transaction transaction = session.beginTransaction();
		
		//Lets instantiate books
		Book book = new Book();
		book.setAuthor("Ronald Dahl");
		book.setTopic("Poison");
		
		//Lets save it permanently
		
		session.save(book);
		transaction.commit();
		//lets print the books
				for (Book b : books) {
					
					System.out.println(b);
					
				}
		session.close();
		sf.close();
		

	}

}

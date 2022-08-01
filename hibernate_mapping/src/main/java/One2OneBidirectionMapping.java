import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate_mapping.model.Employee;
import hibernate_mapping.model.Laptop;

public class One2OneBidirectionMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory  factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();

		

		Employee employee=new Employee();
		employee.setEmpName("Dr Tarkeshwar");
		
		Laptop laptop=new  Laptop();
		laptop.setCpu("i3");
		laptop.setRam("8GB");
		laptop.setEmployee(employee);
		

		session.save(laptop);
		session.save(employee);
		transaction.commit();
		session.close();
		factory.close();
	}

}

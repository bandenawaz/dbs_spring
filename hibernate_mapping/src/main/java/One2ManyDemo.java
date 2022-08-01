import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate_mapping.model.Employee;
import hibernate_mapping.model.Laptop;
import hibernate_mapping.model.Phone;

public class One2ManyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory  factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();

		Phone phone=new  Phone();
		phone.setPhoneNumber("34324324");
		phone.setType("HOme");
		
		Phone phone1=new  Phone();
		phone1.setPhoneNumber("3434");
		phone1.setType("Office");

		List<Phone> listOfPhone=new ArrayList();
		listOfPhone.add(phone1);
		listOfPhone.add(phone);
		
		Employee employee=new Employee();
		employee.setEmpName("Mr ABC");
		employee.setPhones(listOfPhone);

		session.save(phone);
		session.save(phone1);
		session.save(employee);
		transaction.commit();
		session.close();
		factory.close();
	}

}

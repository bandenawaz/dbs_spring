import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate_mapping.model.Employee;
import hibernate_mapping.model.Project;

public class Many2ManyBidirectional {
public static void main(String[] args) {
	SessionFactory  factory=new Configuration().configure().buildSessionFactory();
	Session session=factory.openSession();
	Transaction transaction=session.beginTransaction();

	Project project1=new  Project();
	project1.setProjectName("LICT");
	
	Employee employee=new Employee();
	employee.setEmpName("Mr TBC");
	Employee employee1=new Employee();
	employee1.setEmpName("Mr TBCD");
		
	List<Employee> employees=new ArrayList<Employee>();
	employees.add(employee);
	employees.add(employee1);
	project1.setEmployees(employees);
	

	session.save(project1);
	session.save(employee);
	session.save(employee1);

	transaction.commit();
	session.close();
	factory.close();
}
}

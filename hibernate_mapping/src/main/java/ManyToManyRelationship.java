import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate_mapping.model.Employee;
import hibernate_mapping.model.Phone;
import hibernate_mapping.model.Project;

public class ManyToManyRelationship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory  factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();

		Project project1=new  Project();
		project1.setProjectName("LICT");
		
		Project project2=new  Project();
		project2.setProjectName("PMKVY");
		
		List<Project> projects=new ArrayList<Project>();
		projects.add(project2);
		projects.add(project1);
		
		Employee employee=new Employee();
		employee.setEmpName("Mr KBC");
		employee.setProjects(projects);

		session.save(project1);
		session.save(project2);
		session.save(employee);

		transaction.commit();
		session.close();
		factory.close();
	}

}

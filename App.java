package Kodnest.com.PersistDelete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Kodnest.com.PersistDelete.Employee;

public class App {
  public static void main(String[] args) {

	  Configuration configuration = new Configuration();
	  
	  configuration.configure("hibernate.cfg.xml");
	  
	  StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	  
	  SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	  Session session=sessionFactory.openSession();
	   session.beginTransaction();
	   String id="105";
	
	   Employee ref = (Employee) session.get(Employee.class, id);
	   session.delete(ref);
	   
	   session.getTransaction().commit();
	   session.close();  }
}

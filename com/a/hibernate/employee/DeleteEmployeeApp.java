package com.a.hibernate.employee;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.a.hibernate.employee.enitity.Employee;

public class DeleteEmployeeApp {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Employee.class)
						.buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//use the session object to save Java object
					System.out.println("Filtering the employee by id=5");
					
					//start a transaction
					session.beginTransaction();
					
					//reading the employee object
					System.out.println("reading emp to fire");
					int id = 5;
					Employee fired = session.get(Employee.class, id);
					session.delete(fired);
					System.out.println("Deleting employee id=5");
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}
				finally{
					factory.close();
				}

	}

}

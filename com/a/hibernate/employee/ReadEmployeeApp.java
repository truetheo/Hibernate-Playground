package com.a.hibernate.employee;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.a.hibernate.employee.enitity.Employee;

public class ReadEmployeeApp {

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
					System.out.println("Reading an employee with ID=2");
					
					
					//start a transaction
					session.beginTransaction();
					
					//reading the employee object
					System.out.println("reading emp");
					Employee emp = session.get(Employee.class, 2);
					System.out.println("Emp: " + emp);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}
				finally{
					factory.close();
				}

	}

}

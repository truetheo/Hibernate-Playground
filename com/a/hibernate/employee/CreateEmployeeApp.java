package com.a.hibernate.employee;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.a.hibernate.employee.enitity.Employee;

public class CreateEmployeeApp {

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
					System.out.println("Creating a new employee objects");
					
					// create a employees object
					List<Employee> employees = new ArrayList<Employee>();
					employees.add(new Employee("Jose","De la Cruz", "Gold Mine Co."));
					employees.add(new Employee("Maria","Sorento", "Silver Mine Co."));
					employees.add(new Employee("Adam","Bielan", "Coal Mine Co."));
					employees.add(new Employee("Donald","Tusk", "EU Parliament"));
					employees.add(new Employee("Jarek","Kaczynski", "Sejm"));
					
					//start a transaction
					session.beginTransaction();
					
					//save the employee object
					System.out.println("Saving the employees...");
					for (Employee tempEmp : employees) {
						int id = (Integer)session.save(tempEmp);
						System.out.println("Added item with id: " + id);
					}
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}
				finally{
					factory.close();
				}

	}

}

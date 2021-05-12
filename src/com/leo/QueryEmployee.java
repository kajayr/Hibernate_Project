package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            //Query Student: All employees
            List<Employee> employee = session.createQuery("from Employee").getResultList();
            //Display Employee
            System.out.println("Displaying all the employees...");
            displayEmployee(employee);

            //Query employee: lastName='Hovanesian'
            employee = session.createQuery("from Employee e where e.lastName='Hovanesian'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the Students with last name of Hovanesian.");
            displayEmployee(employee);

            //Query Employee: lastName='Hovanesian' OR firstName='Matilda'
            employee = session.createQuery("from Employee e where lastName='Hovanesian' OR firstName='Matilda'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the employees with last name Hovanesian or first name Matilda...");
            displayEmployee(employee);

            //Query Employee: where company LIKE '%micro'
            employee = session.createQuery("from Employee e where e.company LIKE '%Sinanico'").getResultList();
            //Display results
            System.out.println("\nDisplaying all the employees whom work for Sinanico company");
            displayEmployee(employee);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayEmployee(List<Employee> employee) {
        for(Employee emp : employee) {
            System.out.println(emp);
        }
    }
}

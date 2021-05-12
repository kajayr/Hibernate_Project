package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            List<Employee> employee = session.createQuery("from Employee").getResultList();

            System.out.println("Displaying all the employees...");
            displayEmployee(employee);

            employee = session.createQuery("from Employee e where e.lastName='Hovanesian'").getResultList();
            System.out.println("\nDisplaying all the Students with last name of Hovanesian.");
            displayEmployee(employee);

            employee = session.createQuery("from Employee e where lastName='Hovanesian' OR firstName='Matilda'").getResultList();
            System.out.println("\nDisplaying all the employees with last name Hovanesian or first name Matilda...");
            displayEmployee(employee);

            employee = session.createQuery("from Employee e where e.company LIKE '%Sinanico'").getResultList();

            System.out.println("\nDisplaying all the employees whom work for Sinanico company");
            displayEmployee(employee);

            session.getTransaction().commit();
            System.out.println("Transaction has been processed!");
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

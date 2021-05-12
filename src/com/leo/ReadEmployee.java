package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating new employee object...");
            Employee emp1 = new Employee("James", "Bond", "007");

            session.beginTransaction();
            System.out.println("Beginning transaction...");

            System.out.println("Saving the new employee...");
            System.out.println(emp1);
            session.save(emp1);

            session.getTransaction().commit();

            System.out.println("Saved employee. Generated id: " + emp1.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting employee with id: " + emp1.getId());
            Employee emp = session.get(Employee.class, emp1.getId());
            System.out.println("Get Completed: " + emp);

            session.getTransaction().commit();
            System.out.println("Transaction has been processed!");
        } finally {
            factory.close();
        }
    }
}

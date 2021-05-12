package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating 3 employees objects");
            Employee emp1 = new Employee("Kajayr", "Sinanian", "Sinanico");
            Employee emp2 = new Employee("Matilda", "Hovanesian", "Caterpillar");

            session.beginTransaction();
            System.out.println("Beginning transaction...");

            session.save(emp1);
            session.save(emp2);
            System.out.println("Saving the new employees...");

            session.getTransaction().commit();
            System.out.println("Transaction has been processed!");
        } finally {
            factory.close();
        }
    }
}


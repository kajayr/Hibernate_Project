package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try{
            //create 3 student objects
            System.out.println("Creating 3 employees objects...");
            Employee emp1 = new Employee("Kajayr", "Sinanian", "Sinanico");
            Employee emp2 = new Employee("Matilda", "Hovanesian", "Caterpillar");
         //   Employee tempStudent2 = new Employee("Jill", "Jack", "jill@code.com");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the student object
            session.save(emp1);
            session.save(emp2);
         //   session.save(tempStudent2);
            System.out.println("Saving the new employees...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}


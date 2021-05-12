package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {

    public static void main(String[] args) {

        //create session factory this is for hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            //create a new student object
            System.out.println("Creating new employee object...");
            Employee emp1 = new Employee("James", "Bond", "007");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the student object
            System.out.println("Saving the new employee...");
            System.out.println(emp1);
            session.save(emp1);

            //commit the transaction
            session.getTransaction().commit();

            //***********************************************************************************
            //***Code for Reading the object***
            //find out the student's id: primary key
            System.out.println("Saved employee. Generated id: " + emp1.getId());

            //Get a new session and start a transaction
            //WHY??????
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id: primary key
            System.out.println("\nGetting employee with id: " + emp1.getId());
            Employee emp = session.get(Employee.class, emp1.getId());
            System.out.println("Get Completed: " + emp);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

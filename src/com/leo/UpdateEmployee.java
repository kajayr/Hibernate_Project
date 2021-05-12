package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

    public static void main(String[] args) {
        //create session factory this is for hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            int empId = 9;
            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id: primary key
            System.out.println("\nGetting Employee with id: " + empId);
            Employee emp = session.get(Employee.class, empId);

            //Updating the Employee first Name at primary key 1
            System.out.println("Updating Employee...");
            emp.setFirstName("Lilit");
            emp.setLastName("Petrosian");

            //commit the transaction
            session.getTransaction().commit();

            //*********************************************************//
            //Create new factory session to do a bulk update
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Update company for specific Employee
            session.createQuery("update Employee set company='Hollywood' where first_name='Lilit' ").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

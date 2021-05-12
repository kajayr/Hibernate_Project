package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int empId = 9;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting Employee with id: " + empId);
            Employee emp = session.get(Employee.class, empId);

            System.out.println("Updating Employee name and last name");
            emp.setFirstName("Lilit");
            emp.setLastName("Petrosian");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Employee set company='Hollywood' where first_name='Lilit' ").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Transaction has been processed!");
        } finally {
            factory.close();
        }
    }
}

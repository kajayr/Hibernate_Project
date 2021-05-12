package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int studentId = 9;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting Employee with id: " + studentId);
            Employee emp = session.get(Employee.class, studentId);

            //System.out.println("Deleting Employee: " + emp);
            //session.delete(emp);

            System.out.println("Deleting employee where id=9");
            session.createQuery("delete from Employee where id=9").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Transaction has been processed!");
        } finally {
            factory.close();
        }
    }
}

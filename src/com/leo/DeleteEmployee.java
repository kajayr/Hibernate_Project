package com.leo;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

    public static void main(String[] args) {
        //create session factory this is for hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            int studentId = 9;
            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve Employee based on the id: primary key
            System.out.println("\nGetting Employee with id: " + studentId);
            Employee emp = session.get(Employee.class, studentId);

            //Delete the student
            //System.out.println("Deleting student: " + myStudent);
            //session.delete(myStudent);

            //Delete student where id=15 this allows you to delete on the fly instead of having to retrieve the object.
            System.out.println("Deleting employee where id=9");
            session.createQuery("delete from Employee where id=9").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}

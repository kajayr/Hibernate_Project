package entity;

import javax.persistence.*;

//Employee Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "employee") //This is for the actual name of the database table name we are mapping to the class.
public class Employee {

    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "id") //This is mapping the primary key to the id column in your database.
    private int id;

    @Column(name = "first_name") //This will map the firstName field to the column named first_name in your student table.
    private String firstName;

    @Column(name = "last_name") //This will map the lastName field to the column named last_name in your student table.
    private String lastName;

    @Column(name = "company") //This will map the email field to the column named email in your student table.
    private  String company;

    //Constructors
    public Employee() {

    }

    public Employee(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String email) {
        this.company = email;
    }

    //To string method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}

package entity;

import javax.persistence.*;

// classify this class as an entity, points it to the proper table
@Entity
@Table(name="employee")
public class Employee {


    @Id // points to the attribute that'll be coupled with the ID field in the db table
    @Column(name = "id", nullable = false) // give it the proper name, tells us it can't be null
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells the db to generate the ID according to its parameters(here: autoincrement)
    private long ID;
    private String lastname;
    private String firstname;
    private String email;
    private int age;
    private String jobTitle;
    private String phoneNumber;
    private String address;


    /**
     * empty constructor
     */
    public Employee() {
    }

    public long getID() {
        return ID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", jobTitle='" + jobTitle + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

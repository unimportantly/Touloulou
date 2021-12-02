import entity.Employee;
import factory.EmployeeFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeManager {

    // prepare a session factory object and an int storing the total number of employees to be used later
    protected SessionFactory sessionFactory;
    protected int nbOfEmployees;

    /**
     * sets up the connection to the db
     * method will create a registry object from the cfg.xml file we created
     * will try to create a new session from that reg
     */
    protected void setup(){
        // create a constant from cfg file
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        // tries to create a new session from reg
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        // catch potential errors, destroys the const, prints the error
        catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
    }

    /**
     * closes the session
     */
    protected void exit(){
        sessionFactory.close();
    }

    /**
     * function opens the session and sends a transaction, a query to the db to add a new line in it
     * @param employee the object to be inserted into the db
     */
    protected void create(Employee employee){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        //increases the total employee counter
        nbOfEmployees ++;
    }

    /**
     * function that wants to get an object(line) from the table
     * @param id id of the object we wish to get info of
     * @return the employee object
     */
    protected Employee read(long id){
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    /**
     * function to change the attributed values of an object in the db
     * @param id id of the object we want to modify
     * @param employee new object with values we want to modify the target object to
     */
    protected void update(long id, Employee employee){
        // store the employee to be modified
        Employee oldEmployee = this.read(id);
        // check if the value is to be modified by checking for nullity
        
        if(employee.getAddress() != null){
            oldEmployee.setAddress(employee.getAddress());
        }
        if(employee.getAge() != oldEmployee.getAge()){
            oldEmployee.setAge(employee.getAge());
        }
        if(employee.getEmail() != null){
            oldEmployee.setEmail(employee.getEmail());
        }
        if(employee.getFirstname() != null){
            oldEmployee.setFirstname(employee.getFirstname());
        }
        if(employee.getLastname() != null){
            oldEmployee.setLastname(employee.getLastname());
        }
        if(employee.getJobTitle() != null){
            oldEmployee.setJobTitle(employee.getJobTitle());
        }
        if(employee.getPhoneNumber() != null){
            oldEmployee.setPhoneNumber(employee.getPhoneNumber());
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(oldEmployee);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * function to delete an entry from the database
     * @param employee object to delete
     */
    protected void delete(Employee employee){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * function to delete all objects from the database
     */
    protected void deleteAll(){
        Session session = sessionFactory.openSession();
        // loops through the employees through their PK, probably really not safe? idk
        for (int i = 1; i <= nbOfEmployees; i++) {
            if (read(i) != null) {
                session.beginTransaction();
                session.delete(this.read(i));
                session.getTransaction().commit();
            }
        }
        session.close();
    }

    /**
     * Create a list of all employees
     * @return a list of all employees
     */
    protected List<Employee> getAll(){
        Session session = sessionFactory.openSession();
        // queries the session to create a list of objects that satisfy the criteria of belonging to the employee class
        List<Employee> employeeList = session.createCriteria(Employee.class).list();
        session.close();
        return employeeList;
    }
        /*
        can't understand this...
        simpler solution must exist
         */
//    protected List<Employee> getAllEmployees(){
//        Session session = sessionFactory.openSession();
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        List<Employee> employeeList;
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Employee> employeeCriteriaQuery = criteriaBuilder.createQuery(Employee.class);
//        Root<Employee> employeeRoot = employeeCriteriaQuery.from(Employee.class);
//        employeeCriteriaQuery.select(criteriaBuilder.construct())
//    }

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Employee employee = EmployeeFactory.createEmployee();
        Employee employee2 = EmployeeFactory.createEmployee();
        Employee employee3 = EmployeeFactory.createEmployee();
        Employee employee4 = EmployeeFactory.createEmployee();
        Employee employee5 = EmployeeFactory.createEmployee();
        employeeManager.setup();
//        employeeManager.create(employee);
//        employeeManager.create(employee2);
//        employeeManager.create(employee3);
//        employeeManager.create(employee4);
//        employeeManager.create(employee5);
//        Employee employee6 = new Employee();
//        employee6.setJobTitle("Journalist");
//        long id = 7;
//        employeeManager.update(id, employee6);
//        Employee employee = employeeManager.read(id);
//        employeeManager.delete(employee);
//        employeeManager.deleteAll();
//        System.out.println(employeeManager.getAll());
        employeeManager.exit();


    }
}

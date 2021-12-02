import entity.Employee;
import factory.EmployeeFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmployeeManager {

    protected SessionFactory sessionFactory;

    protected void setup(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
    }

    protected void exit(){
        sessionFactory.close();
    }

    //CRUD
    protected void create(Employee employee){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    protected Employee read(long id){
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    protected void update(long id, Employee employee){
        Employee oldEmployee = this.read(id);
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

    protected void delete(Employee employee){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Employee employee = EmployeeFactory.createEmployee();
        System.out.println(employee);
        Employee employee2 = EmployeeFactory.createEmployee();
        Employee employee3 = EmployeeFactory.createEmployee();
        Employee employee4 = EmployeeFactory.createEmployee();
        Employee employee5 = EmployeeFactory.createEmployee();
        employeeManager.setup();
        employeeManager.create(employee);
        employeeManager.create(employee2);
        employeeManager.create(employee3);
        employeeManager.create(employee4);
        employeeManager.create(employee5);
        employeeManager.read(employee.getID());

    }
}

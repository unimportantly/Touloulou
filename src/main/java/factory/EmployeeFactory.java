package factory;

import entity.Employee;

public class EmployeeFactory {


     /**
      * creates different employees from lists
      * @return a new employee with distinct attributes
      */
    public static Employee createEmployee(){
         // lists to pick from
         String[] lastnameList = {"Abbott", "Rivermore", "Longbottom", "Pline", "Fitz", "Lumn", "Postia", "Rossi", "Marnor", "Plum"};
         String[] firstnameList = {"Adrian", "Marc", "Jean", "Albus", "Peter", "Jack", "Percy", "Rose", "Emily", "Georgia"};
         String[] emailList = {"blah", "blah blah", "blah blah blah", "blah blah blah blah", "blah blah blah blah blah",
                 "email", "email email", "email email email", "email email email email", "email email email email email"};
         int[] ageList = {12, 44, 56, 32, 29, 12, 44, 56, 32, 29};
         String[] jobTitleList = {"CFO", "CEO", "Dev", "Cook", "Gardener", "Teacher", "Plumber", "Real estate agent", "Spy", "Singer"};
         String[] addressList = {"blah", "blah blah", "blah blah blah", "blah blah blah blah", "blah blah blah blah blah",
                 "address", "address blah", "address blah blah", "address blah blah blah", "address blah blah blah blah"};;
         String[] phoneNumberList = {"000000000","654846515","6543518438","351844351","6879999",
                 "000111100","77746515","6888888358","3555534351","68333339"};

         // create a new empty employee object
         Employee employee = new Employee();
         // adds values to the employee's attributes
         employee.setJobTitle(jobTitleList[randomInt()]);
         employee.setPhoneNumber((phoneNumberList[randomInt()]));
         employee.setLastname(lastnameList[randomInt()]);
         employee.setFirstname(firstnameList[randomInt()]);
         employee.setEmail(emailList[randomInt()]);
         employee.setAge(ageList[randomInt()]);
         employee.setAddress(addressList[randomInt()]);

         return employee;
    }

     /**
      * get a random int between 0 & 9
      * @return a number
      */
    public static int randomInt(){
         return (int) (Math.random() * 10 - 1);
    }
}

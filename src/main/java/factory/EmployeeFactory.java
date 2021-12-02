package factory;

import entity.Employee;

public class EmployeeFactory {


    public static Employee createEmployee(){
         String[] lastnameList = {"Abbott", "Rivermore", "Longbottom", "Pline", "Fitz", "Abbott", "Rivermore", "Longbottom", "Pline", "Fitz"};
         String[] firstnameList = {"Adrian", "Marc", "Jean", "Albus", "Peter", "Adrian", "Marc", "Jean", "Albus", "Peter"};
         String[] emailList = {"blah", "blah blah", "blah blah blah", "blah blah blah blah", "blah blah blah blah blah",
                 "blah", "blah blah", "blah blah blah", "blah blah blah blah", "blah blah blah blah blah"};
         int[] ageList = {12, 44, 56, 32, 29, 12, 44, 56, 32, 29};
         String[] jobTitleList = {"CFO", "CEO", "Dev", "Cook", "Gardener", "CFO", "CEO", "Dev", "Cook", "Gardener"};
         String[] addressList = {"blah", "blah blah", "blah blah blah", "blah blah blah blah", "blah blah blah blah blah",
                 "blah", "blah blah", "blah blah blah", "blah blah blah blah", "blah blah blah blah blah"};;
         String[] phoneNumberList = {"00000000000","654846515","654351358438","35184834351","687689999",
                 "00000000000","654846515","654351358438","35184834351","687689999"};

         int pick = (int) (Math.random() * 10 - 1);

         Employee employee = new Employee();

         employee.setJobTitle(jobTitleList[pick]);
         employee.setPhoneNumber((phoneNumberList[pick]));
         employee.setLastname(lastnameList[pick]);
         employee.setFirstname(firstnameList[pick]);
         employee.setEmail(emailList[pick]);
         employee.setAge(ageList[pick]);
         employee.setAddress(addressList[pick]);

         return employee;
    }
}

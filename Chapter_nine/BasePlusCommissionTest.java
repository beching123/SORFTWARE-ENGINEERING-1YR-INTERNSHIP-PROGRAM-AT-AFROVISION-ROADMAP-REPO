package Chapter_nine;
// Fig. 9.7: BasePlusCommissionEmployeeTest.java
// BasePlusCommissionEmployee test program.

public class BasePlusCommissionTest {
  
  public static void main(String[] args) {

    // instantiate BasePlusCommissionEmployee object
    ModifiedBasePlusCommissionEmployee employee = new ModifiedBasePlusCommissionEmployee ("Bob", "Lewis", "333-33-3333", 5000, .04, 300);

    // get base salaried commission employee data
    System.out.println("Employee information obtained by get methods:%n");

    System.out.printf("%s %s%n", "First    name is ", employee.employee1.getFirstName());

    System.out.printf("%s %s%n", "Last name is", employee.employee1.getLastName());

    System.out.printf("%s %s%n", "Social security number is", employee.employee1.getSocialSecurityNumber());
    
    System.out.printf("%s %.2f%n", "Gross sales is", employee.employee1.getGrossSales());
    
    System.out.printf("%s %.2f%n", "Commission rate is", employee.employee1.getCommissionRate());
    
    System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());

    employee.setBaseSalary(1000);

    
    System.out.printf("%n%s: %n%n%s%n", "Update employee information obtain by toString", employee.toString());
  } // end main
}  // end class BasePlusCommissionEmployeeTest

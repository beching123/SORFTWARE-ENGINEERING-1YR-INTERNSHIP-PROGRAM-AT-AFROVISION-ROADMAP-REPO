// Test application for Exercise 5.29

public class AutopolicyModifiedTest {

  public static void main(String[] args) {

    // create two AutoPolicy objects
    AutopolicyModified policy1 = 
      new AutopolicyModified(11111111, "Toyota Camry" , "NJ");
    AutopolicyModified policy2 = 
      new AutopolicyModified(222222222, "Ford Fusion", "ME");

      policy1.setState("Nx");

    //display whether each policy is in a no-fault state
    policyInNoFaultState(policy1);
    policyInNoFaultState(policy2);
  }

  // method that displays whether an Autopolicy
  // is in a state with no-fault auto insurance
  public static void policyInNoFaultState(AutopolicyModified policy) {
    System.out.println("The auto policy: ");
    System.out.printf(
      "Account #: %d; Car: %s; State %s %s a no-fault state%n%n", policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(), (policy.isNoFaultState() ? "is": "is not"));
  }
} // end class Autopolicy

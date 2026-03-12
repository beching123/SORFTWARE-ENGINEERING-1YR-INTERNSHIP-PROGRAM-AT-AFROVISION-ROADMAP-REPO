// Exercise 5.29 modification of autopolicy.java in fig 5.11
// class that represent an auto insurance policy.

public class AutopolicyModified {

  private int accountNumber; // policy account number
  private String makeAndModel; // car that the policy applies to 
  private String state; // two-letter state abbreviation

  //constructor
  public AutopolicyModified(int accountNumber, String makeAndModel, String state) {

    this.accountNumber = accountNumber;
    this.makeAndModel = makeAndModel;
    this.state = state;

  }

  // sets the accountNumber
  public void setAccountNumber(int accountNumber) {

    this.accountNumber = accountNumber;

  }

  // return accountNumber
  public int getAccountNumber () {

    return accountNumber;
  }

  // sets makeAndModel
  public void setMakeAndModel(String makeAndModel) {

    this.makeAndModel = makeAndModel;

  }

  // return makeAndModel
  public String getMakeAndModel() {

    return makeAndModel;
  }

  //sets the state 
  public void setState(String state) {

    if (state == "CT" || state == "MA" || state == "ME" || state == "NH" || state == "NJ" || state == "NY" || state == "PA" || state == "VT")
      this.state = state;
    else 
      System.out.println("Error! Invalid state");
  }

  //return the state
  public String getState() {

    return state;
  }
  
  //predicate method returns whether the state has no-fault insurance
  public boolean isNoFaultState() {

    boolean noFaultState;

    //determine whether state has no-fault auto insurance
    switch (getState()) {
      case "CT": case "ME": case "NH": case "VT": case "MA":  case "NJ": case "NY": case "PA": 
        noFaultState = true;
        break;
      default: 
        noFaultState = false;
        break;
    }

    return noFaultState;
  }
} // end class Autopolicy

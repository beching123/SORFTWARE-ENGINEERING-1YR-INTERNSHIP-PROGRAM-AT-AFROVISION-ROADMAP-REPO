// Exercise 8.13 Set of integers
package Chapter_eight;

public class IntegerSet { // class integerSet to hold integers

  public static final int RANGE = 101; // instance variable used to hold the range of integer and object of integerSet can hold
  private boolean[] set; // our set which will be used to hold our integer variables

  // no argument constructor
  public IntegerSet () {

    set = new boolean[RANGE];

    // initializing set elements to false
    for (int i = 0; i < RANGE; i ++) {
      set[i] = false;
    }
  }

  // get method for our set array
  public boolean[] getSet() {

    return set;
  }

  // static method union used to know the union between two or more set
  public static boolean[] union (boolean[] set1, boolean[] set2) {

    // variable set3 used to hold the union between two set
    boolean[] set3 = new boolean[RANGE];

    // loop used to filled our new set with the union of the set1 and later set2
    for (int i = 0; i < RANGE; i ++) {

      if (set1[i] == true || set2[i] == true)
        set3[i] = true;
      else 
        set3[i] = false;
    }

    return set3;
  }

    public static boolean[] intersection (boolean[] set1, boolean[] set2) {

    // variable set3 used to hold the intersection between the two set
    boolean[] set3 = new boolean[RANGE];

    // loop used to filled our new set with the element both set have in common
    for (int i = 0; i < RANGE; i ++) {

      if ((set1[i] == true) && (set2[i] == true))
        set3[i] = true;
      else 
        set3[i] = false;
    }

    return set3;
  }

  // method used to determine whether two sets are equal
  public static boolean isEqual(boolean[] set1, boolean[] set2) {

    // this loops runs and check if the two set are not equal if true the loop returns false
    for (int i = 0; i < RANGE; i ++) {

      if ((set1[i] == true && set2[i] == false) || (set1[i] == false && set2[i] == true))
        return false;
    }

    return false;
  }

  // method used to inset element into our set
  public void insertElement (int index) {

    // making sure is an in bound element
    if (index < 0 || index >= RANGE) {
      System.out.println("\nInvalid index!");
    }

    else set[index] = true;
  }

  // method used to delete element from our set
  public void deleteElement(int index) {

    // making sure is an in bound element
    if (index < 0 || index >= RANGE) {
      System.out.println("\nInvalid Index!");
    }

    else set[index] = false;
  }

  // to string method used to return the string representation of our object
  public static String toString(boolean[] set) {

    String setString = "{ ";


    // this loop is used to go through our set and look for the index whose element is true and concatenate  it to the setString variable
    for (int i = 0; i < RANGE; i ++) {
 
      if (set[i] == true) {
        setString += i + " ";
      }
    }

    // for empty set
    if (setString.length() == 2)
      return setString + "--- }";

    return setString + " }";
  }
}
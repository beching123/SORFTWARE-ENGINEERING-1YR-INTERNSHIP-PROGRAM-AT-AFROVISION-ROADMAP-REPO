// class integerSetTest.java used to test our integerSetApplication
package Chapter_eight;

//import java.util.Scanner; 

public class IntegerSetTest {


  public static void main(String[] args) {

    // instantiating our integer sets
    IntegerSet set1 = new IntegerSet();
    IntegerSet set2 = new IntegerSet();

    // loop used to fill our sets with even (set1) and odd (set2) number
    for (int i = 0; i < IntegerSet.RANGE; i ++) {

      if (i % 2 == 0)
        set1.insertElement(i);
      else 
        set2.insertElement(i);
    }

    // printing set1
    System.out.printf("\nSet1: %s\n", IntegerSet.toString(set1.getSet()));

    // printing set2
    System.out.printf("\nSet2: %s\n", IntegerSet.toString(set2.getSet()));

    // computing to check if set one and two are equal
    System.out.printf("\nSet1 and Set2 are equal ? %s", IntegerSet.isEqual(set1.getSet(), set2.getSet()));

    // computing the  union between set one and two
    System.out.printf("\nThe union between the two sets: %s\n", IntegerSet.toString(IntegerSet.union(set1.getSet(), set2.getSet())));

    // computing the  intersection between set one and two
    System.out.printf("\nThe intersection between the two sets: %s", IntegerSet.toString(IntegerSet.intersection(set1.getSet(), set2.getSet())));
  }
}
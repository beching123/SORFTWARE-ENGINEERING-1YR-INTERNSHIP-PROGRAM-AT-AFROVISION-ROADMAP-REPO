#include <stdio.h> // Pre-processor directive that are executed first

int main() { // execution of the c program begins from this function

  // variable to hold the used in our program
  int customer;
  int unitConsumed;
  int cost;
  int additionalCost;
  int monthlyWaterBill;

  //printing a notification message to the user
  printf("When you see enter customer, if you wish to terminate the program enter -1\n\n");

  do { // using a do while loop so we can do it at least once before we continue

    //prompting the user to enter the customer number
    printf("Enter customer number of -1 to stop: ");// only ask the use to enter number
    scanf("%d", &customer);// store the number enter by the user in the memory location &customer

    // checking for the value entered and stored in customer
    if (customer != -1){ // the statement in this if is done only when the condition is true


      printf("Enter the unit consumed by customer %d: ", customer);// prompting the user to enter the number of water unit consumed
      scanf("%d", &unitConsumed); // collecting the actual unit entered by the user

      // the if below is inside the if above because they are all enclosed in the braces
      // negative unit are not allowed so we check if the unit entered by the customer is negative they enter a new one
      if (unitConsumed < 0){ // this if is done only if the condition is true

        printf("Error! Invalid unit entered, enter a new unit: "); // prompting the user to enter a new unit
        scanf("%d", &unitConsumed); // collecting the actual new unit entered
      } // if the condition in the if above is false the if will no be done

      // the else  if will be done instead where a new condition is tested
      else if (unitConsumed <= 30){
        cost = 200; // assigning to given the cost a value of 200fcfa as mentioned in the question
        monthlyWaterBill = unitConsumed * cost; // calculating the water bill
        printf("Your Monthly water Bill: %d\n\n", monthlyWaterBill); // outputting the water bill to the user to see
      }
      // if the condition in the else if above is false this one will be done
      else if (unitConsumed > 30){

        cost = 200; // assigning cost to 200fcfa fo the first 30 units as the question asked
        additionalCost = 300; // price for the extra unit after 30 units
        monthlyWaterBill = (cost * 30) + ((unitConsumed - 30) * additionalCost); // unlike the first formula above this one includes the price of the additional unit consumed
        printf("Your Monthly Water Bill: %d\n\n", monthlyWaterBill);
      }
    }

    // the else below is for the first if above
    // it is executed when the user enters -1
    else {
      printf("\nThere are no more customers!");
    }

  }

  // the while part of the do while loop, it is reponsible for
  // testing the ending condition and stopping the loop
  while (customer != -1);
  return 0;
}

/* // fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing

public class DeckOfClassTest {

  private static int[] faceCount = new int[13];
  private static int[] suitCount = new int[4];
  private static boolean[] shouldKeepFace = new boolean[];


  // execute application
  public static void main(String[] args) {

    DeckOfCards myDeckOfCards = new DeckOfCards();
    myDeckOfCards.shuffle(); // place Cards in random order

    Card[] playerHand = new Card[5];
    Card[] dealerHand = new Card[5];        

    for (int i = 0; i < 5; i ++){

        playerHand[i] = myDeckOfCards.dealCard();
    }

    for (int i = 0; i < 5; i ++) {
      dealerHand[i] = myDeckOfCards.dealCard();
    }


    displayHand(playerHand);
    System.out.println();

    scanner(playerHand);
  }

  public static void displayHand(Card[] hand) {

    for (int i = 0; i < 5; i ++) {
      System.out.printf("\n%-19s", hand[i]);
    }
    System.out.println();
  } 

  public static void scanner(Card[] hand) {

    for (int i = 0; i < 5; i ++) {

      ++ faceCount[hand[i].getFace()];
      ++ suitCount[hand[i].getSuit()];

    }

    //for (int i = 0; i < 13; i ++)
      //System.out.printf("%d\t", faceCount[i]);

    System.out.println();
    
    if (isFourOfItsKind())
      System.out.println("Four of a kind! (Four cards with the same face)");

    else if (isFullHouse())
      System.out.println("Full House! (Three of a kind + A pair)");

    else if (isAFlush())
      System.out.println("A Flush! (All five cards have same suit)");
    
    else if (isAStraight())
      System.out.println(" A Straight! (Five cards have the same suit)");

    else if (isThreeOfItsKind())
      dealerEvaluation(0);

    else if (isTwoPairs())
      System.out.println("Two Pairs! (Exactly two cards with the same face");

    else if (isPair()) 
      System.out.println("A Pair! (Exactly two cards with the same face)");

    else 
      System.out.println("High Card (No matching patterns found)");

  }

  // a pair
  public static boolean isPair() {
    
    for (int i = 0; i < 13; i ++) {
      if (faceCount[i] == 2)
        return true; 
    }
    return false;
  }

  // double pair
  public static boolean isTwoPairs() {

    int pairCount = 0; 

    for (int i = 0; i < 13; i ++)
      if (faceCount[i] == 2)
        pairCount ++;
      
    if (pairCount == 2)
      return true;

    return false;
  }

  // three of it's kind
  public static boolean isThreeOfItsKind() {

    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 3)
        return true;
    }

    return false;

  }

  // four of it's kind
  public static boolean isFourOfItsKind() {

    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 4)
        return true;
    }

    return false;
  }

  // a flush five of suit
  public static boolean isAFlush() {

    for (int i = 0; i < 4; i ++) {

      if (suitCount[i] == 5)
        return true;
    }

    return false;
  }

  // a straight five of face
  public static boolean isAStraight() {

    int counter = 0;
    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 1) {
        counter ++;
      }

      else if ((faceCount[i] == 0 || faceCount[i] > 1) && (counter != 5)){
        counter = 0;
      }

      if (counter == 5){
        break;

      }
    }
    if (counter == 5)
      return true;
    
    return false;
    
  }
  
  // full house 
  public static boolean isFullHouse() {

    int twoFaceValue = 0;
    int threeFaceValue = 0;

    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 2)
        twoFaceValue ++;

      else if (faceCount[i] == 3)
        threeFaceValue ++;
    }

    if (twoFaceValue == 1 && threeFaceValue == 1)
      return true;

    return false;
  }

} // end class DeckOfCardsTest


public static void dealerBrain( Card[] dealerHand) {

  for (int i = 0; i < 13; i ++) {

    if (faceCount[i] >= 2)
      shouldKeepFace[i] = true;
  }

}*/


import java.util.Scanner;

public class DeckOfCardTest {

  // these arrays store the counts of faces and for the current hand being scanned
  private static int[] faceCount = new int[13];
  private static int[] suitCount = new int[5];

  public static void main (String[] args) {

    // setup the game
    DeckOfCards myDeckOfCards = new DeckOfCards();
  

    // Initialize hands for 5 cards each
    Card[] playerHand = new Card[5];
    Card[]  dealerHand = new Card[5];

    int playerWins = 0; 
    int dealerWins = 0;

    for (int game = 1; game <= 20; game ++) {

      System.out.printf("%n --- GAME %d of 20 --- %n", game);

      myDeckOfCards.shuffle(); // randomize the deck

      // deal cards (alternating between player and dealer)
      int p = 0; // player index
      int d = 0; // dealer index

      for (int i = 1; i <= 10; i ++) {
        if (i % 2 != 0){
          playerHand[p ++] = myDeckOfCards.dealCard();
        } else {
          dealerHand[d ++] = myDeckOfCards.dealCard();
        }
      }
      
      System.out.printf("\nYour Hand: ");
      displayHand(playerHand);
      System.out.println();


      playerTurn(playerHand, myDeckOfCards);
      dealerTurn(dealerHand, myDeckOfCards); 
      System.out.println();

      System.out.printf("\nDealer Hand: ");
      displayHand(dealerHand);
      System.out.println();

      int pScore = getHandValue(playerHand);
      int dScore = getHandValue(dealerHand);

      if (pScore > dScore) {
        
        playerWins ++;
        System.out.println("\nYou won this round!");
      } else if (dScore > pScore) {
        dealerWins ++;
        System.out.println("\nDealer won this round!");
      } else {
        System.out.println("\nIt's a Tie!");
      }
    }

    System.out.println("\n ==========================================");
    System.out.printf("%nFinal Score -> You: %d | Dealer: %d%n", playerWins, dealerWins);
        System.out.println("\n ==========================================");

   /*  // show player's Hand
    System.out.println("--- YOUR HAND ---");
    displayHand(playerHand);

    // evaluate player's Hand(This fills the faceCont / suitCount array)
    resetCounts() ; // Ensure arrays are 0 before scanning
    scanner (playerHand);
    System.out.print("Result: ");
    printHandStrength(); // Tells the player what they have (Pair, etc.)

    // Dealer's turn (using the AI logic)
    System.out.println("\n--- DEALER IS THINKING ---");
    dealerTurn(dealerHand, myDeckOfCards);

    // final showdown
    System.out.println("\n --- FINAL DEALER HAND ---");
    displayHand(dealerHand);
    resetCounts();
    scanner(dealerHand);
    System.out.print("Dealer Final Result: ");
    printHandStrength(); */
  }

  // the brain: decides which cards the dealer should replace
  public static void dealerTurn(Card[] hand, DeckOfCards deck) {

    resetCounts();
    scanner(hand); // Analyze the dealer's current cards

    // If the dealer already has a very strong hand, they change NOTHING (0 cards)
    if (isAFlush() || isAStraight() || isFullHouse()) {
      System.out.println("Dealer stays with a strong hand!");
      return;
    }

    // We use a boolean array to mark which cards are "Good" to keep
    boolean[] keep = new boolean[5];

    // looping through the 5 cards in the hand
    for (int i = 0; i < 5; i ++) {
      int face = hand[i].getFace().ordinal(); // Get the face value (0 - 12)

      // If faceCount for this card is 2 or more, it's part of pair / triple. KEEP IT.
      if (faceCount[face] >= 2) {
        keep[i] = true;
      } else {
        keep[i] = false; // This is a "junk" card
      }
    }

    // Now, replace the junk cards
    for (int i = 0; i < 5; i ++) {
      if (!keep[i]) {// if keep is false
        
        hand[i] = deck.dealCard(); // Draw a new card from the deck
        System.out.println("Dealer replaced a card.");
      }
    }
  }

  // Reset the tally arrays to zero so we don't mix old data with new data
  public static void resetCounts() {

    for (int i = 0; i < 13; i ++) 
      faceCount[i] = 0;

    for (int i = 0; i < 5; i ++)
      suitCount[i] = 0;
  }

  // this method fills our tally arrays based on the hand provided 
  public static void scanner(Card[] hand) {

    for (int i = 0; i < 5; i ++) {
      faceCount[hand[i].getFace().ordinal()] ++; // incrementing the count for that face
      suitCount[hand[i].getSuit().ordinal()] ++; // incrementing the count for that suit
    }
  }

  // Display the hand in a readable format
  public static void displayHand(Card[] hand) {

    for (int i = 0; i < 5; i ++) {

      System.out.printf("%-19s", hand[i]);
    }
    System.out.println();
  }

  // Helper to print the test description of the hand
  public static void printHandStrength() {

     if (isFourOfItsKind())
      System.out.println("Four of a kind! (Four cards with the same face)");

    else if (isFullHouse())
      System.out.println("Full House! (Three of a kind + A pair)");

    else if (isAFlush())
      System.out.println("A Flush! (All five cards have same suit)");
    
    else if (isAStraight())
      System.out.println(" A Straight! (Five cards have the same suit)");

    else if (isThreeOfItsKind())
      System.out.print(" Three of it's kind (Three cards have same face)");

    else if (isTwoPairs())
      System.out.println("Two Pairs! (Exactly two cards with the same face");

    else if (isPair()) 
      System.out.println("A Pair! (Exactly two cards with the same face)");

    else 
      System.out.println("High Card (No matching patterns found)");
  }

   // a pair
  public static boolean isPair() {
    
    for (int i = 0; i < 13; i ++) {
      if (faceCount[i] == 2)
        return true; 
    }
    return false;
  }

  // double pair
  public static boolean isTwoPairs() {

    int pairCount = 0; 

    for (int i = 0; i < 13; i ++)
      if (faceCount[i] == 2)
        pairCount ++;
      
    if (pairCount == 2)
      return true;

    return false;
  }

  // three of it's kind
  public static boolean isThreeOfItsKind() {

    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 3)
        return true;
    }

    return false;

  }

  // four of it's kind
  public static boolean isFourOfItsKind() {

    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 4)
        return true;
    }

    return false;
  }

  // a flush five of suit
  public static boolean isAFlush() {

    for (int i = 0; i < 4; i ++) {

      if (suitCount[i] == 5)
        return true;
    }

    return false;
  }

  // a straight five of face
  public static boolean isAStraight() {

    int counter = 0;
    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 1) {
        counter ++;
      }

      else if ((faceCount[i] == 0 || faceCount[i] > 1) && (counter != 5)){
        counter = 0;
      }

      if (counter == 5){
        break;

      }
    }
    if (counter == 5)
      return true;
    
    return false;
    
  }
  
  // full house 
  public static boolean isFullHouse() {

    int twoFaceValue = 0;
    int threeFaceValue = 0;

    for (int i = 0; i < 13; i ++) {

      if (faceCount[i] == 2)
        twoFaceValue ++;

      else if (faceCount[i] == 3)
        threeFaceValue ++;
    }

    if (twoFaceValue == 1 && threeFaceValue == 1)
      return true;

    return false;
  }

  // method to let the human player choose cards to replace
  public static void playerTurn(Card[] hand, DeckOfCards deck) {

    Scanner input = new Scanner(System.in); // Line A: Create scanner for user input
    System.out.println("Enter the numbers (0 - 4) of cards you want to REPLACE (separate by space), or -1 to keep all: "); 
    String choice = input.nextLine(); // Line B: Read the entire line of user choices

    if (!choice.equals("-1")) { // Line C: If user doesn't want to keep all 

      String[] parts = choice.split(" "); // Line D: split the string into individuals numbers

      for (String part: parts) {
        int index = Integer.parseInt(part); // converting from character to number

        if (index >= 0 && index < 5) { // within the bounds
          hand[index] = deck.dealCard(); // replacing card
        }
      }
    }
  }


  public static int getHandValue(Card[] hand) {

    resetCounts(); 
    scanner(hand);

    if (isFourOfItsKind()) return 7;
    if (isFullHouse()) return 6;
    if (isAFlush()) return 5;
    if (isAStraight()) return 4;
    if (isThreeOfItsKind()) return 3;
    if (isTwoPairs()) return 2;
    if (isPair()) return 1;

    return 0;

  }
} // end class DeckOfCardsTest

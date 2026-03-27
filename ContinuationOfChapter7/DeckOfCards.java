// fig. 7.10: DeckOfCards.java
// DEckOfCards class represents a deck of playing cards
import java.security.SecureRandom;

public class DeckOfCards {

  private Card[] deck; //array of Card objects
  private int currentCard; // index of next Card be dealt (0-5)
  private static final int NUMBER_OF_CARDS = 52; // constant # of Cards 
  //random number generator
  private static final SecureRandom randomNumber = new SecureRandom();

  // constructor fills deck of Cards 
  public DeckOfCards () {

    Face[] face = Face.values();
    Suit[] suit = Suit.values();

    deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
    currentCard = 0; // first card dealt will be deck[0]

    // populate deck with Card objects
    for (int count = 0; count < deck.length; count++) {
      deck[count] = new Card(face[count % 13], suit[count / 13]);

    }
  }
  // shuffle deck of Cards with one-pass algorithm
  public void shuffle() {

    // next call to method dealCard should start at deck[0] again
    currentCard = 0;

    // for each Card, pick another random Card (0 - 51) and swap them
    for (int i = deck.length - 1; i >= 0; i --) {

      // select a random number between 0 - 51
      int j = randomNumber.nextInt(i + 1);

      // swap current Cards with remain to be dealt
      Card temp = deck[i];
      deck[i] = deck[j];
      deck[j] = temp;

    }
  }

  // deal one Card
  public Card dealCard() {

    // determine whether CArds remain to be dealt
    if (currentCard < deck.length)
      return deck[currentCard ++]; // return current CArd in Array
    else 
      return null; // return null to indicate that all Cards were dealt
  }
} // end class DeckOfCards


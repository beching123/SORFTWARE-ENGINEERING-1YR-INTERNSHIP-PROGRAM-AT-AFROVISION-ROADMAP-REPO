package ContinuationOfChapter7;
// Fig. 2.9: Card.java
// Card class represents a playing card.

public class Card {

  private final Face face; // face of card ("ACE", "Deuce"...)
  private final Suit suit; // suit of card ("Hearts", "Diamonds", ...)

  // two-argument constructor initializes card's face and suit
  public Card(Face cardFace, Suit cardSuit) {

    this.face = cardFace; // initialize face of card
    this.suit = cardSuit; // initialize suit of card
  }

  // return String representation of Card
  public String toString() {

    return face + " of " + suit;

  }

  public Face getFace() {
    return face;
  }

  public Suit getSuit() {
    
    return suit;
  }
} // end class Card

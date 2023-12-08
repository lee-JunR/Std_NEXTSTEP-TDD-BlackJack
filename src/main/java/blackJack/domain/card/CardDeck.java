package blackJack.domain.card;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {

  private Stack<Card> cards;

  public CardDeck() {
    this.cards = this.generateCards();
    Collections.shuffle(this.cards);
  }

  private Stack<Card> generateCards() {
    Stack<Card> cards = new Stack<>();

    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        cards.push(card);
      }
    }
    return cards;
  }

  public Stack<Card> getCards() {
    return cards;
  }

  public Card draw() {
    return this.cards.pop();
  }
}
package blackJack.domain;

import java.util.Objects;

public class Card {
  private int index;
  private Suit suit;

  public Card(int index, Suit suit) {
    this.index = index;
    this.suit = suit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return index == card.index && suit == card.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, suit);
  }
}

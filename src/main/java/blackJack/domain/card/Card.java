package blackJack.domain.card;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Map<Rank, Suit> getCard() {
    Map<Rank, Suit> card = new HashMap<>();
    card.put(rank, suit);
    return card;
  }

  public int getPoint() {
    return rank.getPoints();
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
    return rank == card.rank && suit == card.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, suit);
  }
}

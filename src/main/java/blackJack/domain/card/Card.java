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

  // TODO : 설계 의심 ace 부분 1점으로 박아놓고 그 판단을 점수에서 하는게 맞을지? 아니면 card에서 하는게 나을지?
  public int getPoint() {
    if (isRankAce()) {
      return rank.getPoints(true);
    }
    return rank.getPoints(false);
  }

  private boolean isRankAce() {
    return rank == Rank.ACE;
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

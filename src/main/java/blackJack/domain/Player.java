package blackJack.domain;

import blackJack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

  private String name;
  private List<Card> cards = new ArrayList<>();

  public Player(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("형식에 맞지 않는 이름입니다.");
    }
  }

  public String name() {
    return this.name;
  }

  public void giveInitCards(List<Card> initCards) {
    this.cards.addAll(initCards);
  }

  public List<Card> getCards() {
    return this.cards;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(name, player.name) && Objects.equals(cards,
        player.cards);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cards);
  }
}

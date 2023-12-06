package blackJack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

  private String name;
  private List<String> cards = new ArrayList<>();

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

  public void giveInitCards(List<String> initCards) {
    this.cards.addAll(initCards);
  }

  public List<String> getCards() {
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

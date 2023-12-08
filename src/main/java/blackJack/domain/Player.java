package blackJack.domain;

import blackJack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// TODO : Plater 클래스를 인터페이스로 생성하고 dealer 와 player 로 메소드 구분해서 넣는것도 고려할 것.
public class Player {

  public static final String DUPLICATED_CARDS_ERROR_MESSAGE = "중복된 카드를 핸드에 넣을 수 없습니다.";
  public static final String INVALID_NAME_ERROR_MESSAGE = "형식에 맞지 않는 이름입니다.";
  private String name;
  private List<Card> hand = new ArrayList<>();

  public Player(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
    }
  }

  public String name() {
    return this.name;
  }

  public void drawCard(Card card) { // 카드 한장 지급
    hand.add(card);
    validateCards(hand);
  }

  // TODO : 생성자로 넣을까..?
  public void drawInitialCards(List<Card> initCards) { // 카드 두장 지급
    validateCards(initCards);
    this.hand.addAll(initCards);
  }

  private void validateCards(List<Card> hand) {
    if (hand.size() != hand.stream().distinct().count()) {
      throw new IllegalArgumentException(DUPLICATED_CARDS_ERROR_MESSAGE);
    }
  }

  public List<Card> getHand() {
    return this.hand;
  }

  public int getScore() {
    int totalScore = hand.stream()
        .mapToInt(Card::getPoint)
        .sum();
    return totalScore;
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
    return Objects.equals(name, player.name) && Objects.equals(hand,
        player.hand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hand);
  }
}

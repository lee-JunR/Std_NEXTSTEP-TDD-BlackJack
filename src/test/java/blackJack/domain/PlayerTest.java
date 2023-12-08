package blackJack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import blackJack.domain.card.Card;
import blackJack.domain.card.Rank;
import blackJack.domain.card.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  private Player player;

  @BeforeEach
  void setUp() {
    player = new Player("John");
  }

  @Test
  @DisplayName("플레이어_생성")
  void 플레이어_생성() {
    assertEquals("John", player.name());
  }

  @Test
  @DisplayName("카드 두장 지급")
  void 카드_두장_뽑기() {
    //given
    List<Card> initialCards = Arrays.asList(new Card(Rank.ACE, Suit.DIAMOND),
        new Card(Rank.FOUR, Suit.CLOVER));

    //when
    player.drawInitialCards(initialCards);

    //then
    assertEquals(initialCards, player.getHand());
  }

  @Test
  @DisplayName("중복된_카드를_지급받을_시_에러")
  void 중복된_카드를_지급받을_시_에러() {
    // when
    List<Card> duplicatedCards = Arrays.asList(new Card(Rank.FOUR, Suit.CLOVER),
        new Card(Rank.FOUR, Suit.CLOVER));

    // then
    Assertions.assertThrows(IllegalArgumentException.class, () -> player.drawInitialCards(duplicatedCards));

  }

  @Test
  @DisplayName("카드_한장_지급")
  void 카드_한장_지급() {
    // given
    List<Card> cardSet = new ArrayList<>();
    cardSet.add(new Card(Rank.ACE, Suit.DIAMOND));
    cardSet.add(new Card(Rank.FOUR, Suit.CLOVER));
    player.drawInitialCards(cardSet);

    // when
    cardSet.add(new Card(Rank.ACE, Suit.SPADE));
    player.drawCard(new Card(Rank.ACE, Suit.SPADE));

    // then
    assertEquals(cardSet, player.getHand());
  }

  @Test
  @DisplayName("기존_핸드와_중복된_카드_지급시_에러")
  void 기존_핸드와_중복된_카드_지급시_에러() {
    // given
    List<Card> cardSet = new ArrayList<>();
    cardSet.add(new Card(Rank.ACE, Suit.DIAMOND));
    cardSet.add(new Card(Rank.FOUR, Suit.CLOVER));
    player.drawInitialCards(cardSet);

    // when
    Card duplicatedCard = new Card(Rank.ACE, Suit.DIAMOND);

    // then
    Assertions.assertThrows(IllegalArgumentException.class, () -> player.drawCard(duplicatedCard));

  }
}

package blackJack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import blackJack.domain.card.Card;
import blackJack.domain.card.Rank;
import blackJack.domain.card.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class playerTest {

  @Test
  @DisplayName("Create_Player")
  void Create_Player() {
    Player player = new Player("John");
    assertEquals("John", player.name());
  }

  @Test
  @DisplayName("카드 두장 지급")
  void 카드_두장_뽑기() {
    //given
    Player player = new Player("John");
    List<Card> initialCards = Arrays.asList(new Card(Rank.ACE, Suit.DIAMOND),
        new Card(Rank.FOUR, Suit.CLOVER));

    //when
    player.giveCards(initialCards);

    //then
    assertEquals(initialCards, player.getCards());
  }

  @Test
  @DisplayName("카드_한장_지급")
  void 카드_한장_지급() {
    // given
    Player player = new Player("John");
    List<Card> cardSet = new ArrayList<>();
    cardSet.add(new Card(Rank.ACE, Suit.DIAMOND));
    cardSet.add(new Card(Rank.FOUR, Suit.CLOVER));
    player.giveCards(cardSet);

    // when
    cardSet.add(new Card(Rank.ACE, Suit.SPADE));
    player.giveCards(new Card(Rank.ACE, Suit.SPADE));

    System.out.println(player.getCards().toString());
    // then
    assertEquals(cardSet, player.getCards());
  }
}

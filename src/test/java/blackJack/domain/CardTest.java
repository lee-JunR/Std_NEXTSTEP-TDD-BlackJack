package blackJack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.font.TrueTypeFont;

public class CardTest {

  @Test
  @DisplayName("Create_CARD")
  void Create_CARD() {
    Card card = new Card(Rank.THREE, Suit.DIAMOND);
    assertEquals(new Card(Rank.THREE, Suit.DIAMOND), card);
  }

  @Test
  @DisplayName("카드_점수_확인")
  void 카드_점수_확인() {
    // given
    Card card = new Card(Rank.JACK, Suit.SPADE);

    // when
    int jackPoint = 10;

    // then
    assertEquals(jackPoint, card.getPoint());
  }
}
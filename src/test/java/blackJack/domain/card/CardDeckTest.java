package blackJack.domain.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

  @Test
  @DisplayName("카드덱이_완전한지_확인")
  void 카드덱이_완전한지_확인() {
    // given
    CardDeck deck = new CardDeck();
    // when
    int count = 0;
    while (!deck.getCards().empty()) {
      count ++;
    }
    // then
    assertEquals(count, 52);
  }
}

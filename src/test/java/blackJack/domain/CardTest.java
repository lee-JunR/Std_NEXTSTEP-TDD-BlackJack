package blackJack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {
  @Test
  @DisplayName("Create_CARD")
  void Create_CARD(){
    Card card = new Card(3, Suit.DIAMOND);
    assertEquals(new Card(3, Suit.DIAMOND), card);
  }


}

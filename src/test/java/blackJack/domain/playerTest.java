package blackJack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @DisplayName("카드_가지게_하기")
  void 카드_가지게_하기() {
    Player player = new Player("John");
    List<String> initialCards = Arrays.asList("3다이아몬드", "A클로버");
    player.giveInitCards(initialCards);
    assertEquals(initialCards, player.getCards());
  }
}

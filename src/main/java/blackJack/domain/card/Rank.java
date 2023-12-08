package blackJack.domain.card;

public enum Rank {
  ACE("Ace", 1),    // Ace는 1 또는 11점
  TWO("Two", 2),
  THREE("Three", 3),
  FOUR("Four", 4),
  FIVE("Five", 5),
  SIX("Six", 6),
  SEVEN("Seven", 7),
  EIGHT("Eight", 8),
  NINE("Nine", 9),
  TEN("Ten", 10),
  JACK("Jack", 10),
  QUEEN("Queen", 10),
  KING("King", 10);

  private final String displayName;
  private final int points;


  Rank(String displayName, int points) {
    this.displayName = displayName;
    this.points = points;
  }

  public String getDisplayName() {
    return displayName;
  }

  public int getPoints() {
    return points;
  }
}

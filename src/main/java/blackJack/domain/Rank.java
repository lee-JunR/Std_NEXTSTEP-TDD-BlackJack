package blackJack.domain;

public enum Rank {
  ACE("Ace", 1, 10),    // Ace는 1 또는 10점
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
  private final int points1;  // 1로 사용할 때의 점수
  private final int points10; // 10으로 사용할 때의 점수

  Rank(String displayName, int points) {
    this(displayName, points, points);
  }

  Rank(String displayName, int points1, int points10) {
    this.displayName = displayName;
    this.points1 = points1;
    this.points10 = points10;
  }

  public String getDisplayName() {
    return displayName;
  }

  public int getPoints(boolean useAceAsTen) {
    return useAceAsTen ? points10 : points1;
  }
}

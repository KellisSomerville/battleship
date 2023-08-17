public class BattleShip {
    String name;
    String[] boardLocations;
    int hits;

    public BattleShip(String name, String[] boardLocations) {
        this.name = name;
        this.boardLocations = boardLocations;
        this.hits = 0;
    }
    public String getName() {
        return name;
    }
    public boolean checkUserGuess(String userGuess) {
        for (String boardLocation : boardLocations) {
            if (boardLocation.equals(userGuess)) {
                hits++;
                return true;
            }
        }
        return false;
    }
    public boolean battleshipSunk() {
        return hits == boardLocations.length;
    }

    public String[] getBoardLocations() {
        return boardLocations;
    }
}
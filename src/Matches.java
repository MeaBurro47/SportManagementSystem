public class Matches {
    private Player[][] matches;
    private int matchesCount;

    public Matches(int capacity){
        this.matches = new Player[capacity / 2][2];
        this.matchesCount = 0;
    }

    public void matchMake(Player[] players){
        assert !players[0].isMatched() && !players[1].isMatched();

        for (int i = 0; i < 2; i++) {
            matches[this.matchesCount][i] = players[i];
            players[i].setIsMatched(true);
        }

        this.matchesCount++;
    }

    public void clearMatches(){
        for (int i = 0; i < this.matchesCount; i++) {
            for (int j = 0; j < 2; j++) {
                this.matches[i][j].setIsMatched(false);
                this.matches[i][j] = null;
            }
        }

        this.matchesCount = 0;
    }

    public void showMatches(){
        for (int i = 0; i < this.matchesCount; i++) {
            System.out.println(this.matches[i][0].getName() + " : " + this.matches[i][1].getName());
        }
    }

    public void extendCapacity(int newCapacity){
        Player[][] auxMatches = new Player[newCapacity / 2][];

        for (int i = 0; i < this.matchesCount; i++) {
            auxMatches[i] = this.matches[i];
        }

        this.matches = auxMatches;
    }
}

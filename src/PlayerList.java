import java.util.Objects;
import java.util.Random;

public class PlayerList {
    private static final int INITIAL_CAPACITY = 5;
    private Player[] list;
    private final Matches matches;
    private int playerCount;
    private int capacity;


    public PlayerList(){
        this.capacity = INITIAL_CAPACITY;
        this.list = new Player[capacity];
        this.playerCount = 0;
        this.matches = new Matches(this.capacity);
    }

    public void createPlayer(String name){
        assert this.getPlayerPosition(name) == this.playerCount;

        if(playerCount == capacity){
            this.extendCapacity();
        }

        this.list[playerCount] = new Player(name);
        playerCount++;
    }

    private int getPlayerPosition(String name){
        int i = 0;
        while(i < this.playerCount && !Objects.equals(name, this.list[i].getName())){
            i++;
        }
        return i;
    }

    private void extendCapacity(){
        this.capacity *= 2;
        Player[] auxList = new Player[this.capacity];
        for (int i = 0; i < this.playerCount; i++) {
            auxList[i] = this.list[i];
        }
        this.list = auxList;
        matches.extendCapacity(this.capacity);
    }


    public void removePlayer(String name){
        int position = this.getPlayerPosition(name);

        assert position < this.playerCount;

        this.playerCount--;
        for (int i = position; i <= this.playerCount; i++) {
            this.list[i] = this.list[i+1];
        }
    }

    public void showPlayers(){
        for (int i = 0; i < this.playerCount; i++) {
            System.out.println(this.list[i].getName());
        }
    }

    public void setPlayerScore(String name, double score){
        int position = this.getPlayerPosition(name);

        assert position < this.playerCount;

        this.list[position].setScore(score);
    }

    public void showRanking(){

        for (int i=1; i < this.playerCount; i++) {
            Player aux = this.list[i];
            int j = i;
            while (j > 0 && this.list[j-1].getScore() < aux.getScore()){
                this.list[j] = this.list[j-1];
                j--;
            }
            this.list[j]=aux;
        }

        for (int i = 0; i < this.playerCount; i++) {
            System.out.printf("%s: %.2f\n",this.list[i].getName(), this.list[i].getScore());
        }
    }

    public void createMatch(String[] names){
        int[] playerPositions = new int[2];
        for (int i = 0; i < 2; i++) {
            playerPositions[i] = this.getPlayerPosition(names[i]);
        }

        assert playerPositions[0] < this.playerCount && playerPositions[1] < this.playerCount;

        this.matches.matchMake(new Player[]{this.list[playerPositions[0]], this.list[playerPositions[1]]});
    }

    public void clearMatches(){
        this.matches.clearMatches();
    }

    public void showMatches(){
        this.matches.showMatches();
    }

    public void randomMatchMake(){
        assert this.playerCount % 2 == 0;

        for (int i = 0; i < this.playerCount/2; i++) {
            Player[] randomMatches = new Player[2];
            for (int j = 0; j < 2; j++) {
                randomMatches[j] = this.list[this.getRandomPlayer()];
            }
            this.matches.matchMake(randomMatches);
        }

    }

    private int getRandomPlayer(){
        Random random = new Random();

        int randomPlayer;
        do{
            randomPlayer = random.nextInt(this.playerCount);
        }while(this.list[randomPlayer].isMatched());

        return randomPlayer;
    }
}

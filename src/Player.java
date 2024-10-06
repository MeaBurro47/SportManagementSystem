public class Player {
    private final String name;
    private double score;
    private boolean isMatched;

    public Player(String name){
        this.name = name;
        this.score = 0.0;
        this.isMatched = false;
    }

    public String getName(){
        return this.name;
    }

    public double getScore(){
        return this.score;
    }

    public void setScore(double newScore){
        assert newScore >= -999999.0;
        this.score = newScore;
    }

    public boolean isMatched(){
        return this.isMatched;
    }

    public void setIsMatched(boolean isMatched){
        this.isMatched = isMatched;
    }

}
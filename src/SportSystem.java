public class SportSystem {
    public static void main(String[] args) {
        PlayerList playerList = new PlayerList();

        initialize(playerList);

        CommandManager.getCommand(playerList);
    }

    public static void initialize(PlayerList playerList){
        playerList.createPlayer("Luisa");
        playerList.createPlayer("Manuel");
        playerList.createPlayer("Kurt");
        playerList.createPlayer("Sofia");
        playerList.createPlayer("Robert");

        playerList.setPlayerScore("Luisa", 4.5);
        playerList.setPlayerScore("Manuel", 2.7);
        playerList.setPlayerScore("Kurt", 4.0);
        playerList.setPlayerScore("Sofia", 3.8);
        playerList.setPlayerScore("Robert", 3.8);
    }


}
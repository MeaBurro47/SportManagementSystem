import java.util.Scanner;

public class CommandManager {

    public static void getCommand(PlayerList playerList){
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.printf(">");
            String readCommand = scanner.nextLine();
            String[] command = readCommand.split(" ");

            if(command.length <= 2){
                handleCommand(command, playerList);
            }


        }while(true);
    }

    private static void handleCommand(String[] command, PlayerList playerList){
        switch(command[0]){
            case "create":
                playerList.createPlayer(command[1]);
                break;
            case "remove":
                playerList.removePlayer(command[1]);
                break;
            case "show":
                playerList.showPlayers();
                break;
            case "rank":
                playerList.showRanking();
                break;
            case "score":
                addScore(command[1].split(" "), playerList);
                break;
            case "show_matchmake":
                playerList.showMatches();
                break;
            case "clear_matchmake":
                playerList.clearMatches();
                break;
            case "matchmake":
                playerList.createMatch(command[1].split(";"));
                break;
            case "random_matchmake":
                playerList.randomMatchMake();
        }
    }

    private static void addScore(String[] parameters, PlayerList playerList){
        String name = parameters[0];
        double score = Double.parseDouble(parameters[1]);
        playerList.setPlayerScore(name, score);
    }
}

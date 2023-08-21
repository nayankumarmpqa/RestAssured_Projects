package Pack1;

class Player {
    private final String playerName;
    static int countOfPlayers = 0;

    Player(String name) {
        this.playerName = name;
        countOfPlayers++;
    }
    public String getPlayerName() {
        return playerName;
    }

    static public int getCountOfPlayers() {
        return countOfPlayers;
    }

}

public class StaticVarTest {

    public static void main(String[] args) {

        Player player1 = new Player("Sachin");
        System.out.println(player1.getPlayerName()
                + " " + Player.getCountOfPlayers());

        Player player2 = new Player("Sehwag");
        System.out.println(player2.getPlayerName()
                + " " + Player.getCountOfPlayers());
    }


}

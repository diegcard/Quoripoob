package Quoripoob.src.domain;

public class Quoridor {

    private static Quoridor quoridorSingleton = null;
    private Player playerOne;
    private Player playerTwo;

    public Quoridor(String normal, int size) {
        //quoridorSingleton = new Quoridor(normal, size);
    }

    public static Quoridor getQuoridor() {
        return quoridorSingleton;
    }

    public void setPlayerOne(Player player) {
        this.playerOne = player;
    }

    public void setPlayerTwo(Player player) {
        this.playerTwo = player;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }




}

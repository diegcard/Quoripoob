package Quoripoob.src.domain;

public class Quoridor {

    private Game game;
    private static Quoridor quoridorSingleton = null;

    public Quoridor(String normal, int size) {

    }

    public static Quoridor getQuoridor() {
        return quoridorSingleton;
    }




}

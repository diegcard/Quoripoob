package Quoripoob.src.domain;

public class Board {

    private int size;
    private Box[][] boxes;
    private Game game;

    public Board(int size){
        this.size = size;
        boxes = new Box[size][size];
    }

}

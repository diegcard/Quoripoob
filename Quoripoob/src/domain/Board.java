package Quoripoob.src.domain;

public class Board {

    private int size;
    private Box[][] boxes;

    public Board(int size){
        this.size = size;
        this.boxes = new Box[17][17];
    }

    public Box getBox(int row, int col){
        return boxes[row][col];
    }

    public void setBox(int row, int col, Box box){
        this.boxes[row][col] = box;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}

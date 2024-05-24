package Quoripoob.src.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Player {
    private String name;
    protected Color color;
    protected HashMap<String, Integer> walls;
    protected int row;
    protected int col;
    protected Quoridor quoridor;

    public Player(){
    }

    public void setQuoridor(Quoridor quoridor){
        this.quoridor = quoridor;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public void setWalls(HashMap<String, Integer> walls){
        this.walls = walls;
    }

    public HashMap<String, Integer> getWalls(){
        return walls;
    }

    public void move(){

    }

    public int[] getPossibleMoves() {
        int[] moves = new int[4];
        if (quoridor != null && quoridor.getBoard() != null) {
            Board board = quoridor.getBoard();
            int xPos = getCol();
            int yPos = getRow();
        }
        return moves;
    }


}

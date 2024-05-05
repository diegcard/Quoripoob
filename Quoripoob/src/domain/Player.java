package Quoripoob.src.domain;

import java.awt.Color;
import java.util.HashMap;

public abstract class Player {
    private String name;
    protected Color color;
    protected HashMap<String, Integer> walls;
    protected Game game;
    protected int row;
    protected int col;

    public Player(){
        walls = new HashMap<>();
    }

    public void setGame(Game game){
        this.game = game;
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


}

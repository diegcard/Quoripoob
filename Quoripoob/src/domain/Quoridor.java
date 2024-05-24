package Quoripoob.src.domain;

public class Quoridor {

    //private static Quoridor quoridorSingleton = null;
    private Player playerOne;
    private Player playerTwo;
    private Board board;
    private int size;
    private String gameMode;
    private boolean turn = true;
    private Player currentPlayer;

    public Quoridor() {
        this.board = new Board((size*2)-1);
    }

    public Board getBoard(){
        return board;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
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

    public boolean getTurn(){
        return turn;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public void changeCurrentPlayer(){
        if(currentPlayer == playerOne){
            currentPlayer = playerTwo;
        }else{
            currentPlayer = playerOne;
        }
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }



}

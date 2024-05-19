package Quoripoob.src.domain;

public class QuoridorException extends Exception{

    public QuoridorException(String message){
        super(message);
    }

    //Exception for invalid size
    public static class InvalidSizeException extends QuoridorException{
        public InvalidSizeException(String message){
            super(message);
        }
    }

    //Exception for invalid player
    public static class InvalidPlayerException extends QuoridorException{
        public InvalidPlayerException(String message){
            super(message);
        }
    }

    //Exception for invalid wall
    public static class InvalidWallException extends QuoridorException{
        public InvalidWallException(String message){
            super(message);
        }
    }

    //Exception for invalid move
    public static class InvalidMoveException extends QuoridorException{
        public InvalidMoveException(String message){
            super(message);
        }
    }
}

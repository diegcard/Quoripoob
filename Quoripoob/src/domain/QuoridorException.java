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
}

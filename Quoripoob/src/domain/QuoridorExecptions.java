package Quoripoob.src.domain;

public class QuoridorExecptions extends Exception{

    public QuoridorExecptions(String message){
        super(message);
    }

    //Exception for invalid size
    public static class InvalidSizeException extends QuoridorExecptions{
        public InvalidSizeException(String message){
            super(message);
        }
    }
}

package list;

public class IncorrectPositionException extends Exception{
    public IncorrectPositionException(String errorMessage){
        super(errorMessage);
    }
}
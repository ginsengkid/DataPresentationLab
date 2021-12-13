package cursorslist;

public class IncorrectPositionException extends RuntimeException{
    public IncorrectPositionException(String errorMessage){
        super(errorMessage);
    }
}

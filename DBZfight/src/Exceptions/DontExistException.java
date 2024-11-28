package Exceptions;

public class DontExistException extends RuntimeException{
    public DontExistException(String g){
        super(g);
    }
}

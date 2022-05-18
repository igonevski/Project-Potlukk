package dev.group1.Potlukk.exceptions;

public class IncorrectLoginCredentialsException extends RuntimeException{
    public IncorrectLoginCredentialsException(){
        super("Username or password is incorrect");
    }
}

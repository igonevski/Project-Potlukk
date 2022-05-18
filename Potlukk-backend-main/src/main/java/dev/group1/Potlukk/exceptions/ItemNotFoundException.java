package dev.group1.Potlukk.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(int id) {
        super("Item not found with id: "+ id +".");
    }
}

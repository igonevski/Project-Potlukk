package dev.group1.Potlukk.exceptions;

public class PotlukkNotFoundException extends RuntimeException{
    public PotlukkNotFoundException(int id) {
        super("Potlukk " + id + " not found.");
    }
}

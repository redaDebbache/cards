package com.debbache.cards.exception;

public class InvalidGameId extends RuntimeException {
    public InvalidGameId() {
        super("The given game id is invalid");
    }
}

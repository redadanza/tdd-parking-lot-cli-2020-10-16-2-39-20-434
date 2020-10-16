package com.oocl.cultivation;

public class NotEnoughPositionException extends RuntimeException {
    public NotEnoughPositionException(String not_enough_position) {
        super(not_enough_position);
    }
}

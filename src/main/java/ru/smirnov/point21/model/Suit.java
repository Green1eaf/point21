package ru.smirnov.point21.model;

public enum Suit {
    CROSSES('♠'),
    HEARTS('♥'),
    DIAMONDS('♦'),
    SPADES('♣');

    private final  char value;

    Suit(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}

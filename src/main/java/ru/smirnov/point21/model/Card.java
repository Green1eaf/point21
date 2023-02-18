package ru.smirnov.point21.model;

public class Card {
    Index index;
    Suit suit;

    public Card(Index index, Suit suit) {
        this.index = index;
        this.suit = suit;
    }

    public Index getIndex() {
        return index;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" + index.getValue() + "-" + suit.getValue() + '}';
    }
}

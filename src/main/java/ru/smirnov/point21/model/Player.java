package ru.smirnov.point21.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int sum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.index.getValue();
        }
        return sum;
    }

    public void clearCards() {
        cards.clear();
    }
}

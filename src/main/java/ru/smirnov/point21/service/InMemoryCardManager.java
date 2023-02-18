package ru.smirnov.point21.service;

import ru.smirnov.point21.model.Card;
import ru.smirnov.point21.model.Index;
import ru.smirnov.point21.model.Suit;
import ru.smirnov.point21.repository.CardRepository;

import java.util.Collections;
import java.util.LinkedList;

public class InMemoryCardManager implements CardRepository {

    private final LinkedList<Card> cards = new LinkedList<>();

    {
        for (Index i : Index.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }

    @Override
    public Card getCard() {
        Card card = cards.getFirst();
        removeCard();
        return card;
    }

    @Override
    public void removeCard() {
        cards.removeFirst();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }
}

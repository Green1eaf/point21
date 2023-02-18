package ru.smirnov.point21.repository;

import ru.smirnov.point21.model.Card;

public interface CardRepository {
    Card getCard();

    void removeCard();

    void shuffle();
}

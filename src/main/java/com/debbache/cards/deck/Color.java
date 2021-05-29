package com.debbache.cards.deck;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Color {
    CLUBS("Trèfle"), DIAMONDS("Carreau"), HEARTS("Coeur"), SPADES("Pique");
    private final String name;
}

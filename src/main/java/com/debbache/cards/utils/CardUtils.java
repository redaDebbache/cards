package com.debbache.cards.utils;

import com.debbache.cards.deck.Card;
import com.debbache.cards.deck.Color;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class CardUtils {

    public static List<Card> generateAllDeckCards() {
        return IntStream.range(1, 14)
                .mapToObj(value -> List.of(
                        new Card(value, Color.CLUBS),
                        new Card(value, Color.HEARTS),
                        new Card(value, Color.DIAMONDS),
                        new Card(value, Color.SPADES)
                        ))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    };
}

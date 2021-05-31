package com.debbache.cards.deck;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum CardType {
    ACE("AS", "A"), JACK("Valet", "J"), QUEEN("Dame", "Q"), KING("Roi", "K"), REGULAR(Strings.EMPTY, Strings.EMPTY);
    private final String name; 
    private final String rank;
    private static final Map<Integer, CardType> values = Map.of(1, ACE, 11, JACK, 12, QUEEN, 13, KING);

    public static CardType valueOf(int value){
        return values.getOrDefault(value, REGULAR);
    }
}

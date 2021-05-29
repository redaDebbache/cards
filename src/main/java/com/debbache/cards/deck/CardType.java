package com.debbache.cards.deck;

import com.google.common.collect.ImmutableMap;
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
    private static final Map<Integer, CardType> values = ImmutableMap.<Integer, CardType>builder()
            .put(1, ACE)
            .put(11, JACK)
            .put(12, QUEEN)
            .put(13, KING)
            .build();

    public static CardType valueOf(int value){
        return values.getOrDefault(value, REGULAR);
    }
}

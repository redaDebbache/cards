package com.debbache.cards.deck;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.Optional;


@Getter
@EqualsAndHashCode
public class Card {
    private final int value;
    private final Color color;
    private final String rank;

    public Card(int value, Color color) {
        this.value = value;
        this.color = color;
        this.rank = rank();
    }

    @JsonIgnore
    public CardType getCardType(){
        return CardType.valueOf(this.value);
    }

    public String valueName(){
        return Optional.of(getCardType())
                .map(CardType::getName)
                .filter(Strings::isNotBlank)
                .orElse(String.valueOf(this.value));
    }

    public String fullName(){
        return String.format("%s de %s", valueName(), color.getName());
    }

    public String rank(){
        return Optional.of(getCardType())
                .map(CardType::getRank)
                .filter(Strings::isNotBlank)
                .orElse(String.valueOf(this.value));
    }

    @Override
    public String toString() {
        return fullName();
    }
}

package com.debbache.cards.deck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hand {
    private List<Card> shuffledCards;
    private List<Card> sortedCards;
}

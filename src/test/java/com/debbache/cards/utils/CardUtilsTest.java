package com.debbache.cards.utils;

import com.debbache.cards.deck.Card;
import com.debbache.cards.deck.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardUtilsTest {
    @Test
    @DisplayName("Should generate every card once")
    void generateAllDeckCardsTest() {
        var cards = CardUtils.generateAllDeckCards();
        assertThat(cards).hasSize(52);
        assertThat(cards).containsOnly(
                new Card(1, Color.CLUBS),
                new Card(2, Color.CLUBS),
                new Card(3, Color.CLUBS),
                new Card(4, Color.CLUBS),
                new Card(5, Color.CLUBS),
                new Card(6, Color.CLUBS),
                new Card(7, Color.CLUBS),
                new Card(8, Color.CLUBS),
                new Card(9, Color.CLUBS),
                new Card(10, Color.CLUBS),
                new Card(11, Color.CLUBS),
                new Card(12, Color.CLUBS),
                new Card(13, Color.CLUBS),

                new Card(1, Color.DIAMONDS),
                new Card(2, Color.DIAMONDS),
                new Card(3, Color.DIAMONDS),
                new Card(4, Color.DIAMONDS),
                new Card(5, Color.DIAMONDS),
                new Card(6, Color.DIAMONDS),
                new Card(7, Color.DIAMONDS),
                new Card(8, Color.DIAMONDS),
                new Card(9, Color.DIAMONDS),
                new Card(10, Color.DIAMONDS),
                new Card(11, Color.DIAMONDS),
                new Card(12, Color.DIAMONDS),
                new Card(13, Color.DIAMONDS),

                new Card(1, Color.HEARTS),
                new Card(2, Color.HEARTS),
                new Card(3, Color.HEARTS),
                new Card(4, Color.HEARTS),
                new Card(5, Color.HEARTS),
                new Card(6, Color.HEARTS),
                new Card(7, Color.HEARTS),
                new Card(8, Color.HEARTS),
                new Card(9, Color.HEARTS),
                new Card(10, Color.HEARTS),
                new Card(11, Color.HEARTS),
                new Card(12, Color.HEARTS),
                new Card(13, Color.HEARTS),

                new Card(1, Color.SPADES),
                new Card(2, Color.SPADES),
                new Card(3, Color.SPADES),
                new Card(4, Color.SPADES),
                new Card(5, Color.SPADES),
                new Card(6, Color.SPADES),
                new Card(7, Color.SPADES),
                new Card(8, Color.SPADES),
                new Card(9, Color.SPADES),
                new Card(10, Color.SPADES),
                new Card(11, Color.SPADES),
                new Card(12, Color.SPADES),
                new Card(13, Color.SPADES)
        );
    }
}
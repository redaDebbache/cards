package com.debbache.cards.deck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @ParameterizedTest
    @DisplayName("should return the right card name")
    @MethodSource("cardWithCardName")
    void valueNameTest(Card card, String valueName) {
       assertThat(card.valueName()).isEqualTo(valueName);
    }

   @ParameterizedTest
    @DisplayName("should return the right card name")
    @MethodSource("cardWithCardFullName")
    void fullNameTest(Card card, String fullName) {
       assertThat(card.fullName()).isEqualTo(fullName);
    }

   @ParameterizedTest
    @DisplayName("should return the right card rank")
    @MethodSource("cardWithRank")
    void rankTest(Card card, String rank) {
       assertThat(card.rank()).isEqualTo(rank);
    }

    private static Stream<Arguments> cardWithRank(){
        return Stream.of(
                Arguments.of(new Card(1, Color.CLUBS), "A"),
                Arguments.of(new Card(2, Color.CLUBS), "2"),
                Arguments.of(new Card(3, Color.CLUBS), "3"),
                Arguments.of(new Card(4, Color.CLUBS), "4"),
                Arguments.of(new Card(5, Color.CLUBS), "5"),
                Arguments.of(new Card(6, Color.CLUBS), "6"),
                Arguments.of(new Card(7, Color.CLUBS), "7"),
                Arguments.of(new Card(8, Color.CLUBS), "8"),
                Arguments.of(new Card(9, Color.CLUBS), "9"),
                Arguments.of(new Card(10, Color.CLUBS), "10"),
                Arguments.of(new Card(11, Color.CLUBS), "J"),
                Arguments.of(new Card(12, Color.CLUBS), "Q"),
                Arguments.of(new Card(13, Color.CLUBS), "K"),

                Arguments.of(new Card(1, Color.DIAMONDS), "A"),
                Arguments.of(new Card(2, Color.DIAMONDS), "2"),
                Arguments.of(new Card(3, Color.DIAMONDS), "3"),
                Arguments.of(new Card(4, Color.DIAMONDS), "4"),
                Arguments.of(new Card(5, Color.DIAMONDS), "5"),
                Arguments.of(new Card(6, Color.DIAMONDS), "6"),
                Arguments.of(new Card(7, Color.DIAMONDS), "7"),
                Arguments.of(new Card(8, Color.DIAMONDS), "8"),
                Arguments.of(new Card(9, Color.DIAMONDS), "9"),
                Arguments.of(new Card(10, Color.DIAMONDS), "10"),
                Arguments.of(new Card(11, Color.DIAMONDS), "J"),
                Arguments.of(new Card(12, Color.DIAMONDS), "Q"),
                Arguments.of(new Card(13, Color.DIAMONDS), "K"),

                Arguments.of(new Card(1, Color.HEARTS), "A"),
                Arguments.of(new Card(2, Color.HEARTS), "2"),
                Arguments.of(new Card(3, Color.HEARTS), "3"),
                Arguments.of(new Card(4, Color.HEARTS), "4"),
                Arguments.of(new Card(5, Color.HEARTS), "5"),
                Arguments.of(new Card(6, Color.HEARTS), "6"),
                Arguments.of(new Card(7, Color.HEARTS), "7"),
                Arguments.of(new Card(8, Color.HEARTS), "8"),
                Arguments.of(new Card(9, Color.HEARTS), "9"),
                Arguments.of(new Card(10, Color.HEARTS), "10"),
                Arguments.of(new Card(11, Color.HEARTS), "J"),
                Arguments.of(new Card(12, Color.HEARTS), "Q"),
                Arguments.of(new Card(13, Color.HEARTS), "K"),

                Arguments.of(new Card(1, Color.SPADES), "A"),
                Arguments.of(new Card(2, Color.SPADES), "2"),
                Arguments.of(new Card(3, Color.SPADES), "3"),
                Arguments.of(new Card(4, Color.SPADES), "4"),
                Arguments.of(new Card(5, Color.SPADES), "5"),
                Arguments.of(new Card(6, Color.SPADES), "6"),
                Arguments.of(new Card(7, Color.SPADES), "7"),
                Arguments.of(new Card(8, Color.SPADES), "8"),
                Arguments.of(new Card(9, Color.SPADES), "9"),
                Arguments.of(new Card(10, Color.SPADES), "10"),
                Arguments.of(new Card(11, Color.SPADES), "J"),
                Arguments.of(new Card(12, Color.SPADES), "Q"),
                Arguments.of(new Card(13, Color.SPADES), "K")
        );
    }

    private static Stream<Arguments> cardWithCardName(){
        return Stream.of(
            Arguments.of(new Card(1, Color.CLUBS), "AS"),
                Arguments.of(new Card(2, Color.CLUBS), "2"),
                Arguments.of(new Card(3, Color.CLUBS), "3"),
                Arguments.of(new Card(4, Color.CLUBS), "4"),
                Arguments.of(new Card(5, Color.CLUBS), "5"),
                Arguments.of(new Card(6, Color.CLUBS), "6"),
                Arguments.of(new Card(7, Color.CLUBS), "7"),
                Arguments.of(new Card(8, Color.CLUBS), "8"),
                Arguments.of(new Card(9, Color.CLUBS), "9"),
                Arguments.of(new Card(10, Color.CLUBS), "10"),
                Arguments.of(new Card(11, Color.CLUBS), "Valet"),
                Arguments.of(new Card(12, Color.CLUBS), "Dame"),
                Arguments.of(new Card(13, Color.CLUBS), "Roi"),
                
                Arguments.of(new Card(1, Color.DIAMONDS), "AS"),
                Arguments.of(new Card(2, Color.DIAMONDS), "2"),
                Arguments.of(new Card(3, Color.DIAMONDS), "3"),
                Arguments.of(new Card(4, Color.DIAMONDS), "4"),
                Arguments.of(new Card(5, Color.DIAMONDS), "5"),
                Arguments.of(new Card(6, Color.DIAMONDS), "6"),
                Arguments.of(new Card(7, Color.DIAMONDS), "7"),
                Arguments.of(new Card(8, Color.DIAMONDS), "8"),
                Arguments.of(new Card(9, Color.DIAMONDS), "9"),
                Arguments.of(new Card(10, Color.DIAMONDS), "10"),
                Arguments.of(new Card(11, Color.DIAMONDS), "Valet"),
                Arguments.of(new Card(12, Color.DIAMONDS), "Dame"),
                Arguments.of(new Card(13, Color.DIAMONDS), "Roi"),

                Arguments.of(new Card(1, Color.HEARTS), "AS"),
                Arguments.of(new Card(2, Color.HEARTS), "2"),
                Arguments.of(new Card(3, Color.HEARTS), "3"),
                Arguments.of(new Card(4, Color.HEARTS), "4"),
                Arguments.of(new Card(5, Color.HEARTS), "5"),
                Arguments.of(new Card(6, Color.HEARTS), "6"),
                Arguments.of(new Card(7, Color.HEARTS), "7"),
                Arguments.of(new Card(8, Color.HEARTS), "8"),
                Arguments.of(new Card(9, Color.HEARTS), "9"),
                Arguments.of(new Card(10, Color.HEARTS), "10"),
                Arguments.of(new Card(11, Color.HEARTS), "Valet"),
                Arguments.of(new Card(12, Color.HEARTS), "Dame"),
                Arguments.of(new Card(13, Color.HEARTS), "Roi"),

                Arguments.of(new Card(1, Color.SPADES), "AS"),
                Arguments.of(new Card(2, Color.SPADES), "2"),
                Arguments.of(new Card(3, Color.SPADES), "3"),
                Arguments.of(new Card(4, Color.SPADES), "4"),
                Arguments.of(new Card(5, Color.SPADES), "5"),
                Arguments.of(new Card(6, Color.SPADES), "6"),
                Arguments.of(new Card(7, Color.SPADES), "7"),
                Arguments.of(new Card(8, Color.SPADES), "8"),
                Arguments.of(new Card(9, Color.SPADES), "9"),
                Arguments.of(new Card(10, Color.SPADES), "10"),
                Arguments.of(new Card(11, Color.SPADES), "Valet"),
                Arguments.of(new Card(12, Color.SPADES), "Dame"),
                Arguments.of(new Card(13, Color.SPADES), "Roi")
        );
    }

    private static Stream<Arguments> cardWithCardFullName(){
        return Stream.of(
            Arguments.of(new Card(1, Color.CLUBS), "AS de Trèfle"),
                Arguments.of(new Card(2, Color.CLUBS), "2 de Trèfle"),
                Arguments.of(new Card(3, Color.CLUBS), "3 de Trèfle"),
                Arguments.of(new Card(4, Color.CLUBS), "4 de Trèfle"),
                Arguments.of(new Card(5, Color.CLUBS), "5 de Trèfle"),
                Arguments.of(new Card(6, Color.CLUBS), "6 de Trèfle"),
                Arguments.of(new Card(7, Color.CLUBS), "7 de Trèfle"),
                Arguments.of(new Card(8, Color.CLUBS), "8 de Trèfle"),
                Arguments.of(new Card(9, Color.CLUBS), "9 de Trèfle"),
                Arguments.of(new Card(10, Color.CLUBS), "10 de Trèfle"),
                Arguments.of(new Card(11, Color.CLUBS), "Valet de Trèfle"),
                Arguments.of(new Card(12, Color.CLUBS), "Dame de Trèfle"),
                Arguments.of(new Card(13, Color.CLUBS), "Roi de Trèfle"),

                Arguments.of(new Card(1, Color.DIAMONDS), "AS de Carreau"),
                Arguments.of(new Card(2, Color.DIAMONDS), "2 de Carreau"),
                Arguments.of(new Card(3, Color.DIAMONDS), "3 de Carreau"),
                Arguments.of(new Card(4, Color.DIAMONDS), "4 de Carreau"),
                Arguments.of(new Card(5, Color.DIAMONDS), "5 de Carreau"),
                Arguments.of(new Card(6, Color.DIAMONDS), "6 de Carreau"),
                Arguments.of(new Card(7, Color.DIAMONDS), "7 de Carreau"),
                Arguments.of(new Card(8, Color.DIAMONDS), "8 de Carreau"),
                Arguments.of(new Card(9, Color.DIAMONDS), "9 de Carreau"),
                Arguments.of(new Card(10, Color.DIAMONDS), "10 de Carreau"),
                Arguments.of(new Card(11, Color.DIAMONDS), "Valet de Carreau"),
                Arguments.of(new Card(12, Color.DIAMONDS), "Dame de Carreau"),
                Arguments.of(new Card(13, Color.DIAMONDS), "Roi de Carreau"),

                Arguments.of(new Card(1, Color.HEARTS), "AS de Coeur"),
                Arguments.of(new Card(2, Color.HEARTS), "2 de Coeur"),
                Arguments.of(new Card(3, Color.HEARTS), "3 de Coeur"),
                Arguments.of(new Card(4, Color.HEARTS), "4 de Coeur"),
                Arguments.of(new Card(5, Color.HEARTS), "5 de Coeur"),
                Arguments.of(new Card(6, Color.HEARTS), "6 de Coeur"),
                Arguments.of(new Card(7, Color.HEARTS), "7 de Coeur"),
                Arguments.of(new Card(8, Color.HEARTS), "8 de Coeur"),
                Arguments.of(new Card(9, Color.HEARTS), "9 de Coeur"),
                Arguments.of(new Card(10, Color.HEARTS), "10 de Coeur"),
                Arguments.of(new Card(11, Color.HEARTS), "Valet de Coeur"),
                Arguments.of(new Card(12, Color.HEARTS), "Dame de Coeur"),
                Arguments.of(new Card(13, Color.HEARTS), "Roi de Coeur"),

                Arguments.of(new Card(1, Color.SPADES), "AS de Pique"),
                Arguments.of(new Card(2, Color.SPADES), "2 de Pique"),
                Arguments.of(new Card(3, Color.SPADES), "3 de Pique"),
                Arguments.of(new Card(4, Color.SPADES), "4 de Pique"),
                Arguments.of(new Card(5, Color.SPADES), "5 de Pique"),
                Arguments.of(new Card(6, Color.SPADES), "6 de Pique"),
                Arguments.of(new Card(7, Color.SPADES), "7 de Pique"),
                Arguments.of(new Card(8, Color.SPADES), "8 de Pique"),
                Arguments.of(new Card(9, Color.SPADES), "9 de Pique"),
                Arguments.of(new Card(10, Color.SPADES), "10 de Pique"),
                Arguments.of(new Card(11, Color.SPADES), "Valet de Pique"),
                Arguments.of(new Card(12, Color.SPADES), "Dame de Pique"),
                Arguments.of(new Card(13, Color.SPADES), "Roi de Pique")
        );
    }
}

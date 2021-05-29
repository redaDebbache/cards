package com.debbache.cards.deck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTypeTest {

    @ParameterizedTest
    @DisplayName("should return the cardType associated with a value")
    @MethodSource("carTypeValue")
    void cardTypeValuesTest(Integer value, CardType expected) {
        assertThat(CardType.valueOf(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> carTypeValue(){
        return Stream.of(
                Arguments.arguments(1, CardType.ACE),
                Arguments.arguments(11, CardType.JACK),
                Arguments.arguments(12, CardType.QUEEN),
                Arguments.arguments(13, CardType.KING),
                Arguments.arguments(2, CardType.REGULAR),
                Arguments.arguments(3, CardType.REGULAR),
                Arguments.arguments(4, CardType.REGULAR),
                Arguments.arguments(5, CardType.REGULAR),
                Arguments.arguments(6, CardType.REGULAR),
                Arguments.arguments(7, CardType.REGULAR),
                Arguments.arguments(8, CardType.REGULAR),
                Arguments.arguments(9, CardType.REGULAR),
                Arguments.arguments(10, CardType.REGULAR)
        );
    }


}
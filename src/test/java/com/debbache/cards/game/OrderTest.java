package com.debbache.cards.game;

import com.debbache.cards.deck.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OrderTest {

    @Test
    @DisplayName("should return shuffled 4 colors")
    void colorOrderTest() {
        //Given
        var order = new Order();

        //when
        var colorOrder = order.getColorOrder();

        //Then
        assertThat(colorOrder).hasSize(4);
        assertThat(colorOrder).containsExactlyInAnyOrder(Color.CLUBS, Color.DIAMONDS, Color.HEARTS, Color.SPADES);

    }


    @Test
    @DisplayName("should return shuffled 10 values")
    void valuesOrderTest() {
        //Given
        var order = new Order();

        //when
        var colorOrder = order.getValuesOrder();

        //Then
        assertThat(colorOrder).hasSize(10);
        assertThat(colorOrder).allMatch(value -> value >= 1 && value <= 13);

    }
}
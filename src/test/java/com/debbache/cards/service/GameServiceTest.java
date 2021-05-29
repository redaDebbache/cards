package com.debbache.cards.service;

import com.debbache.cards.deck.Card;
import com.debbache.cards.game.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Comparator;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class GameServiceTest {


    private GameService gameService = new GameService();

    @Test
    @DisplayName("should init a new Game and return it's Id")
    void getGameIdTest() {
        //Given
        Map<String, Game> games = (Map<String, Game>) ReflectionTestUtils.getField(gameService, "games");
        assertThat(games).isEmpty();
        //When
        var gameId = gameService.initGame();
        //Then
        assertThat(gameId).isNotBlank();
        assertThat(games).hasSize(1);
        assertThat(games).containsKey(gameId);
        assertThat(games.get(gameId)).isNotNull();
    }

    @Test
    @DisplayName("Should serve a Hand with shuffled and sorted cards")
    void serveHandWithinGameTest() {
        //Given
        var game = new Game();
        Comparator<Card> colorComparator = Comparator.comparingInt(card -> game.colorOrder().indexOf(card.getColor()));
        Comparator<Card> valuesComparator = Comparator.comparingInt(card -> game.valuesOrder().indexOf(card.getValue()));

        //When
        var hand = gameService.serveHandWithinGame(game);
        //Then
        assertThat(hand).isNotNull();
        assertThat(hand.getShuffledCards()).hasSize(10);
        assertThat(hand.getSortedCards()).hasSize(10);
        assertThat(hand.getSortedCards()).isSortedAccordingTo(colorComparator.thenComparing(valuesComparator));
    }

    @Test
    @DisplayName("Should serve a Hand with shuffled and sorted cards for a given gameId")
    void serveHandWithGameId() {
        //Given
        Map<String, Game> games = (Map<String, Game>) ReflectionTestUtils.getField(gameService, "games");
        var gameId = gameService.initGame();

        //When
        var hand = gameService.serveHand(gameId);
        //Then
        var game = games.get(gameId);
        Comparator<Card> colorComparator = Comparator.comparingInt(card -> game.colorOrder().indexOf(card.getColor()));
        Comparator<Card> valuesComparator = Comparator.comparingInt(card -> game.valuesOrder().indexOf(card.getValue()));

        assertThat(hand).isNotNull();
        assertThat(hand.getShuffledCards()).hasSize(10);
        assertThat(hand.getSortedCards()).hasSize(10);
        assertThat(hand.getSortedCards()).isSortedAccordingTo(colorComparator.thenComparing(valuesComparator));
    }


}
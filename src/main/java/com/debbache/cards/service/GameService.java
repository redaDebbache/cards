package com.debbache.cards.service;

import com.debbache.cards.deck.Hand;
import com.debbache.cards.exception.InvalidGameId;
import com.debbache.cards.game.Game;
import com.debbache.cards.utils.CardUtils;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static com.debbache.cards.utils.Constants.HAND_SIZE;

@Service
public class GameService {
    private final Map<String, Game> games = Maps.newHashMap();

    public String initGame() {
        var game = new Game();
        games.put(game.getId(), game);
        return game.getId();
    }

    public Hand serveHand(String gameId) {
        checkGameId(gameId);
        var game = games.get(gameId);
        return serveHandWithinGame(game);
    }

    Hand serveHandWithinGame(Game game) {
        var deck = CardUtils.generateAllDeckCards();
        Collections.shuffle(deck);
        var shuffledCards = deck.stream().limit(HAND_SIZE).collect(Collectors.toList());
        return new Hand(shuffledCards, game.sortCards(shuffledCards));
    }

    private void checkGameId(String gameId) {
        if (!games.containsKey(gameId)) {
            throw new InvalidGameId();
        }
    }

    public int getGameCount() {
        return games.size();
    }
}

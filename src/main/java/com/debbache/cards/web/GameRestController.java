package com.debbache.cards.web;

import com.debbache.cards.deck.Hand;
import com.debbache.cards.service.GameService;
import com.debbache.cards.utils.PathUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class GameRestController {
    private final GameService gameService;

    @GetMapping(value = PathUtils.INIT_GAME_PATH)
    public String initGame() {
        return gameService.initGame();
    }

    @GetMapping(value = PathUtils.SERVE_HAND_PATH)
    public Hand serveHand(@PathVariable("gameId") String gameId) {
        return gameService.serveHand(gameId);
    }

}

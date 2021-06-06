package com.debbache.cards.web;

import com.debbache.cards.deck.Hand;
import com.debbache.cards.service.GameService;
import com.debbache.cards.utils.PathUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class GameRestController {
    private final GameService gameService;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @GetMapping(value = PathUtils.INIT_GAME_PATH)
    public String initGame() {
        return gameService.initGame();
    }

    @GetMapping(value = PathUtils.SERVE_HAND_PATH)
    public Hand serveHand(@PathVariable("gameId") String gameId) {
        return gameService.serveHand(gameId);
    }

    @GetMapping(PathUtils.GAME_COUNT)
    public SseEmitter getGameCounts(){
        var emitter = new SseEmitter();
        executorService.execute(() -> {
            try {
                emitter.send(gameService.getGameCount());
                emitter.complete();
            } catch (IOException ex) {
                emitter.completeWithError(ex);
                log.error("Something went wrong", ex);
            }
        });
        return emitter;
    }

}

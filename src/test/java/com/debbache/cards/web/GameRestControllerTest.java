package com.debbache.cards.web;

import com.debbache.cards.deck.Hand;
import com.debbache.cards.utils.PathUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("should init game and return game id")
    void initGameTest() throws Exception {
        mockMvc.perform(get(PathUtils.INIT_GAME_PATH)).andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).isNotBlank());
    }

    @Test
    @DisplayName("should return 400 if the given gameId is invalid")
    void serveHand400() throws Exception {
        var gameId = "flirtikit";
        mockMvc.perform(get(PathUtils.servHandPath(gameId))).andExpect(status().isBadRequest())
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).contains("The given game id is invalid"));
    }

    @Test
    @DisplayName("should return 200 if the given gameId is valid")
    void serveHand200() throws Exception {
        mockMvc.perform(get(PathUtils.INIT_GAME_PATH)).andExpect(status().isOk())
                .andExpect(result -> {
                    var gameId = result.getResponse().getContentAsString();
                    mockMvc.perform(get(PathUtils.servHandPath(gameId))).andExpect(status().isOk())
                            .andExpect(content -> {
                                var hand = objectMapper.readValue(content.getResponse().getContentAsString(), Hand.class);
                                assertThat(hand).isNotNull();
                                assertThat(hand.getSortedCards()).isNotEmpty();
                                assertThat(hand.getShuffledCards()).isNotEmpty();
                            });
                });
    }

    @Test
    @DisplayName("Should return the total game count")
    void shouldReturnGameCounts() throws Exception {
        mockMvc.perform(get(PathUtils.INIT_GAME_PATH)).andExpect(status().isOk())
                .andExpect(result -> mockMvc.perform(get(PathUtils.GAME_COUNT)).andExpect(status().isOk())
                        .andExpect(content -> {
                            var count = content.getResponse().getContentAsString();
                            assertThat(count).contains("data:1");
                        }));
    }
}

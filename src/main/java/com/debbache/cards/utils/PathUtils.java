package com.debbache.cards.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathUtils {
    public static final String GAME_PATH = "/game";
    public static final String INIT_GAME_PATH = GAME_PATH + "/init";
    public static final String SERVE_HAND_PATH = GAME_PATH + "/{gameId}/hand";
    public static final String SERVE_HAND_PARAM_PATH = GAME_PATH + "/%s/hand";

    public static String servHandPath(String gameId) {
        return String.format(SERVE_HAND_PARAM_PATH, gameId);
    }
}

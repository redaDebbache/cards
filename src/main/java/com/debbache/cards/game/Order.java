package com.debbache.cards.game;

import com.debbache.cards.deck.Color;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.debbache.cards.utils.Constants.*;

@Getter
public class Order {
    private static final Random RANDOM = new Random();
    private final List<Color> colorOrder = getshuffledColors();

     List<Color> getshuffledColors() {
        var colors = Arrays.asList(Color.values());
        Collections.shuffle(colors);
        return colors;
    }

    private final List<Integer> valuesOrder = getRandomValuesWithRepetition();

    private static List<Integer> getRandomValuesWithRepetition() {
        return IntStream.range(0, HAND_SIZE)
                .map(i -> RANDOM.nextInt(MAX_VALUE_EXCLUSIVE - MIN_VALUE_INCLUSIVE) + MIN_VALUE_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
    }
}

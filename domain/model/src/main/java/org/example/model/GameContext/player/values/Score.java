package org.example.model.GameContext.player.values;

import co.com.sofka.domain.generic.ValueObject;

public class Score implements ValueObject<Integer> {

    private final Integer value;

    public Score (int score) { this.value = value(); }

    @Override
    public Integer value() {
        return value;
    }
}

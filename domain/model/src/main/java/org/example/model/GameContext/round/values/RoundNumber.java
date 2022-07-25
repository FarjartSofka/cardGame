package org.example.model.GameContext.round.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RoundNumber implements ValueObject<Integer> {

    private final Integer value;

    public RoundNumber(Integer value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

}

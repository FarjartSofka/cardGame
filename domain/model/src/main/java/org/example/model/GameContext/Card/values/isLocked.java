package org.example.model.GameContext.Card.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class isLocked implements ValueObject<Boolean> {

    private final Boolean value;

    public isLocked(Boolean value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

}

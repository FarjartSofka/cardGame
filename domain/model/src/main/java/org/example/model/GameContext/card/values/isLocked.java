package org.example.model.GameContext.card.values;

import org.example.model.generic.ValueObject;

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

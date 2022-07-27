package org.example.model.GameContext.card.values;

import org.example.model.generic.ValueObject;

import java.util.Objects;

public class isHidden implements ValueObject<Boolean> {

    private final Boolean value;

    public isHidden(Boolean value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

}

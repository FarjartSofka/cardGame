package org.example.model.GameContext.deck.values;

import org.example.model.generic.ValueObject;

import java.util.Objects;

public class Quantity implements ValueObject<Integer> {

    private final Integer value;

    public Quantity(Integer value){ this.value = Objects.requireNonNull(value, "Cantidad es requerido"); }

    @Override
    public Integer value() { return value; }

}

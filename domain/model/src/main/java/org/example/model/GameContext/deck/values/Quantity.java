package org.example.model.GameContext.deck.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Quantity implements ValueObject<Integer> {

    private final Integer value;

    public Quantity(Integer value){ this.value = Objects.requireNonNull(value, "Cantidad es requerido"); }

    @Override
    public Integer value() { return value; }

}

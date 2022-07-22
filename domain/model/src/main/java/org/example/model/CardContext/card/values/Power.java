package org.example.model.CardContext.card.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Power implements ValueObject<Integer> {

    private final Integer value;

    public Power(Integer value){ this.value = Objects.requireNonNull(value, "Poder es requerido"); }

    @Override
    public Integer value() { return value; }
}

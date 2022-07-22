package org.example.model.card.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Power implements ValueObject<String> {

    private final String value;

    public Power(String value){ this.value = Objects.requireNonNull(value, "Poder es requerido"); }

    @Override
    public String value() { return value; }
}

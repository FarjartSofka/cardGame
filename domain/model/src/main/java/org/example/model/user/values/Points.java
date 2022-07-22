package org.example.model.user.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Points implements ValueObject<Integer> {

    private final Integer value;

    public Points(Integer value){ this.value = Objects.requireNonNull(value); }

    @Override
    public Integer value() { return value; }

}

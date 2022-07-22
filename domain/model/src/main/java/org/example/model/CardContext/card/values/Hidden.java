package org.example.model.CardContext.card.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Hidden implements ValueObject<Boolean> {

    private final Boolean value;

    public Hidden(Boolean value){ this.value = value; }

    @Override
    public Boolean value() { return value; }

}

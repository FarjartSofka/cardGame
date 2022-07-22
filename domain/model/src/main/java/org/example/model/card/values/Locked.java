package org.example.model.card.values;

import co.com.sofka.domain.generic.ValueObject;

public class Locked implements ValueObject<Boolean> {

    private final Boolean value;

    public Locked(Boolean value){ this.value = value; }

    @Override
    public Boolean value() { return value; }

}

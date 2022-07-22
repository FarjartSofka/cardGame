package org.example.model.user.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;
import org.example.model.card.values.CardId;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value){ this.value = Objects.requireNonNull(value, "Nombre es requerido"); }

    @Override
    public String value() { return value; }


}

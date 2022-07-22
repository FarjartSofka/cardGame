package org.example.model.UserContext.user.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value){ this.value = Objects.requireNonNull(value, "Nombre es requerido"); }

    @Override
    public String value() { return value; }


}

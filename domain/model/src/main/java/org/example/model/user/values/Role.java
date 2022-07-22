package org.example.model.user.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Role implements ValueObject<String> {

    private final String value;

    public Role(String value){ this.value = Objects.requireNonNull(value, "Rol es requerido"); }

    @Override
    public String value() { return value; }

}

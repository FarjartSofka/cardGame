package org.example.model.GameContext.player.values;

import co.com.sofka.domain.generic.ValueObject;

public class Nickname implements ValueObject<String> {

    private final String value;


    public Nickname(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}

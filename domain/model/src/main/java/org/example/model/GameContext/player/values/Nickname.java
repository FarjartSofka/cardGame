package org.example.model.GameContext.player.values;

import org.example.model.generic.ValueObject;

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

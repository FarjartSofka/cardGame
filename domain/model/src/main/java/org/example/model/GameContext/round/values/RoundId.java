package org.example.model.GameContext.round.values;

import org.example.model.generic.Identity;

public class RoundId extends Identity {

    private RoundId(String id) { super(id); }

    public RoundId() {
    }

    public static RoundId of(String id){ return new RoundId(id); }
}

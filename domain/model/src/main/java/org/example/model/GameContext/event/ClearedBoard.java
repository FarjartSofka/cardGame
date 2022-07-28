package org.example.model.GameContext.event;

import org.example.model.generic.DomainEvent;

public class ClearedBoard extends DomainEvent {

    public ClearedBoard(String type) {super("cardgame.ClearedBoard");}
}

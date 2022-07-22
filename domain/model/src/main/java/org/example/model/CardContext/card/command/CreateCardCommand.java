package org.example.model.CardContext.card.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.CardContext.card.values.*;
import org.example.model.card.values.*;

public class CreateCardCommand extends Command {

    private final CardId cardId;

    private final Url url;

    private final Power power;

    private final Hidden hidden;

    private final Locked locked;

    public CreateCardCommand(CardId cardId, Url url, Power power, Hidden hidden, Locked locked) {
        this.cardId = cardId;
        this.url = url;
        this.power = power;
        this.hidden = hidden;
        this.locked = locked;
    }

    public CardId getCardId() { return cardId; }

    public Url getUrl() { return url; }

    public Power getPower() { return power; }

    public Hidden getHidden() { return hidden; }

    public Locked getLocked() { return locked; }
}

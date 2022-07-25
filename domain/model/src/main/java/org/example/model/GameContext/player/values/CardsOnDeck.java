package org.example.model.GameContext.player.values;

import co.com.sofka.domain.generic.ValueObject;

public class CardsOnDeck implements ValueObject<CardsOnDeck.properties> {

    private final String cardId;

    private final Boolean hidden;

    public CardsOnDeck(String cardId, Boolean hidden) {
        this.cardId = cardId;
        this.hidden = hidden;
    }


    @Override
    public properties value() {
        return new properties(){
            @Override
            public String cardId(){ return cardId; }

            @Override
            public Boolean hidden(){ return hidden; }
        };
    }

    public interface properties {
        String cardId();

        Boolean hidden();
    }

}

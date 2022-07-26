package org.example.model.GameContext.card;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CardFactory {

    public static CardFactory instance;
    private final Set<Card> cards;

    public CardFactory(){
        cards = new HashSet<>();
    }

    public static CardFactory getInstance(){
        if (Objects.isNull(instance)){
            instance = new CardFactory();
            return instance;
        }
        return instance;
    }

    public CardFactory add(Card carta){
        cards.add(carta);
        return this;
    }

    public Set<Card> cards() {
        return cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardFactory{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
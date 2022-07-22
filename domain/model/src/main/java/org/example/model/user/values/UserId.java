package org.example.model.user.values;

import co.com.sofka.domain.generic.Identity;
import org.example.model.card.values.CardId;

public class UserId extends Identity {

    public UserId(String userId) {
        super(userId);
    }

    public UserId() {
    }

    public static UserId of(String userId) {
        return new UserId(userId);
    }

}

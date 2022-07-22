package org.example.model.UserContext.user.values;

import co.com.sofka.domain.generic.Identity;

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

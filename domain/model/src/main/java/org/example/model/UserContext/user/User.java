package org.example.model.UserContext.user;

import co.com.sofka.domain.generic.Entity;
import org.example.model.UserContext.user.values.*;

public class User extends Entity<UserId> {

    private final Name name;

    private final Email email;

    private final Role role;

    private final Points points;

    public User(UserId entityId, Name name, Email email, Role role, Points points) {
        super(entityId);
        this.name = name;
        this.email = email;
        this.role = role;
        this.points = points;
    }
}

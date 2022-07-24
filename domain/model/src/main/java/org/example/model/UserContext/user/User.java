package org.example.model.UserContext.user;



public class User{

    private String userId;

    private String name;

    private String email;

    private String role;

    private Integer points;

    public User(String userId, String name, String email, String role, Integer points) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.points = points;
    }
}

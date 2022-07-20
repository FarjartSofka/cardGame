package org.example.model.game;

import org.example.model.player.Player;

import java.util.Set;

public class Game {

    private String id;

    private Set<Player> players;

    public Game() {
    }

    public Game(String id, Set<Player> players) {
        this.id = id;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", players=" + players +
                '}';
    }
}

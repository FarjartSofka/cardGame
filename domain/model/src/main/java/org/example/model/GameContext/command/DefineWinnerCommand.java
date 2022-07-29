package org.example.model.GameContext.command;

import org.example.model.generic.Command;


public class DefineWinnerCommand extends Command {

    private String playerId;
    private String power;

    public DefineWinnerCommand() {
    }

    public DefineWinnerCommand(String playerId, String power) {
        this.playerId = playerId;
        this.power = power;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "DefineWinnerCommand{" +
                "playerId='" + playerId + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}

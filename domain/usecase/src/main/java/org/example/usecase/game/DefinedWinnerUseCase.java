package org.example.usecase.game;

import org.example.model.GameContext.command.DefineWinnerCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class DefinedWinnerUseCase implements Function<DefineWinnerCommand, DefineWinnerCommand> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefinedWinnerUseCase.class);

    @Override
    public DefineWinnerCommand apply(DefineWinnerCommand defineWinnerCommand) {
        List<DefineWinnerCommand> cardsToBoard = new ArrayList<>();
        cardsToBoard.add(defineWinnerCommand);
        LOGGER.info("los jugadores son {}", cardsToBoard.toString());
         return cardsToBoard.stream()
                .max(Comparator.comparing(DefineWinnerCommand::getPower))
                .orElseThrow(()-> new RuntimeException("no hay ganador"));


    }
}

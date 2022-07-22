package org.example.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.model.CardContext.card.Card;
import org.example.model.CardContext.card.command.CreateCardCommand;


public class CreateCardUseCase extends UseCase<RequestCommand<CreateCardCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCardCommand> requestCommand){
        var command = requestCommand.getCommand();
        var card = new Card(command.getCardId(), command.getUrl(), command.getPower());

    }

}

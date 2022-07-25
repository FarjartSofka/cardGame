package org.example.adapters.card;

import org.example.adapters.helper.OperationAdapter;
import org.example.model.CardContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class MongoCardRepositoryAdapter extends OperationAdapter<Card, CardDocument, String, CardDBRepository> implements CardRepository {

    public MongoCardRepositoryAdapter(CardDBRepository mongoDBRepository, ObjectMapperI mapper) {
        super(mongoDBRepository, mapper, d -> mapper.map(d, Card.class));
    }

    @Override
    public Flux<Card> saveAll(Flux<Card> entity) {
        var entities =  entity.map(this::mapToDocument);
        return  repository.saveAll(entities).map(this::mapToEntity);
    }
}

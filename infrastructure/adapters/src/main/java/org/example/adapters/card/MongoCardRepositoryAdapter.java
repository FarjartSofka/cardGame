package org.example.adapters.card;

import org.example.adapters.helper.OperationAdapter;
import org.example.model.card.Card;
import org.example.model.card.gateway.CardRepository;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.stereotype.Repository;

@Repository
public class MongoCardRepositoryAdapter extends OperationAdapter<Card, CardDocument, String, CardDBRepository> implements CardRepository {

    public MongoCardRepositoryAdapter(CardDBRepository mongoDBRepository, ObjectMapperI mapper) {
        super(mongoDBRepository, mapper, d -> mapper.map(d, Card.class));
    }
}

package org.example.adapters.card;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CardDBRepository extends ReactiveCrudRepository<CardDocument, String> {
}

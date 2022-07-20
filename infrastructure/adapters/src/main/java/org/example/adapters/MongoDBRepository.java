package org.example.adapters;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository<T, ID> extends ReactiveMongoRepository<T,ID>, ReactiveQueryByExampleExecutor<T> {
}

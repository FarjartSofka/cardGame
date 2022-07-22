package org.example.adapters;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface MongoDBRepository<T, K> extends ReactiveMongoRepository<T,K>{
}

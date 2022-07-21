package org.example.adapters.helper;

import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

public abstract class OperationAdapter<E, D, I, R extends ReactiveCrudRepository<D, I>> {
    protected R repository;
    protected ObjectMapperI mapper;
    private final Class<D> dataClass;
    private final Function<D, E> toEntityFn;

    protected OperationAdapter(R repository, ObjectMapperI mapper, Function<D, E> toEntityFn) {
        this.repository = repository;
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.dataClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
        this.mapper = mapper;
        this.toEntityFn = toEntityFn;
    }

    public Mono<E> save(E entity) {
        return Mono.just(entity)
                .map(this::mapToDocument)
                .flatMap(repository::save)
                .map(this::mapToEntity);
    }

    public Flux<E> findAll() {
        return repository.findAll()
                .map(this::mapToEntity);
    }

    public Mono<E> findById(I id) {
        return repository.findById(id)
                .map(this::mapToEntity);
    }

    public Mono<Void> deleteById(I id) {
        return repository.deleteById(id);
    }

    private D mapToDocument(E entity) {
        return mapper.map(entity, dataClass);
    }

    private E mapToEntity(D document) {
        return toEntityFn.apply(document);
    }
}

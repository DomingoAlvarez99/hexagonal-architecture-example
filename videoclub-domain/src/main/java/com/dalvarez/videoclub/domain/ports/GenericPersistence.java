package com.dalvarez.videoclub.domain.ports;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface GenericPersistence<T, ID> {
    Stream<T> readAll();

    T readById(ID id);

    T create(T entity);

    T update(T entity);

    void deleteById(ID id);

}

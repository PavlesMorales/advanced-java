package ru.antonov.client.core.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository<E, I> {

    Collection<E> findAll();

    Optional<E> findByUid(UUID uid);

    void save(E entity);

    void delete(I id);

}

package ru.antonov.client.core.repository;

import lombok.RequiredArgsConstructor;
import ru.antonov.client.core.model.ClientEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
public class InMemoryClientRepository implements ClientRepository<ClientEntity, UUID> {

    private final Map<UUID, ClientEntity> storage;


    @Override
    public List<ClientEntity> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<ClientEntity> findByUid(final UUID uid) {
        return Optional.ofNullable(storage.get(uid));
    }

    @Override
    public void save(ClientEntity entity) {
        storage.put(entity.getUid(), entity);
    }

    @Override
    public void delete(UUID uid) {
        storage.remove(uid);
    }
}

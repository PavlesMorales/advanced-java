package ru.antonov.client.core.configuration;

import ru.antonov.client.core.converter.ClientConverterImpl;
import ru.antonov.client.core.model.ClientEntity;
import ru.antonov.client.core.repository.InMemoryClientRepository;
import ru.antonov.client.core.service.ClientCoreService;
import ru.antonov.client.core.service.impl.ClientCoreServiceImpl;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class Config {

    public static ClientCoreService createClientCoreService() {
        final var clientConverter = new ClientConverterImpl();
        final var hashMap = new ConcurrentHashMap<UUID, ClientEntity>();
        final var inMemoryClientRepository = new InMemoryClientRepository(hashMap);

        return new ClientCoreServiceImpl(
                clientConverter,
                inMemoryClientRepository);
    }
}

package ru.antonov.client.provider.service.impl;

import lombok.RequiredArgsConstructor;
import ru.antonov.client.provider.dto.ClientDataDto;
import ru.antonov.client.provider.service.ClientDataService;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public final class ClientDataServiceImpl implements ClientDataService {

    private final Map<UUID, ClientDataDto> storage;

    @Override
    public Optional<ClientDataDto> getClientData(final UUID uid) {
        return Optional.ofNullable(storage.get(uid));
    }
}

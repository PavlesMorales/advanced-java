package ru.antonov.client.core.service;


import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.core.service.impl.ClientCoreServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public sealed interface ClientCoreService permits ClientCoreServiceImpl {

    Optional<ClientCoreDto> getClientByUid(UUID uid);

    List<ClientCoreDto> getAll();

    void save(ClientCoreDto dto);

    void delete(UUID uid);
}

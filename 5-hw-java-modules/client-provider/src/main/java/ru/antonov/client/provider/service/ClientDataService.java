package ru.antonov.client.provider.service;

import ru.antonov.client.provider.dto.ClientDataDto;
import ru.antonov.client.provider.service.impl.ClientDataServiceImpl;

import java.util.Optional;
import java.util.UUID;


public sealed interface ClientDataService permits ClientDataServiceImpl {

    Optional<ClientDataDto> getClientData(UUID uid);
}

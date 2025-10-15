package ru.antonov.client.service.converter;

import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.service.dto.ClientDto;

public interface ClientServiceConverter {

    ClientDto toDto(ClientCoreDto dto);
}

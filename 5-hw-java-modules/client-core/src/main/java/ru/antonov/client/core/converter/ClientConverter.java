package ru.antonov.client.core.converter;

import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.core.model.ClientEntity;

public interface ClientConverter {

    ClientCoreDto toDto(ClientEntity entity);

    ClientEntity toEntity(ClientCoreDto dto);
}

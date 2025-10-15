package ru.antonov.client.service.converter;

import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.service.dto.ClientDto;

public class ClientServiceConverterImpl implements ClientServiceConverter {

    @Override
    public ClientDto toDto(final ClientCoreDto dto) {

        return ClientDto.builder()
                .uid(dto.uid())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .inn(dto.inn())
                .photoRef(dto.photoRef())
                .build();
    }
}

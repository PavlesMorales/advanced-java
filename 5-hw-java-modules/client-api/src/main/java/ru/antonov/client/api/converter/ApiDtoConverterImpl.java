package ru.antonov.client.api.converter;

import org.springframework.stereotype.Component;
import ru.antonov.client.api.dto.ClientApiDto;
import ru.antonov.client.service.dto.ClientDto;

@Component
public class ApiDtoConverterImpl implements ApiDtoConverter {

    @Override
    public ClientApiDto toDto(final ClientDto dto) {
        return ClientApiDto.builder()
                .uid(dto.uid())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .photoRef(dto.photoRef())
                .inn(dto.inn())
                .build();
    }
}

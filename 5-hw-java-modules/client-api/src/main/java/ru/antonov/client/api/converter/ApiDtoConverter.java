package ru.antonov.client.api.converter;

import ru.antonov.client.api.dto.ClientApiDto;
import ru.antonov.client.service.dto.ClientDto;

public interface ApiDtoConverter {

    ClientApiDto toDto(ClientDto dto);
}

package ru.antonov.client.core.converter;

import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.core.model.ClientEntity;

public class ClientConverterImpl implements ClientConverter {

    @Override
    public ClientCoreDto toDto(final ClientEntity entity) {
        return ClientCoreDto.builder()
                .uid(entity.getUid())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .inn(entity.getInn())
                .photoRef(entity.getPhotoRef())
                .build();
    }

    @Override
    public ClientEntity toEntity(final ClientCoreDto dto) {
        final var entity = new ClientEntity();
        entity.setUid(dto.uid());
        entity.setFirstName(dto.firstName());
        entity.setLastName(dto.lastName());
        entity.setInn(dto.inn());
        entity.setPhotoRef(dto.photoRef());
        return entity;
    }
}

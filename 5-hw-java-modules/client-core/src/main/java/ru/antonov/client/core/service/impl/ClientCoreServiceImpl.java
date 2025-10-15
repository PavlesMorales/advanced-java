package ru.antonov.client.core.service.impl;

import lombok.RequiredArgsConstructor;
import ru.antonov.client.core.converter.ClientConverter;
import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.core.model.ClientEntity;
import ru.antonov.client.core.repository.ClientRepository;
import ru.antonov.client.core.service.ClientCoreService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public final class ClientCoreServiceImpl implements ClientCoreService {

    private final ClientConverter converter;

    private final ClientRepository<ClientEntity, UUID> repository;


    @Override
    public Optional<ClientCoreDto> getClientByUid(final UUID uid) {
        return repository.findByUid(uid)
                .map(converter::toDto);
    }

    @Override
    public List<ClientCoreDto> getAll() {
        return repository.findAll()
                .stream()
                .map(converter::toDto)
                .toList();
    }

    @Override
    public void save(final ClientCoreDto dto) {
        final var entity = converter.toEntity(dto);
        repository.save(entity);
    }

    @Override
    public void delete(final UUID uid) {
        repository.delete(uid);
    }
}

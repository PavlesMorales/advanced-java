package ru.antonov.client.service.service.impl;

import lombok.RequiredArgsConstructor;
import ru.antonov.client.core.dto.ClientCoreDto;
import ru.antonov.client.core.service.ClientCoreService;
import ru.antonov.client.provider.dto.ClientDataDto;
import ru.antonov.client.provider.service.ClientDataService;
import ru.antonov.client.provider.service.ClientRefPhotoService;
import ru.antonov.client.service.converter.ClientServiceConverter;
import ru.antonov.client.service.dto.ClientDto;
import ru.antonov.client.service.exception.ClientNotFoundException;
import ru.antonov.client.service.exception.ClientPersonDataNotFound;
import ru.antonov.client.service.service.ClientService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public final class ClientServiceImpl implements ClientService {

    private final ClientDataService clientDataService;

    private final ClientRefPhotoService refPhotoService;

    private final ClientCoreService clientCoreService;

    private final ClientServiceConverter converter;


    @Override
    public ClientDto getClient(final UUID uid) {
        final var clientCoreDto = clientCoreService.getClientByUid(uid)
                .orElseThrow(() -> new ClientNotFoundException("Client with uid [%s] not found".formatted(uid)));
        return converter.toDto(clientCoreDto);
    }

    @Override
    public void filClientData(final UUID uid) {
        final ClientDataDto clientData = clientDataService.getClientData(uid)
                .orElseThrow(() -> new ClientPersonDataNotFound("Client with uid [%s] person data not found".formatted(uid)));

        final String refPhoto = refPhotoService.refPhoto(uid);

        final var clientCoreDto = ClientCoreDto.builder()
                .uid(uid)
                .firstName(clientData.firstName())
                .lastName(clientData.lastName())
                .inn(clientData.inn())
                .photoRef(refPhoto)
                .build();

        clientCoreService.save(clientCoreDto);
    }

    @Override
    public List<ClientDto> getClients() {
        return clientCoreService.getAll()
                .stream()
                .map(converter::toDto)
                .toList();
    }

    @Override
    public void deleteClient(final UUID uid) {
        clientCoreService.delete(uid);
    }
}

package ru.antonov.client.service.service;


import ru.antonov.client.service.dto.ClientDto;
import ru.antonov.client.service.service.impl.ClientServiceImpl;

import java.util.List;
import java.util.UUID;

public sealed interface ClientService permits ClientServiceImpl {

    ClientDto getClient(UUID uid);

    void filClientData(UUID uid);

    List<ClientDto> getClients();

    void deleteClient(UUID uid);
}

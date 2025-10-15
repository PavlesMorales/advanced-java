package ru.antonov.client.service.configuration;

import ru.antonov.client.service.converter.ClientServiceConverterImpl;
import ru.antonov.client.service.service.ClientService;
import ru.antonov.client.service.service.impl.ClientServiceImpl;

import static ru.antonov.client.core.configuration.Config.createClientCoreService;
import static ru.antonov.client.provider.configuration.Config.clientDataService;
import static ru.antonov.client.provider.configuration.Config.clientRefPhotoService;

public final class Config {

    public static ClientService clientService() {
        return new ClientServiceImpl(
                clientDataService(),
                clientRefPhotoService(),
                createClientCoreService(),
                new ClientServiceConverterImpl()
        );
    }
}

module client.service {
    requires static lombok;

    requires client.core;
    requires client.provider;

    exports ru.antonov.client.service.dto;
    exports ru.antonov.client.service.service;
    exports ru.antonov.client.service.exception;
    exports ru.antonov.client.service.configuration;
}
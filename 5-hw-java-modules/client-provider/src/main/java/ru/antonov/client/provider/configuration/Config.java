package ru.antonov.client.provider.configuration;

import ru.antonov.client.provider.dto.ClientDataDto;
import ru.antonov.client.provider.service.ClientDataService;
import ru.antonov.client.provider.service.ClientRefPhotoService;
import ru.antonov.client.provider.service.impl.ClientDataServiceImpl;
import ru.antonov.client.provider.service.impl.ClientRefPhotoServiceImpl;

import java.util.Map;
import java.util.UUID;

public final class Config {

    public static ClientDataService clientDataService() {
        return new ClientDataServiceImpl(Map.of(
                UUID.fromString("83228a80-8306-46a1-88d6-61749f87827d"), ClientDataDto.builder()
                        .uid(UUID.fromString("83228a80-8306-46a1-88d6-61749f87827d"))
                        .firstName("Ivan")
                        .lastName("Ivanov")
                        .inn("9223435693")
                        .build(),
                UUID.fromString("5717b7c3-4744-4ef4-82fb-90dd747260fc"), ClientDataDto
                        .builder()
                        .uid(UUID.fromString("5717b7c3-4744-4ef4-82fb-90dd747260fc"))
                        .firstName("Semen")
                        .lastName("Semenov")
                        .inn("1092232555")
                        .build(),
                UUID.fromString("8988f5fb-9e16-4fca-8ab6-98f5c535b75a"), ClientDataDto
                        .builder()
                        .uid(UUID.fromString("8988f5fb-9e16-4fca-8ab6-98f5c535b75a"))
                        .firstName("Peter")
                        .lastName("Petrov")
                        .build(),
                UUID.fromString("1fcd0c60-225c-4e7d-9beb-40862118488c"), ClientDataDto
                        .builder()
                        .uid(UUID.fromString("1fcd0c60-225c-4e7d-9beb-40862118488c"))
                        .firstName("Alex")
                        .inn("9984421323")
                        .build()
        ));
    }

    public static ClientRefPhotoService clientRefPhotoService() {
        return new ClientRefPhotoServiceImpl();
    }
}

package ru.antonov.client.provider.service;

import ru.antonov.client.provider.service.impl.ClientRefPhotoServiceImpl;

import java.util.UUID;

public sealed interface ClientRefPhotoService permits ClientRefPhotoServiceImpl {

    String refPhoto(UUID uid);
}

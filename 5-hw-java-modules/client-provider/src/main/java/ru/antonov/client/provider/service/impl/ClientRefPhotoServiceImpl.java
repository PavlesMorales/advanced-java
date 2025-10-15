package ru.antonov.client.provider.service.impl;

import ru.antonov.client.provider.service.ClientRefPhotoService;

import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public final class ClientRefPhotoServiceImpl implements ClientRefPhotoService {

    @Override
    public String refPhoto(final UUID uid) {
        byte[] array = new byte[30];
        new Random().nextBytes(array);
        return Base64.getEncoder().encodeToString(array);
    }
}

package ru.antonov.client.service.exception;

public final class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(final String message) {
        super(message);
    }
}

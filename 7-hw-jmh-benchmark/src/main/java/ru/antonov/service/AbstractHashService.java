package ru.antonov.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public abstract class AbstractHashService implements HashService {

    public abstract MessageDigest getMessageDigest();

    @Override
    public String hash(final String input) {
        final var digest = getMessageDigest().digest(input.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(digest);
    }

    private String bytesToHex(byte[] bytes) {
        var builder = new StringBuilder();
        for (var b : bytes) {
            builder.append(String.format("%02x", b & 0xff));
        }
        return builder.toString().toUpperCase();
    }

}

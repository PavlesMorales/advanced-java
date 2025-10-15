package ru.antonov.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AbstractHashService implements HashService {

    public abstract String getAlgorithm();

    @Override
    public String hash(final String input) {
        try {
            synchronized (this) {
                MessageDigest messageDigest = MessageDigest.getInstance(getAlgorithm());
                final var digest = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
                return bytesToHex(digest);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        var builder = new StringBuilder();
        for (var b : bytes) {
            builder.append(String.format("%02x", b & 0xff));
        }
        return builder.toString().toUpperCase();
    }

}

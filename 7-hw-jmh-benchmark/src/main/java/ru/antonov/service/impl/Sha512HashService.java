package ru.antonov.service.impl;

import ru.antonov.service.AbstractHashService;

import java.security.MessageDigest;

public class Sha512HashService extends AbstractHashService {

    private static final String ALGORITHM_TYPE = "SHA512";

    private final MessageDigest md;

    public Sha512HashService(final MessageDigest md) {
        if (!ALGORITHM_TYPE.equals(md.getAlgorithm())) {
            throw new IllegalArgumentException();
        }
        this.md = md;
    }

    @Override
    public MessageDigest getMessageDigest() {
        return md;
    }
}

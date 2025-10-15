package ru.antonov.service.impl;

import ru.antonov.service.AbstractHashService;

import java.security.MessageDigest;


public class Sha256HashService extends AbstractHashService {

    private static final String ALGORITHM_TYPE = "SHA256";

    private final MessageDigest md;

    public Sha256HashService(final MessageDigest md) {
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

package ru.antonov.service.impl;

import ru.antonov.service.AbstractHashService;

import java.security.MessageDigest;

public class Md5HashService extends AbstractHashService {

    private static final String ALGORITHM_TYPE = "MD5";

    private final MessageDigest md;

    public Md5HashService(MessageDigest md) {
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

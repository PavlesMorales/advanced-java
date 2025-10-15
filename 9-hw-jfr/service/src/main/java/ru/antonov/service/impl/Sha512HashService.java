package ru.antonov.service.impl;

import ru.antonov.service.AbstractHashService;

public class Sha512HashService extends AbstractHashService {

    private static final String ALGORITHM_TYPE = "SHA512";

    @Override
    public String getAlgorithm() {
        return ALGORITHM_TYPE;
    }
}

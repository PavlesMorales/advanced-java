package ru.antonov.service.impl;

import ru.antonov.service.AbstractHashService;


public class Sha256HashService extends AbstractHashService {

    private static final String ALGORITHM_TYPE = "SHA256";

    @Override
    public String getAlgorithm() {
        return ALGORITHM_TYPE;
    }
}

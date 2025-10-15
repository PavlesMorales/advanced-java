package ru.antonov.service.impl;

import ru.antonov.service.AbstractHashService;

public class Md5HashService extends AbstractHashService {

    private static final String ALGORITHM_TYPE = "MD5";

    @Override
    public String getAlgorithm() {
        return ALGORITHM_TYPE;
    }
}

package ru.antonov.service;

import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;

public interface UserService {

    UserDtoRs registerUser(UserDtoRq userRq);

    UserDtoRs loginUser(UserDtoRq request);
}

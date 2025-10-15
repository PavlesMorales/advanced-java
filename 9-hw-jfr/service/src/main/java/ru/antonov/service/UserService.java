package ru.antonov.service;

import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;

import java.util.List;

public interface UserService {

    UserDtoRs registerUser(UserDtoRq userRq);

    UserDtoRs loginUser(UserDtoRq request);

    List<UserDtoRs> getUsers();
}

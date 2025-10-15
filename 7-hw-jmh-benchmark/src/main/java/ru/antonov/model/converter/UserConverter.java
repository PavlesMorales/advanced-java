package ru.antonov.model.converter;

import ru.antonov.model.User;
import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;

public interface UserConverter {

    User toEntity(UserDtoRq userDtoRq);

    UserDtoRs toDto(User user);
}

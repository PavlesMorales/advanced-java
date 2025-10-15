package ru.antonov.model.converter;

import org.springframework.stereotype.Component;
import ru.antonov.model.User;
import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User toEntity(final UserDtoRq userDtoRq) {
        final User user = new User();
        user.setLogin(userDtoRq.getLogin());
        return user;
    }

    @Override
    public UserDtoRs toDto(final User user) {
        return UserDtoRs.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}

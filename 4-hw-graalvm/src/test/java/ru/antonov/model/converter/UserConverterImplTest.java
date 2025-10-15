package ru.antonov.model.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.antonov.Main;
import ru.antonov.model.User;
import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserConverterImplTest {

    UserConverterImpl subj;

    @BeforeEach
    void init() {
        subj = new UserConverterImpl();
    }

    @Test
    void toEntity() {
        UserDtoRs expected = UserDtoRs.builder()
                .id(1L)
                .login("Login")
                .password("Password")
                .build();

        User user = new User();
        user.setId(1L);
        user.setLogin("Login");
        user.setPassword("Password");
        UserDtoRs actual = subj.toDto(user);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void toDto() {
        User expected = new User();

        expected.setLogin("Login");
        expected.setPassword("Password");

        UserDtoRq userDtoRq = UserDtoRq.builder()
                .login("Login")
                .password("Password")
                .build();

        User actual = subj.toEntity(userDtoRq);
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
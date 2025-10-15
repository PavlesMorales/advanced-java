package ru.antonov.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDtoRs {

    private Long id;

    private String login;

    private String password;
}

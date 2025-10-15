package ru.antonov.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class UserDtoRq {

    @NotBlank
    @Size(min = 1, max = 255)
    private final String login;

    @NotBlank
    @Size(min = 1, max = 255)
    private final String password;
}

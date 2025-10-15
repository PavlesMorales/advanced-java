package ru.antonov.client.provider.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClientDataDto(
        UUID uid,
        String firstName,
        String lastName,
        String inn) {
}

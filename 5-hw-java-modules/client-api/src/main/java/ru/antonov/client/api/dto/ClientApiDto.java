package ru.antonov.client.api.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClientApiDto(
        UUID uid,
        String firstName,
        String lastName,
        String inn,
        String photoRef) {
}

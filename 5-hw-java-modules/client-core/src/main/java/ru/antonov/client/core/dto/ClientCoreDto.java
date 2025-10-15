package ru.antonov.client.core.dto;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record ClientCoreDto(
        UUID uid,
        String firstName,
        String lastName,
        String inn,
        String photoRef
) {
}

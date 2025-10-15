package ru.antonov.client.service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record ClientDto(
        UUID uid,
        String firstName,
        String lastName,
        String inn,
        String photoRef) {
}

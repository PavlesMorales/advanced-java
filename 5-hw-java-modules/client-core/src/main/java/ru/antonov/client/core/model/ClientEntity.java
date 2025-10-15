package ru.antonov.client.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class ClientEntity {

    private Long id;

    private UUID uid;

    private String firstName;

    private String lastName;

    private String inn;

    private String photoRef;

}

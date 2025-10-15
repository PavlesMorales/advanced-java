package ru.antonov.client.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.antonov.client.api.converter.ApiDtoConverter;
import ru.antonov.client.api.dto.ClientApiDto;
import ru.antonov.client.service.service.ClientService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    private final ApiDtoConverter converter;

    @GetMapping("/clients/{uid}")
    public ClientApiDto getClient(@PathVariable("uid") UUID uid) {
        log.info("request client with uid: [{}]", uid);
        return converter.toDto(service.getClient(uid));
    }

    @GetMapping("/clients")
    public List<ClientApiDto> getAllClients() {
        log.info("request all clients");
        return service.getClients()
                .stream()
                .map(converter::toDto)
                .toList();
    }

    @PostMapping("/clients/{uid}")
    @ResponseStatus(HttpStatus.OK)
    public void fillClientData(@PathVariable("uid") UUID uid) {
        log.info("request fill client with uid: [{}]", uid);
        service.filClientData(uid);
    }

    @DeleteMapping("/clients/{uid}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable("uid") UUID uid) {
        log.info("request delete client with uid: [{}]", uid);
        service.deleteClient(uid);
    }
}

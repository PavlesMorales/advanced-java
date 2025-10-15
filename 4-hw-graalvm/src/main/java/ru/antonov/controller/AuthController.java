package ru.antonov.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonov.cache.Cache;
import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;
import ru.antonov.service.UserService;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final Cache<UserDtoRq, UserDtoRs> cache;

    @PostMapping("/register")
    public UserDtoRs register(@Valid @RequestBody UserDtoRq request) {
        log.info("Incoming request on register: {}", request.getLogin());
        final UserDtoRs response = userService.registerUser(request);
        cache.put(request, response);
        return response;
    }

}

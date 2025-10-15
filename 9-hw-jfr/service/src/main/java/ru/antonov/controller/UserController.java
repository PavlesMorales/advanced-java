package ru.antonov.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonov.model.dto.UserDtoRs;
import ru.antonov.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<UserDtoRs> getUsers() {
        log.info("user controller");
        List<UserDtoRs> users = userService.getUsers();
        log.info("response size {}", users.size());
        return users;
    }
}

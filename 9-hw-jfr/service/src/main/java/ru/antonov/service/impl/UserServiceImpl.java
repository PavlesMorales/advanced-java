package ru.antonov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.antonov.exception.UserAlreadyExistsException;
import ru.antonov.exception.UserNotFoundException;
import ru.antonov.model.User;
import ru.antonov.model.converter.UserConverter;
import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;
import ru.antonov.repository.UserRepository;
import ru.antonov.service.HashService;
import ru.antonov.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserConverter converter;

    private final HashService hashService;


    @Override
    public UserDtoRs registerUser(final UserDtoRq userRq) {
        if (repository.existsByLogin(userRq.getLogin())) {
            throw new UserAlreadyExistsException("User already exists");
        }

        final var byLogin = repository.findByLogin(userRq.getLogin());
        if (byLogin.isPresent()) {
            final var user = byLogin.get();
        }

        final User newUser = converter.toEntity(userRq);
        final var hash = hashService.hash(userRq.getPassword());
        newUser.setHash(hash);

        final User savedUser = repository.save(newUser);
        return converter.toDto(savedUser);
    }

    @Override
    public UserDtoRs loginUser(final UserDtoRq request) {
        final var hash = hashService.hash(request.getPassword());
        final User user = repository.findByLoginAndHash(request.getLogin(), hash)
                .orElseThrow(UserNotFoundException::new);
        return converter.toDto(user);

    }

    @Override
    public List<UserDtoRs> getUsers() {
        List<User> allByIdIn = repository.findAllByIdIn(getRandomInts());
        return allByIdIn.stream().map(converter::toDto).toList();
    }


    private List<Integer> getRandomInts() {
        return new Random().ints(65500, 0, 200_000)
                .boxed()
                .toList();

    }

}

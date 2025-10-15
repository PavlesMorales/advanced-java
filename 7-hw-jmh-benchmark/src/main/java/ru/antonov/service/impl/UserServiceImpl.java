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

        final User newUser = converter.toEntity(userRq);
        newUser.setHash(hashService.hash(userRq.getPassword()));
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

}

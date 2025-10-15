package ru.antonov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.antonov.exception.UserAlreadyExistsException;
import ru.antonov.model.User;
import ru.antonov.model.converter.UserConverter;
import ru.antonov.model.dto.UserDtoRq;
import ru.antonov.model.dto.UserDtoRs;
import ru.antonov.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserConverter converter;


    @Override
    public UserDtoRs registerUser(final UserDtoRq userRq) {
        if (repository.existsByLogin(userRq.getLogin())) {
            throw new UserAlreadyExistsException("User already exists");
        }

        final User newUser = converter.toEntity(userRq);
        final User savedUser = repository.save(newUser);
        return converter.toDto(savedUser);
    }

}

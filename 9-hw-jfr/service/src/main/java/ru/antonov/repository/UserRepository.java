package ru.antonov.repository;


import org.springframework.data.repository.CrudRepository;
import ru.antonov.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndHash(String login, String hash);

    List<User> findAllByIdIn(List<Integer> randomInts);
}

package ru.antonov.repository;


import org.springframework.data.repository.CrudRepository;
import ru.antonov.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByLogin(String login);
}

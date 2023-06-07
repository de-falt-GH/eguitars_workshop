package backend.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}
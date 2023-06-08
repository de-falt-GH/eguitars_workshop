package backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
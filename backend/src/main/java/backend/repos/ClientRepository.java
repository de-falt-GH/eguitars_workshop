package backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByPhoneNumber(String phoneNumber);
}
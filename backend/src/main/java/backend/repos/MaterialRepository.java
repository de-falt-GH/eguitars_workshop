package backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.models.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Material findByName(String name);
}
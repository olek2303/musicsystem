package dev.musicsystem.musicsystem.repositories;

import dev.musicsystem.musicsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

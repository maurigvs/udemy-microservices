package br.edu.maurigvs.hruser.repositories;

import br.edu.maurigvs.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // See more on Sprint Data JPA Query Methods
    User findByEmail(String email);
}

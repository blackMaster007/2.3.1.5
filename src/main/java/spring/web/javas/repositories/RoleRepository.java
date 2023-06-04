package spring.web.javas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.web.javas.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

package spring.web.javas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.web.javas.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u left join fetch u.roles where u.email=:email")
     User findByEmail(@Param("email") String email);

    @Override
    @Query("select distinct u from User u left join fetch u.roles")
    List<User> findAll();
}

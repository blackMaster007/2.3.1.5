package spring.web.javas.service;

import spring.web.javas.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    void save(Role role);
    void delete(Role role);
    Role findById(Long id);
    Iterable<Role> findAllById (List<Long> list);
    Role findRoleByName(String authority);
}

package spring.web.javas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;
import spring.web.javas.model.Role;
import spring.web.javas.repositories.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Iterable<Role> findAllById(List<Long> list) {
        return roleRepository.findAllById(list);
    }

    @Override
    public Role findRoleByName(String nameRole) throws NoSuchElementException {
        return findAll().stream()
                .filter(r -> nameRole.equals(r.getAuthority()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Role  not found"));
    }
}

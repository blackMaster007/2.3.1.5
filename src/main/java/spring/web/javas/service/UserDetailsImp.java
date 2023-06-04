package spring.web.javas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.web.javas.model.User;
import spring.web.javas.repositories.UserRepository;


@Service
public class UserDetailsImp implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public UserDetailsImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException(String.format("Пользовательс с именем '%s' не найден", email));
        return user;
    }


}

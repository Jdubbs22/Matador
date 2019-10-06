package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.User;
import edu.depaul.cdm.se.matador.service.UserService;
import edu.depaul.cdm.se.matador.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("MEMBER");

        roles.add(role);
        user.setRoles(roles);
        return this.userRepo.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return this.userRepo.findById(id);
    }
}

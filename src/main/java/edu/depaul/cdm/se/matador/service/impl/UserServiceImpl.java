package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.User;
import edu.depaul.cdm.se.matador.service.UserService;
import edu.depaul.cdm.se.matador.service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }
}

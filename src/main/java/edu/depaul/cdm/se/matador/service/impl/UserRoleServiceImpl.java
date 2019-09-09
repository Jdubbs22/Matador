package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.User;
import edu.depaul.cdm.se.matador.service.UserRoleService;
import edu.depaul.cdm.se.matador.service.dao.UserRoleDao;
import edu.depaul.cdm.se.matador.service.repository.RoleRepo;
import edu.depaul.cdm.se.matador.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleDao userRoleDao;
    private RoleRepo roleRepo;
    private UserRepository userRepo;

    public UserRoleServiceImpl(UserRoleDao userRoleDao, RoleRepo roleRepo, UserRepository userRepo) {
        this.userRoleDao = userRoleDao;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public User addRole(Long userId, String roleName) {
//        addRole(1L, "SUPER_ROLE");   //this cannot exist for exmp.
//        this.roleRepo.findById("SUPER_ROLE");
        Optional<Role> roleOption = this.roleRepo.findById(roleName);
        Optional<User> userOption = this.userRepo.findById(userId);
        if (roleOption.isPresent() && userOption.isPresent()) {
            this.userRoleDao.addRole(userId, roleName);
            return this.userRepo.findById(userId).get();
        }

        return null;
    }
}

package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.service.RoleService;
import edu.depaul.cdm.se.matador.service.repository.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role createRole(Role role) {
        return this.roleRepo.save(role);
    }
}

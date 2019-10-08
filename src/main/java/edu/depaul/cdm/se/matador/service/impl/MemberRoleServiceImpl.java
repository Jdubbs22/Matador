package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.service.MemberRoleService;
import edu.depaul.cdm.se.matador.service.dao.MemberRoleDao;
import edu.depaul.cdm.se.matador.service.repository.RoleRepo;
import edu.depaul.cdm.se.matador.service.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: change to MemberRoleServiceImpl
@Service
public class MemberRoleServiceImpl implements MemberRoleService {

    private MemberRoleDao memberRoleDao;
    private RoleRepo roleRepo;
    private MemberRepository userRepo;

    public MemberRoleServiceImpl(MemberRoleDao memberRoleDao, RoleRepo roleRepo, MemberRepository userRepo) {
        this.memberRoleDao = memberRoleDao;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @Override

    public Member addRole(Long userId, String roleName) {
//        addRole(1L, "SUPER_ROLE");   //this cannot exist for exmp.
//        this.roleRepo.findById("SUPER_ROLE");
        // TODO: accept role 'admin' as 'ADMIN'
        Optional<Role> roleOption = this.roleRepo.findById(roleName);
        Optional<Member> userOption = this.userRepo.findById(userId);
        if (roleOption.isPresent() && userOption.isPresent()) {
            int updated = this.memberRoleDao.addRole(userId, roleName);
            return this.userRepo.findById(userId).get();
        }

        return null;
    }
}

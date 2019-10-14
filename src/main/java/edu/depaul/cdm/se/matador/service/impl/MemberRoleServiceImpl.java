package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.service.MemberRoleService;
import edu.depaul.cdm.se.matador.service.dao.MemberRoleDao;
import edu.depaul.cdm.se.matador.service.repository.RoleRepo;
import edu.depaul.cdm.se.matador.service.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (!roleOption.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                String.format("The role %s doesn't exist", roleName));
        }

        Optional<Member> userOption = this.userRepo.findById(userId);
        if (roleOption.isPresent() && userOption.isPresent()) {

            // Here we add role to member
            // TODO: If role is instructor and the member is not instructor yet
            // then create instructor object.
            // Link/Correlate that instructor object with Member
            // Save instructor into database


            // update role
            int updated = this.memberRoleDao.addRole(userId, roleName);
            return this.userRepo.findById(userId).get();
        }

        return null;
    }
}

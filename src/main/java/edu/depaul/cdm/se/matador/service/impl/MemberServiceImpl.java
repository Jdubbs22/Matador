package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.service.MemberService;
import edu.depaul.cdm.se.matador.service.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepo;

    public MemberServiceImpl(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public Member create(Member member) {

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("MEMBER");

        roles.add(role);
        member.setRoles(roles);
        return this.memberRepo.save(member);
    }

    @Override
    public Optional<Member> findUserById(Long id) {
        return this.memberRepo.findById(id);
    }
}

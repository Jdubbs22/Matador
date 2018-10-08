package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
//    @Autowired
    private MemberRepository memberRepo;
    @Autowired
    public MemberServiceImpl(MemberRepository memRepo) {
        this.memberRepo = memRepo;
    }
    @Override
    public Member create(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("member must not be null");
        }//end if
        if(member.getId() != null) {
            Member m = this.memberRepo.findOneById(member.getId());
            if (m != null) {
                throw new IllegalStateException("The member already existed in database");
            }//end internal if
            else {
                return this.memberRepo.save(member);
            }//end else
        }//end if
        else {
            return this.memberRepo.save(member);
        }//end else
    }//end create

    @Override
    public Member readById(Long id) {
        return null;
    }

    @Override
    public Boolean update(Member member) {
        return null;
    }

    @Override
    public Boolean delete(Member member) {
        return null;
    }

    @Override
    public List<Member> getAll() {
        return memberRepo.findAll();
    }
}

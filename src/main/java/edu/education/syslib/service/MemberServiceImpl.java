package edu.education.syslib.service;

import edu.education.syslib.model.Member;
import edu.education.syslib.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member getMemberById(long id) {
        Optional<Member> optional = memberRepository.findById(id);
        Member member = null;
        if(optional.isPresent()) {
            member = optional.get();
        } else throw new RuntimeException("Member by id " + id + " was not found");

        return member;
    }

    @Override
    public void deleteMember(long id) {
        memberRepository.deleteById(id);
    }
}

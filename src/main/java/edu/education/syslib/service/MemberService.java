package edu.education.syslib.service;

import edu.education.syslib.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();
    void saveMember(Member member);
    Member getMemberById(long id);
    void deleteMember(long id);
}

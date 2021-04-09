package edu.education.syslib.controller;

import edu.education.syslib.model.Member;
import edu.education.syslib.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public String getAllMembers(Model model) {
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "view_member";
    }

    @GetMapping("/showNewMemberForm")
    public String showNewMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "new_member";
    }

    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping("/{id}")
    public String showMember(@PathVariable(value = "id") long id, Model model) {
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "show_member";
    }

    @GetMapping("/updateMember/{id}")
    public String updateMember(@PathVariable(value = "id") long id, Model model) {
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "update_member";
    }

    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable(value = "id") long id) {
        memberService.deleteMember(id);
        return "redirect:/members";
    }

}

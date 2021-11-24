package com.keyin.SprintProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repo;

    public List<Member> listAll(){
        return repo.findAll();
    }

    public void save(Member member){
        repo.save(member);
    }

    public Member get(Integer id){
        return repo.findById(id).get();
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}

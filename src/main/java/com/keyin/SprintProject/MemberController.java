package com.keyin.SprintProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/members")
    public List<Member> listAll(){
        return service.listAll();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getByID(@PathVariable Integer id) {
        try {
            Member member = service.get(id);
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/members")
    public void addNewMember(@RequestBody Member member){
        service.save(member);
    }

    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}

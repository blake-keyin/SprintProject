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
//get mapping for all members
    @GetMapping("/members")
    public List<Member> listAll(){
        return service.listAll();
    }
//get mapping for members by id
    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getByID(@PathVariable Integer id) {
        try {
            Member member = service.get(id);
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }
    }
//post mapping for posting new information to the table
    @PostMapping("/members")
    public void addNewMember(@RequestBody Member member){
        service.save(member);
    }
//delete mapping for removing information from the table by id
    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}

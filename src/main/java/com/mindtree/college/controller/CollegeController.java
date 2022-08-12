package com.mindtree.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.college.VO.RequestTemplateVO;
import com.mindtree.college.entity.College;
import com.mindtree.college.service.CollegeService;



@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @PostMapping("/")
    public College add(@RequestBody College col) {
        
        return  collegeService.add(col);
    }

    @GetMapping
     public List<College> list(){
    	return collegeService.list();
    }
    
    @GetMapping("/{id}")
    public College searchById(@PathVariable long id) {
    	return collegeService.searchById(id);
    }
    
    @GetMapping("/all-college-student")
    public List<RequestTemplateVO> listWithStudent(){
    	return collegeService.listWithStudent();
    }
    
    @GetMapping("/college-with-student/{col_id}")
    public RequestTemplateVO specificCollegeStudent(@PathVariable long col_id) {
    	return collegeService.specificCollegeStudent(col_id);
    }
}
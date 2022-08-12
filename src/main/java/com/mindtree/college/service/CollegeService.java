package com.mindtree.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.college.VO.RequestTemplateVO;
import com.mindtree.college.entity.College;


@Service
public interface CollegeService {

	List<College> list();

	College searchById(long id);

	List<RequestTemplateVO> listWithStudent();

	College add(College col);

	RequestTemplateVO specificCollegeStudent(long dept_id);
	
	College update(long id, String name);
	
	
	
	
	
	
	
	
	

}

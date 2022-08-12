package com.mindtree.college.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.college.VO.Student;
import com.mindtree.college.VO.RequestTemplateVO;
import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;
import com.mindtree.college.service.CollegeService;

@Component
public class CollegeImpl implements CollegeService{
	
	@Autowired
	CollegeRepository collegeRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	

	@Override
	public List<College> list() {
		// TODO Auto-generated method stub
		return collegeRepo.findAll();
	}

	@Override
	public College searchById(long id) {
		if(collegeRepo.findById(id)==null) {
		return null;
		}
		return collegeRepo.findById(id);
	}

	@Override
	public List<RequestTemplateVO> listWithStudent() {
		List<RequestTemplateVO> fullList=new ArrayList<RequestTemplateVO>();
		List<College> allCollege=this.list();
		Iterator<College> ir=allCollege.iterator();
		while(ir.hasNext())
		{
			College col=ir.next();
			ResponseEntity<Student[]> responce=
					restTemplate.getForEntity(
							"http://STUDENT-SERVICE/student/student-with-ascname/"+col.getId(),Student[].class);
			Student[] student=responce.getBody();
			List<Student> stus=Arrays.asList(student);
			RequestTemplateVO rtm=new RequestTemplateVO();
			rtm.setCollege(col);
			rtm.setStudentList(stus);
			fullList.add(rtm);
			
		}
		
		return fullList;
	}

	@Override
	public College add(College col) {
		// TODO Auto-generated method stub
		return collegeRepo.save(col);
	}

	@Override
	public RequestTemplateVO specificCollegeStudent(long col_id) {
		College col=this.searchById(col_id);
		
		ResponseEntity<Student[]> responce=
				restTemplate.getForEntity(
						"http://STUDENT-SERVICE/student/student-with-desc-age/"+col.getId(),
						Student[].class);
		
		Student[] stu=responce.getBody();
		List<Student> student=Arrays.asList(stu);
		RequestTemplateVO RT=new RequestTemplateVO();
		RT.setCollege(col);
		RT.setStudentList(student);
		
		return RT;
	}

	@Override
	public College update(long id, String name) {
		College col=collegeRepo.findById(id);
		col.setColName(name);
		return collegeRepo.save(col);
	}
	
	

}

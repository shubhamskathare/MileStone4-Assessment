package com.mindtree.college;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;

@SpringBootTest
class CollegeServiceApplicationTests {
	@Autowired
	CollegeRepository colRepo;

	@Test
	public void  testC() {
		College c=new College();
		c.setId(1L);
		c.setColName("BEC");
		c.setNoStu(25);
		
		colRepo.save(c);
		assertNotNull(colRepo.findById(1).getId());
	}

}

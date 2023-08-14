package com.kaamkuro.kaamkuro;

import com.kaamkuro.kaamkuro.entity.AuthUser;
import com.kaamkuro.kaamkuro.entity.Job;
import com.kaamkuro.kaamkuro.repo.AuthUserRepo;
import com.kaamkuro.kaamkuro.repo.JobRepo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class KaamkuroApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private AuthUserRepo userRepo;
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveEmployeeTest(){

		AuthUser employee = AuthUser.builder()
				.id(1)
				.password("aasu")
				.email("koju@gmail.com")
				.build();

		userRepo.save(employee);
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public  void getCustomerTest(){
		AuthUser employeeCreated= userRepo.findById(1).get();
		Assertions.assertThat(employeeCreated.getId()).isEqualTo(1);
	}

	@Test
	@Order(3)
	public void getListOfCustomerTest(){
		List<AuthUser> users = userRepo.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateCustomerTest(){

		AuthUser user = userRepo.findById(1).get();
		user.setEmail("pj@gmail.com");
		AuthUser customerUpdated =  userRepo.save(user);

		Assertions.assertThat(customerUpdated.getEmail()).isEqualTo("pj@gmail.com");

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteUserTest(){
		AuthUser user = userRepo.findById(1).get();
		userRepo.delete(user);

		AuthUser user1 = null;
		Optional<AuthUser> opUser = userRepo.findById(1);
		if(opUser.isPresent()){
			user1 = opUser.get();
		}
		Assertions.assertThat(user1).isNull();
	}

	//Job posting test
	@Autowired
	private JobRepo jobRepo;

	@Test
	@Order(6)
	@Rollback(value = false)
	public void saveJobTest(){
		Job job = Job.builder()
				.id(1)
				.jobType("part time")
				.salary("100000")
				.jobPosition("CEO")
				.companyName("Company")
				.build();
		jobRepo.save(job);
		Assertions.assertThat(job.getId()).isGreaterThan(0);
	}

	@Test
	@Order(7)
	public  void getJobsTest(){
		Job job= jobRepo.findById(1).get();
		Assertions.assertThat(job.getId()).isEqualTo(1);
	}

	@Test
	@Order(8)
	public void getListOfJobTest(){
		List<Job> job = jobRepo.findAll();
		Assertions.assertThat(job.size()).isGreaterThan(0);
	}

	@Test
	@Order(9)
	public void updateJobTest(){
		Job job = jobRepo.findById(1).get();
		job.setSalary("100000");
		Job jobUpdate =  jobRepo.save(job);

		Assertions.assertThat(jobUpdate.getSalary()).isEqualTo("100000");
	}
	@Test
	@Order(10)
	@Rollback(value = false)
	public void deleteJobTest(){
		Job job = jobRepo.findById(1).get();
		jobRepo.delete(job);

		Job firstjob = null;
		Optional<Job> optionalJob = jobRepo.findById(1);
		if(optionalJob.isPresent()){
			firstjob = optionalJob.get();
		}
		Assertions.assertThat(firstjob).isNull();
	}
}

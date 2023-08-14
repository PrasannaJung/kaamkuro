package com.kaamkuro.kaamkuro;

import com.kaamkuro.kaamkuro.entity.AuthUser;
import com.kaamkuro.kaamkuro.repo.AuthUserRepo;
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


}

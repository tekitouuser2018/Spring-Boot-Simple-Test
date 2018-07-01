package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@SpringBootTest(classes=UnitTestSampleApplication.class)
public class RepositoryTest {

	@Autowired
	private TestRepository testRepository;

	private UserData userData;


	@Before
	public void beforeTest() throws Exception{
		userData = new UserData();
		userData.setId(1L);
		userData.setMail("booty6118@gmail.com");
		userData.setPassword("firstinputuser");

	}
	@After(value = "rewind")
	public void afterTest() throws Exception{
		fail();
	}

	@Test
	public void testTestRepository() throws Exception{

		List<UserData> getList = testRepository.findAll();
		assertThat(getList.get(0).getId()).isEqualTo(userData.getId());
		assertThat(getList.get(0).getMail()).isEqualTo(userData.getMail());
		assertThat(getList.get(0).getPassword()).isEqualTo(userData.getPassword());
	}
}

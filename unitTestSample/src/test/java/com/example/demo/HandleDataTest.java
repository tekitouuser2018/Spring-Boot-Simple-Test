package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.HandleData;
import com.example.demo.UnitTestSampleApplication;
import com.example.demo.UserData;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@SpringBootTest(classes=UnitTestSampleApplication.class)
@ContextConfiguration(classes=UserDataConfiguration.class)
public class HandleDataTest {


	@Autowired
	private HandleData handleData;


	private UserData userData;

	@Before
	public void beforeTest() {
		userData = new UserData();
		userData.setId(1L);
		userData.setMail("booty6118@gmail.com");
		userData.setPassword("firstinputuser");

	}

	@Test
	public void testFindAll() {
		List<UserData> getList = handleData.findAll();
		assertThat(getList.get(0).getId()).isEqualTo(userData.getId());
		assertThat(getList.get(0).getMail()).isEqualTo(userData.getMail());
		assertThat(getList.get(0).getPassword()).isEqualTo(userData.getPassword());
	}
}

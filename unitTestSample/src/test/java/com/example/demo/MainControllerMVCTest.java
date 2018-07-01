package com.example.demo;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
public class MainControllerMVCTest {


	private MockMvc mvc;
	@Autowired
	private WebApplicationContext context;

	private UserData userData;

	@Autowired private HandleData handleData;


	@Before
    public void setUp() {
		userData = new UserData();
		userData.setId(1L);
		userData.setMail("booty6118@gmail.com");
		userData.setPassword("firstinputuser");

		mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


	@Test
	public void testIndex() throws Exception{

				assertThat(handleData.findAll().get(0).getMail()).isEqualTo(userData.getMail());


						mvc.perform(get("/"))
						.andExpect(status().isOk())
						.andExpect(view().name("index"))
			            //.andExpect(content().string(containsString("Hello Mock")));
						//.with(SecurityMockMvcRequestPostProcessors.csrf())
						//.andReturn().getResponse()
						//.andExpect(forwardedUrl("index"))
						.andExpect(MockMvcResultMatchers.model().attribute("now", is("test text")));
						//.andDo(print()));


	}

	@Test
	public void notRequiredPost() throws Exception {
	    mvc.perform(post("/")).andExpect(status().isMethodNotAllowed());
	}
	@Test
	public void notRequiredDelete() throws Exception {
	    mvc.perform(delete("/")).andExpect(status().isMethodNotAllowed());
	}
	@Test
	public void notRequiredPut() throws Exception {
	    mvc.perform(put("/")).andExpect(status().isMethodNotAllowed());
	}

}

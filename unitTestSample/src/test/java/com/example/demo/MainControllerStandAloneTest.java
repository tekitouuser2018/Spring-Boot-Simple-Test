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
//@AutoConfigureMockMvc
//@ComponentScan("com.example.demo")
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
//@ContextConfiguration(classes=UserDataConfiguration.class)
public class MainControllerStandAloneTest {

	//@Autowired
    //private WebApplicationContext wac;
	//@Autowired
	private MockMvc mvc;
	@Autowired
	private WebApplicationContext context;

	private UserData userData;
	//@Autowired TestRepository rep;
	//@MockBean
	@Autowired private HandleData handleData;
	//@InjectMocks
	//private MainController mainController;

	//private static final Logger log = LoggerFactory.getLogger(MainControllerMVCTest.class);

	@Before
	public void before(){
		userData = new UserData();
		userData.setId(1L);
		userData.setMail("booty6118@gmail.com");
		userData.setPassword("firstinputuser");
		//mvc = MockMvcBuilders.standaloneSetup(mainController).build();
		mvc = MockMvcBuilders.webAppContextSetup(context).build();

		//DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        //this.mvc = builder.build();


	}

	@Test
	public void testIndex() throws Exception{
		//mvc = MockMvcBuilders.standaloneSetup(mainController).build();
/*
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
		this.mvc.perform(builder).andExpect(ok);
*/
		assertThat(handleData.findAll().get(0).getMail()).isEqualTo(userData.getMail());
		//mvc.perform(get("/")).andExpect(status().isOk());

		//ResultActions response =
				mvc.perform(get("/")
						//.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						//.param("now", "test test")
		                //.param("data", userData.getMail())
						)
				.andExpect(status().isOk())
				.andExpect(view().name("index"))
	            //.andExpect(content().string(containsString("Hello Mock")));
				//.with(SecurityMockMvcRequestPostProcessors.csrf())
				//.andReturn().getResponse();
				//.andExpect(forwardedUrl("index"))
				.andExpect(MockMvcResultMatchers.model().attribute("now", is("test text")));
				//.andDo(print()));

		//assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		//response.andExpect(MockMvcResultMatchers.status().isOk());

	}

}

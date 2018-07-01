package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,
classes = UnitTestSampleApplication.class)
//@AutoConfigureMockMvc
//@ContextConfiguration
//@WebAppConfiguration
@ActiveProfiles("test")
public class MainControllerITTest {

	@LocalServerPort
	private int port;

	//@Autowired MockMvc mvc;

	@Autowired
	private TestRestTemplate template;

	@Autowired private HandleData handleData;


	@Test
    public void testIndex() throws Exception{

		//assertThat(this.template.getForObject("http://localhost:8080"+"/",String.class)).isNotNull();

		URL base = new URL("http://localhost:8080"+"/");
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody()).isEqualTo("index");

/*
		ResponseEntity<UserData> responseEntity =
	            template.getForEntity("/",UserData.class);
	        UserData data = responseEntity.getBody();
	        //assertEquals("booty6118@gmail.com", data.getMail());
	        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
*/


		//URI uri = new URI("http://localhost:" + port + "/");
		//HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		/*ResponseEntity<String> response = template.exchange(
				uri,
				HttpMethod.GET, entity, String.class);
*/
		//String expected = "{id:Course1,name:Spring,description:10 Steps}";
        //String responseBody = template.getForObject(uri, String.class);
        //assertThat(responseBody).isEqualTo("index");
    }






}

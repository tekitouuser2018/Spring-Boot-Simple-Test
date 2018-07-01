package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import service.Simple;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SimpleTest.class)
public class SimpleTest {

	@InjectMocks
	private Simple simple;
	//@Mock
	//private TestRestTemplate TestRestTemplate;

	@Test
	public void testSimpleEcho() {
		assertThat(simple.echo()).isEqualTo("simple method test");

	}
}

package com;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.repository.VegetablesRepo;
import com.service.VegetablesService;


@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineVegetableSalesApplicationTests {

	@Autowired
	private VegetablesService Service;
	
	@MockBean
	private VegetablesRepo Repository;
	
	public void testUpdateVegetables()
	{
	}
	
	@Test
	void contextLoads() {
	}

}

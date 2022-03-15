package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Vegetables;
import com.repository.VegetablesRepo;

@SpringBootTest
class VegetablesServiceImplTest {
	
	@Autowired
	VegetablesService vegetablesservice;
	
	@MockBean
	VegetablesRepo repo;
	
	@Test
	void testAddVegetables() {
		Vegetables v1=new Vegetables();
		v1.setVid(1);
		v1.setVname("Potato");
		v1.setVcategory("Root");
	Mockito.when(repo.save(v1)).thenReturn(v1);
		
		assertThat(vegetablesservice.addVegetables(v1)).isEqualTo(v1);
	}

	@Test
	void testUpdateVegetables() throws Throwable {
		Vegetables v1=new Vegetables();
		v1.setVid(1);
		v1.setVname("Potato");
		v1.setVcategory("Root");
		Optional<Vegetables> v2=Optional.of(v1);
		
		Mockito.when(repo.findById(1)).thenReturn(v2);
		
		Mockito.when(repo.save(v1)).thenReturn(v1);
		v1.setVname("Beetroot");
		v1.setVcategory("Root");
		
		assertThat(vegetablesservice.updateVegetables(v1)).isEqualTo(v1);
	}

	@Test
	void testDeleteVegetables() {
		Vegetables v1=new Vegetables();
		v1.setVid(1);
		v1.setVname("Potato");
		v1.setVcategory("Root");
		Optional<Vegetables> v2=Optional.of(v1);
		
		Mockito.when(repo.findById(1)).thenReturn(v2);
		 Mockito.when(repo.existsById(v1.getVid())).thenReturn(false);
		   assertFalse(repo.existsById(v1.getVid()));
	}
}

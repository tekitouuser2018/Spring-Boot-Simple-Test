package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleData{

	@Autowired(required=true)
	private TestRepository testRepository;
	//@PersistenceContext
	//private EntityManager entityManager;


	public HandleData() {}

	//@SuppressWarnings("unchecked")
	public List<UserData> findAll() {
		//return (List<UserData>)entityManager.createQuery("from userdata").getResultList();
		return testRepository.findAll();
	}

}

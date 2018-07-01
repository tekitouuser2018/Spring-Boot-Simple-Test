package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@Autowired
	//TestRepository testRepository;
	private HandleData handleData;


	@RequestMapping(value="/",method=RequestMethod.GET)
	String index(Model model) {
		List<UserData> list = (List<UserData>)handleData.findAll();
		model.addAttribute("now","test text");
		model.addAttribute("data",list.get(0).getMail());
		return "index";
	}


}

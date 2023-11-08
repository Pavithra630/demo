package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoModel;
import com.example.demo.repository.DemoRepository;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private DemoRepository demoRepository;
	
	@GetMapping("/getDetails")
	//@Cacheable(cacheNames = { "userCache"})
	public List<DemoModel> getDetails() {
		System.out.println("hitting db from get call"+getString());
		return demoRepository.findAll();
	}
	
	@PostMapping("/saveDetails")
	public DemoModel saveDetails(@RequestBody DemoModel demoModel) {
		System.out.println("hitting db from post call");
		return demoRepository.save(demoModel);
	}
	
	@DeleteMapping("/deleteDetails/{id}")
	public void deleteDetails(@PathVariable int id) {
		Optional<DemoModel> demoModel= demoRepository.findById(id);
		if(demoModel.isPresent())
			demoRepository.delete(demoModel.get());
		
		
	}
	
	public static String getStaticMethod() {
		
		return "Hello";
	}
	
	private String getString() {
		return "hello world";
	}
	
}

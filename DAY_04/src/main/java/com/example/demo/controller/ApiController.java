package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class ApiController {

	@Autowired
	StudentService sser;
	
	@PostMapping("addStudent")
	public StudentEntity add(@RequestBody StudentEntity ss) {
		return sser.saveinfo(ss);
	}
	
	@PostMapping("addDetails")
	public List<StudentEntity> adddetails(@RequestBody List<StudentEntity> ss) {
		return sser.savedetails(ss);
	}
	
	@GetMapping("showDetails")
	public List<StudentEntity> show() {
		return sser.showinfo();
	}
	
	@GetMapping("showData/{id}")
	public Optional<StudentEntity> display(@PathVariable int id) {
		return sser.disp(id);
	}
	
	@PutMapping("updateDetails")
	public StudentEntity modify(@RequestBody StudentEntity ss) {
		return sser.changeinfo(ss);
	}
	
	@DeleteMapping("delid/{id}")
	public String deletemyid(@PathVariable int id) {
		sser.deleteid(id);
		return "Delete successfully";
	}
}

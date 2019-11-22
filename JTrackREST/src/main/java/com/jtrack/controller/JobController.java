package com.jtrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jtrack.model.Job;
import com.jtrack.service.JobService;

@RestController
public class JobController {
	
	@Autowired
	JobService jobService;

	@GetMapping(path="/job")
	public List<Job> getJobList(){
		return jobService.getJobList();
	}
	
	@GetMapping(path="/job/{id}")
	public ResponseEntity<Object> getJob(@PathVariable long id){
		Job job = jobService.getJob(id);
		
		if(job == null) {
			return ResponseEntity.badRequest().body("Job does not exist");
		}
		
		return ResponseEntity.ok(job);
	}

	@PostMapping("/job")
	public ResponseEntity<Object> addJob(@RequestBody Job job) {
		if(jobService.jobExists(job.getJobNo())) {
			return ResponseEntity.badRequest().body("JobType already exists");
		}
		
		return ResponseEntity.ok(jobService.addJob(job));
	}
	
	@PutMapping("/job")
	public ResponseEntity<Object> updateJob(@RequestBody Job job) {
		if(!jobService.jobExists(job.getJobNo())) {
			return ResponseEntity.badRequest().body("Job does not exist");
		}
		
		return ResponseEntity.ok(jobService.updateJob(job));
	}
	
	@DeleteMapping("/job/{id}")
	public ResponseEntity<Object> deleteJob(@PathVariable long id) {
		if(!jobService.jobExists(id)) {
			return ResponseEntity.badRequest().body("Job does not exist");
		}
		
		jobService.deleteJob(id);
		
		return ResponseEntity.ok().build();
	}
}
package com.kishorekumarkorada.IIOTDataVisualizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kishorekumarkorada.IIOTDataVisualizer.model.ApplicationEntity;
import com.kishorekumarkorada.IIOTDataVisualizer.service.ApplicationService;

@RestController
@RequestMapping("tza")
public class TrackzillaController {

	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping("/application")
	public ResponseEntity<Void> addApplication(@RequestBody ApplicationEntity applicationEntity,UriComponentsBuilder builder) {
		boolean flag = applicationService.addApplication(applicationEntity);
		if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/application/{id}").buildAndExpand(applicationEntity).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/application/{id}")
	public ResponseEntity<ApplicationEntity> getApplicationById(@PathVariable("id") int id) {
		ApplicationEntity applicationEntity = applicationService.getApplicationById(id);
		return new ResponseEntity<ApplicationEntity>(applicationEntity,HttpStatus.OK);
	}
	
	@PutMapping("/application")
	public ResponseEntity<ApplicationEntity> updateApplication(@RequestBody ApplicationEntity applicationEntity) {
		applicationService.updateApplication(applicationEntity);
		return new ResponseEntity<ApplicationEntity>(applicationEntity,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/application/{id}")
	public ResponseEntity<Void> deleteApplication(@PathVariable("id") int id) {
		applicationService.deleteApplication(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

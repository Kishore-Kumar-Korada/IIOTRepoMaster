package com.kishorekumarkorada.IIOTDataVisualizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTMachineModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.IIOTMachineService;

@RestController
@RequestMapping("iiot")
public class MachineController {
	
	@Autowired
	private IIOTMachineService iiotMachineService;
	
	@PostMapping("/machine")
	public ResponseEntity<Void> addMachine(@RequestBody IIOTMachineModel iiotMachineModel,UriComponentsBuilder builder) {
		boolean flag = iiotMachineService.addMachine(iiotMachineModel);
		if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/machine/{id}").buildAndExpand(iiotMachineModel).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/machine/{id}")
	public ResponseEntity<IIOTMachineModel> getApplicationById(@PathVariable("id") String machineId) {
		IIOTMachineModel iiotMachineModel = iiotMachineService.getMachineById(machineId);
		return new ResponseEntity<IIOTMachineModel>(iiotMachineModel,HttpStatus.OK);
	}
}

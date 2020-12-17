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

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTShiftModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.IIOTShiftService;

@RestController
@RequestMapping("iiot")
public class ShiftController {
	
	@Autowired
	private IIOTShiftService iiotShiftService;
	
	@PostMapping("/shift")
	public ResponseEntity<Void> addShift(@RequestBody IIOTShiftModel iiotShiftModel,UriComponentsBuilder builder) {
		boolean flag = iiotShiftService.addShift(iiotShiftModel);
		if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/shift/shiftId/machineId").buildAndExpand(iiotShiftModel).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/shift/{shiftId}/{machineId}")
	public ResponseEntity<IIOTShiftModel> getShiftByIds(@PathVariable("shiftId") String shiftId, @PathVariable("machineId") String machineId) {
		IIOTShiftModel iiotShiftModel = iiotShiftService.getShiftByIds(shiftId, machineId);
		return new ResponseEntity<IIOTShiftModel>(iiotShiftModel,HttpStatus.OK);
	}
}


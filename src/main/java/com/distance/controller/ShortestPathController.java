package com.distance.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.distance.ShortestPath;
import com.distance.modal.Path;

@RestController
@RequestMapping("/v1")
public class ShortestPathController {
	
	ShortestPath shortDistance =new ShortestPath();
	@RequestMapping(value="/distance" ,method=RequestMethod.POST,produces = { "application/json" })
	public Path  input(@RequestBody Path distance) throws IOException {
		distance.setOutput(shortDistance.calculate(distance.getNodes(),distance.getFilepath()));
		return distance;
		
	}

}

package com.distance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.distance.modal.Path;
import com.distance.repository.RequestRepo;
import com.distance.service.ShortestPath;
import com.mongodb.MongoException;


@RestController
@RequestMapping("/v1")
public class ShortestPathController {
	
	@Autowired
	private RequestRepo requestRepo;
	
	ShortestPath shortDistance =new ShortestPath();
	@RequestMapping(value="/distance" ,method=RequestMethod.POST,produces = { "application/json" })
	public Path  input(@RequestBody Path distance) throws Exception {
		distance.setOutput(shortDistance.calculate(distance.getNodes(),distance.getFilepath()));
		saveRequestDetails(distance);
		return distance;
		
	}
	
	
	public void saveRequestDetails(Path request) throws Exception{
		try{
		Path returnVal=requestRepo.save(request);
		}catch(MongoException e){
			throw new Exception("Unable to save request details");
		}
		
	}
	
	@GetMapping(value = "/findAll")
	public List<Path> getRequestDetails() throws Exception {
		try{
			List<Path> result =requestRepo.findAll();
			return result;
			}
			catch(MongoException e){
				throw new Exception("Unable to get request details");
			}
	}
}

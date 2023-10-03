package com.dipasmitachak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dipasmitachak.entity.Tea;

@RestController
@CrossOrigin
public class TeaController {
	
	private List<Tea> teas=new ArrayList<>();

	public TeaController() {
		teas.addAll(List.of(new Tea("Lipton"),new Tea("Yorkshire Tea"),new Tea("Tetley"),new Tea("Harney & Sons"),new Tea("Wah Taj!"),new Tea("Dilmah"),new Tea("Twinings")));
	}
		@GetMapping("/tea")
		//@RequestMapping(value="/tea",method=RequestMethod.GET)
		Iterable<Tea> getTeas()
		{
			return teas;
		}
		
		//Avoid NullPointer Exception(NPE)
		@GetMapping("/tea/{id}")
		Optional<Tea> getTeaById(@PathVariable String id)
		{
			for(Tea t:teas)
			{
				if(t.getId().equals(id))
				{
					return Optional.of(t);
				}
			}
			return Optional.empty();
		}
		//POST-ING: adding new tea
		@PostMapping("/tea")
		Tea postTea(@RequestBody Tea tea)
		{
			teas.add(tea);
			return tea;
			
		}
		//Update --> By Put Method
		@PutMapping("/tea/{id}")
		String putTea(@PathVariable String id)
		{
			for(Tea t : teas) {
				if(t.getId().equals(id)) {
					t.setName("Amul Tea");
					teas.set(0,t);
				}
			}
			return "updated!";
		}
		@DeleteMapping("/tea/{id}")
		String deleteTea(@PathVariable String id) {
			teas.removeIf(x->x.getId().equals(id));
			return "The tea with id "+id+" has been removed successfully!";
		}
	}
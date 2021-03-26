package com.carbonfive.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Here we are ";
	}

	@PostMapping(
			path = "/set",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<String> set(@RequestParam MultiValueMap<String,String> paramMap) throws Exception {
		String data = paramMap.get("text").get(0);
		List<String> total = Glossary.parseData(data);
		if(total.size() == 0){
			return new ResponseEntity<String>("Bad Input Value, please redo", HttpStatus.OK);
		}
		String acronym = total.get(0);
		String definition= total.get(1);
		Glossary.setGlossary(acronym, definition);
		return new ResponseEntity<String>("Definition has been added", HttpStatus.OK);
	}

	@PostMapping(
			path = "/get",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<String> get(@RequestParam MultiValueMap<String,String> paramMap) throws Exception {
		String data = paramMap.get("text").get(0);
		String res = Glossary.getGlossary(data);
		if(res == ""){
			return new ResponseEntity<String>("This acronym doesn't have a definition", HttpStatus.OK);
		}
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}

	// lol: fdjafjdfjjfdjfdkafdafjdka
	// if more than one : --> invalid input

}
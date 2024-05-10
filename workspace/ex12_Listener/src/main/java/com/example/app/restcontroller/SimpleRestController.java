package com.example.app.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.dto.memoDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest")
public class SimpleRestController {

	
	@GetMapping(value="/getText",produces=MediaType.TEXT_PLAIN_VALUE)
	public String rest01() {
		log.info("GET/rest/GetTExt...");
		return "Hello Wolrd";
	}
	
	//raw Data type:xml,json memoDto-javavava>xml/json
	@GetMapping(value="/getJson",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public memoDto rest02() {
		log.info("GET/rest/GetJson...");
		return new memoDto(1,"HAHA");
	}
	
	@GetMapping(value="/getXml",produces=MediaType.APPLICATION_XML_VALUE)
	public memoDto rest03() {
		log.info("GET/rest/GetXml...");
		return new memoDto(1,"HAHA");
	}
	
	@GetMapping(value="/getXmlList",produces=MediaType.APPLICATION_XML_VALUE)
	public List<memoDto> rest04() {
		log.info("GET/rest/GetXmlList...");
		List<memoDto> list=new ArrayList();
		for(int i=0;i<40;i++) {
			list.add(new memoDto(i,"memo"+i));
		}
		return list;
	}
	
	@GetMapping(value="/getXmlList2/{show}",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<memoDto>> rest05(@PathVariable Boolean show) {
		log.info("GET/rest/GetXmlList2...");
		if(show!=null&&show==true) {
			List<memoDto> list=new ArrayList();
			for(int i=0;i<40;i++) {
				list.add(new memoDto(i,"memo"+i));
			}
			
			return new ResponseEntity(list,HttpStatus.OK);
		}
		return  new ResponseEntity(null,HttpStatus.BAD_REQUEST);
	}
}

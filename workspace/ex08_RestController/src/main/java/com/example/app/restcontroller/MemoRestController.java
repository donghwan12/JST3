package com.example.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.dto.memoDto;
import com.example.app.domain.service.MemoServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/memo")
public class MemoRestController {

	@Autowired
	private MemoServiceImpl memoServiceImpl;
	
	@GetMapping(value="/add_get")
	public Boolean add_get(memoDto memoDto) {
		log.info("GET /memo/.." + memoDto);	
		boolean isadded=false;
		try {
			isadded = memoServiceImpl.memoRegistration(memoDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("isAdded..."+isadded);
		return isadded;
	}
	
	@PostMapping(value="/add_post")
	
	public ResponseEntity<String> add_post(@RequestBody memoDto memoDto) throws Exception {
		log.info("post/memo/.." + memoDto);	
		boolean isadded=false;
		try {
			isadded = memoServiceImpl.memoRegistration(memoDto);
			if(isadded) {
				System.out.println("정상작동");
				return new ResponseEntity("Post ADD 성공".getBytes("UTF-8"),HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("isAdded..."+isadded);
		
		//문제발생
		System.out.println("오류");
		return new ResponseEntity("post add 실패".getBytes("UTF-8"),HttpStatus.BAD_GATEWAY);
	}
	
	@PutMapping(value="/put")
	public ResponseEntity put(@RequestBody memoDto memodto) {
	 
		log.info("Put/memo/put..."+memodto);
		boolean isUpdate=false;
		
		try {
			isUpdate=memoServiceImpl.modifiedMemo(memodto);
			if(isUpdate) {
				return new ResponseEntity("PutSuccess",HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity("Fail",HttpStatus.BAD_GATEWAY);
	}
	
	
	
	@PatchMapping(value="/patch")
	public ResponseEntity patch(@RequestBody memoDto memodto) {
	 
		log.info("Put/memo/patch..."+memodto);
		boolean isUpdate=false;
		
		try {
			isUpdate=memoServiceImpl.modifiedMemo(memodto);
			if(isUpdate) {
				return new ResponseEntity("PatchSuccess",HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity("PatchFail",HttpStatus.BAD_GATEWAY);
	}
	
	
}
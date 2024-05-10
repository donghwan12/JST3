package com.example.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	
	//Board post page Mapping
	@GetMapping("/post")
	public void board_post() {
		log.info("/board/post..");
	}
	
	@PostMapping("/post")
	public void board_post_2(BoardDto dto) {
		log.info("POST/Board/post..."+dto);
	}
	
	@GetMapping("/imagePost")
	public void image_post() {
		log.info("GET/board/imagepost..");
	}
	
	@PostMapping("/imagePost")
	public void image_post2(@RequestParam("files") MultipartFile[] files) throws Exception, IOException {
		log.info("Post/board/imagepost.."+files);
		//저장경로 전역변수화
		String UPLOAD_PATH="c:\\upload";

		//개별폴더 생성(UUID)
		//랜덤한 문자열이 생성된다.
		String subDir=UPLOAD_PATH+File.separator+UUID.randomUUID();
		File dir=new File(subDir);
		
		
		if(!dir.exists())
			dir.mkdirs();//폴더생성
		for(MultipartFile file:files) {
			log.info("=======");
			log.info("fileName: "+file.getOriginalFilename());
			log.info("fileSize: "+file.getSize());
			
			
			//파일명 추출
			String fileName=file.getOriginalFilename();
			//파일객체 생성
			File fileObject=new File(subDir,fileName);
			//업로드
			file.transferTo(fileObject);	
		}
}
}

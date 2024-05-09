package com.example.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/upload")
public class UploadController {

	//저장경로 전역변수화
	String UPLOAD_PATH="c:\\upload";
	
	@GetMapping("/file")
	public void up_file() {
		log.info("GET/upload/file...");
		
		
		//Upload 방법
		//InMemory x
		//DB
		//FileSystem C:\\path\\files... ->운영체제를 가린다.
	}
	
	@PostMapping("file")
	public void up_file_post(@RequestParam("Singlefile") MultipartFile file) throws Exception {
		log.info("Post/upload/file.."+file);
		
		
		//개별폴더 생성(UUID)
		//랜덤한 문자열이 생성된다.
		String subDir=UPLOAD_PATH+File.separator+UUID.randomUUID();
		File dir=new File(subDir);
		if(!dir.exists())
			dir.mkdirs();//폴더생성
			
		
		
		
		log.info("FileName: "+file.getOriginalFilename());
		log.info("FileSize: "+file.getSize()+"Byte");
		
		//파일명 추출
		String fileName=file.getOriginalFilename();
		//파일객체 생성
		File fileObject=new File(subDir,fileName);
		//업로드
		file.transferTo(fileObject);			
	}
	
	@GetMapping("/files")
	public void up_files_2() {
		log.info("GET/Upload/files...");
	}
	
	@PostMapping("files")
	//배열형태로 파일을받는다
	public void up_files2_Post(@RequestParam("files") MultipartFile[] files) throws Exception, IOException {
		log.info("POST/upload/files..."+files);
		
		//개별폴더 생성(UUID)
				//랜덤한 문자열이 생성된다.
				String subDir=UPLOAD_PATH+File.separator+UUID.randomUUID();
				File dir=new File(subDir);
				if(!dir.exists())
					dir.mkdirs();//폴더생성
		
		for(MultipartFile file:files) {
			log.info("============");
			log.info("FileName: "+file.getOriginalFilename());
			log.info("FileSize: "+file.getSize()+"Byte");
			
			//파일명 추출
			String fileName=file.getOriginalFilename();
			//파일객체 생성
			File fileObject=new File(subDir,fileName);
			//업로드
			file.transferTo(fileObject);	
		}
	}
	@GetMapping("/list")
	public void list(Model model) {
		log.info("GET/upload/list...");
		
		//파일 기본 경로(전역화한 경로)
		File base_dir=new File(UPLOAD_PATH);
		
		File[] sub_dir=base_dir.listFiles();
		for(File dir:sub_dir) {
			log.info("Sub_dir : " +dir);
			
			File tmp=new File(dir.getPath());
			for(File file:tmp.listFiles()) {
				log.info("File: "+file);
			}
		}
		
		model.addAttribute("root",base_dir);
	}
	
}

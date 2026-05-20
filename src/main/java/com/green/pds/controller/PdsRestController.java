package com.green.pds.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.pds.dto.FilesDto;
import com.green.pds.mapper.PdsMapper;

@RestController  // @Controller + @ResponseBody
public class PdsRestController {

	@Value("${part1.upload-path}")
	private    String      uploadPath;
	
	@Autowired
	private    PdsMapper   pdsMapper;
	
	// /deleteFile/11
	@RequestMapping("/deleteFile/{file_num}")
	public  void  deleteFile(
		@PathVariable(value="file_num")  long file_num
			) {
		
		// 폴더에서 삭제할 파일을 검색
		FilesDto  fileInfo  =  pdsMapper.getFileInfo( file_num );
		
		// 실제 파일을 삭제 
		File      file      =  new File( uploadPath + fileInfo.getSfilename() );    
		if( file.exists()  )
			file.delete();
		
		// files table 의 정보를 삭제
		
		
	}
	
}









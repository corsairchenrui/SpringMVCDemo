package com.springapp.mvc;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HelloController {

	public final static String FILEDIR = "/Users/cherry/Downloads/";
	public final static String FILENAME = "fileTest.txt";
	public final static String OUTPUTFILENAME = "fileTest1.txt";

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}



	@RequestMapping("download")
	public ResponseEntity<byte[]> download() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "dict.txt");
		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(new File(FILEDIR+FILENAME)),
				headers, HttpStatus.CREATED);

	}

	@RequestMapping(value = "download1",produces = "application/json")
	@ResponseBody
	public ResponseEntity<byte[]> downloadFail() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "dict.txt");
		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(new File(FILEDIR+FILENAME)),
				headers, HttpStatus.CREATED);

	}
}
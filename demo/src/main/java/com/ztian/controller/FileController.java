/**
 *
 */
package com.ztian.controller;

import com.ztian.entity.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zhailiang
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	private String folder = "F:";

	@PostMapping
	public FileInfo upload(MultipartFile file) throws Exception {

		log.info("{}", file.getName());
		log.info("{}", file.getOriginalFilename());
		log.info("{}", file.getSize());

		File localFile = new File(folder, "1.txt");

		file.transferTo(localFile);

		return new FileInfo(localFile.getAbsolutePath());
	}

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
		     OutputStream outputStream = response.getOutputStream();) {
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		}

	}

}

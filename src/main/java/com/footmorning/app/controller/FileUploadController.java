package com.footmorning.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class FileUploadController {

	@RequestMapping(value = "/video/fileUpload")
	public String fileUpload(HttpServletRequest request) {
		 MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		 MultipartFile uploadfile = multipartHttpServletRequest.getFile("uploadfile");

		if (uploadfile != null) {
			if(
			uploadfile.isEmpty())
			{
				System.out.println("실제 파일이 존재하지 않음");
			}
			String fileName = uploadfile.getOriginalFilename();
			try {
				// 1. FileOutputStream 사용
				// byte[] fileData = file.getBytes();
				// FileOutputStream output = new FileOutputStream("C:/images/" +
				// fileName);
				// output.write(fileData);

				// 2. File 사용
				//System.out.println("test : " + fileName);
				String dftFilePath = request.getSession().getServletContext().getRealPath("/");
				// 파일 기본경로 _ 상세경로
				String filePath = dftFilePath + "/resources/upload/video";
				//System.out.println("파일경로 : " + filePath);
				File dir = new File(filePath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String realFileNm = "";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
				String today = formatter.format(new java.util.Date());
				realFileNm = today + fileName;
				//System.out.println("파일 이름 : "+realFileNm);
				File file = new File(filePath + "/" + realFileNm);
				uploadfile.transferTo(file);
				request.setAttribute("result", true);
				request.setAttribute("fileName", "/resources/upload/video/" + realFileNm);
			} catch (IOException e) {
				request.setAttribute("result", false);
				e.printStackTrace();
			} // try - catch
		} // if
			// 데이터 베이스 처리를 현재 위치에서 처리
		return "/fileupload/json/fileUploadResult"; // 리스트 요청으로 보내야하는데 일단 제외하고
													// 구현
	}
}

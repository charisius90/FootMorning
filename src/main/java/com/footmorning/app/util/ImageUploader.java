package com.footmorning.app.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class ImageUploader {
	// 업로드 이미지 최대 크기 5MB
	private static final int MAX = 5 * 1024 * 1024;
	
//	private HttpRequest req;
	
	public void setImage(){}
	
	public void newName(){}
	
	public void resize(){}
	
//	public void code(HttpServletRequest req){
//		// 5Mbyte 제한
//		int maxSize  = 5 * 1024*1024;        
//		
//		// 웹서버 컨테이너 경로
//		String root = req.getSession().getServletContext().getRealPath("/");
//		
//		// 파일 저장 경로(ex : /home/tour/web/ROOT/upload)
//		String savePath = root + "upload";
//		
//		// 업로드 파일명
//		String uploadFile = "";
//		
//		// 실제 저장할 파일명
//		String newFileName = "";
//		
//		int read = 0;
//		byte[] buf = new byte[1024];
//		FileInputStream fin = null;
//		FileOutputStream fout = null;
//		long currentTime = System.currentTimeMillis();  
//		SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");  
//		
//		try{
//			MultipartRequest multi = new MultipartRequest(req, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
//			
//			// 파일업로드
//			uploadFile = multi.getFilesystemName("file");
//			// 실제 저장할 파일명(ex : 20140819151221.jpg)
//			newFileName = simDf.format(new Date(currentTime)) + "." + uploadFile.substring(uploadFile.lastIndexOf(".")+1);
//			
//			
//			// 업로드된 파일 객체 생성
//			File oldFile = new File(savePath + "/" + uploadFile);
//			// 실제 저장될 파일 객체 생성
//			File newFile = new File(savePath + "/" + newFileName);
//			// 파일명 rename
//			if(!oldFile.renameTo(newFile)){
//				// rename이 되지 않을경우 강제로 파일을 복사하고 기존파일은 삭제
//				buf = new byte[1024];
//				fin = new FileInputStream(oldFile);
//				fout = new FileOutputStream(newFile);
//				read = 0;
//				while((read=fin.read(buf,0,buf.length))!=-1){
//					fout.write(buf, 0, read);
//				}
//				
//				fin.close();
//				fout.close();
//				oldFile.delete();
//			}   
//			
//			// ### 이미지 리사이징
//			// 저장 될 파일 사이즈(px)
//			int width = 164;
//			int height = 164;
//			String cmd = req.getParameter("cmd");
//			if(cmd.equals("back")){
//				width = 950;
//				height = 950;
//			}
//			
//			Image origImg = new ImageIcon(newFile.toURI().toURL()).getImage();
//			
//			// 이미지 비율 조정(큰 쪽이 최대 164px)
//			double origHeight = origImg.getHeight(null);
//			double origWidth = origImg.getWidth(null);
//			double ratio = origHeight/origWidth;
//			if(ratio > 1){
//				height = (int)(width * ratio);
//			}
//			else{
//				width = (int)(height / ratio);
//			}
//			System.out.println("check height : " + height);
//			System.out.println("check width : " + width);
//			Image newImg = origImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//			
//			// 픽셀 지정
//			int pixels[] = new int[width * height]; 
//            PixelGrabber pg = new PixelGrabber(newImg, 0, 0, width, height, pixels, 0, width); 
//            try {
//                pg.grabPixels();
//            }
//            catch (InterruptedException e) {
//                throw new IOException(e.getMessage());
//            } 
//            BufferedImage destImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
//            destImg.setRGB(0, 0, width, height, pixels, 0, width); 
//            ImageIO.write(destImg, "jpg", newFile);
//            
//			String origFileName = multi.getOriginalFileName("file");
//			String sysFileName = newFile.getName();
//			String filePath = newFile.getPath();
//			
//			// DB에 새 파일명 저장
//			HttpSession session = req.getSession();
//			MemberDto dto = (MemberDto)session.getAttribute("member");
//			MemberDao dao = new MemberDao();
//			if(cmd.equals("back")){
//				dto.setMem_background(sysFileName);
//			}
//			else{
//				dto.setMem_image(sysFileName);
//			}
//			if(dao.updateMember(dto)){
//				//업데이트 성공 시 결과 클라이언트로 전송
//				session.setAttribute("member", dto);
//				PrintWriter out = resp.getWriter();
//				out.print(true);
//			}
//			
//			System.out.println("--------------------------------------- -------------------------------------------");
//			System.out.println("!! check resized :");
//			System.out.println("원본파일이름 :" + origFileName);
//			System.out.println("저장파일이름 :" + sysFileName);
//			System.out.println("저장파일경로 :" + filePath);
//			
//		}catch(Exception err){
//			System.out.println("ImageUploadServlet : " + err);
//			err.printStackTrace();
//		}
//
//	}
	
}

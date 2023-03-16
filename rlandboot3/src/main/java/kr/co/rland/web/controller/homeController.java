package kr.co.rland.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// FrontController(POJO 클래스)를 만드는 방법! 
// 클래스는 보통 폴더명이 된다.(기능별로 넣자!) 
@Controller
@RequestMapping("/")
public class homeController {
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile[] imgs, HttpServletRequest request) throws IOException {
		
		for(int i = 0 ; i < imgs.length ; i++){
		
		MultipartFile img = imgs[i];
		
		if(img.isEmpty())
			continue;
		
		System.out.println(img.getOriginalFilename());
		
		
		String urlpath = "/image/menu/" + img.getOriginalFilename();
		String realPath = request.getServletContext().getRealPath(urlpath); 
		System.out.println(realPath);
		String realPath2 = this.getClass().getResource("").getPath(); //홈디렉 관련이 아니라 클래스파일의 파일 위치 알려 줌 
		System.out.println(realPath2);
		String realPath3 = this.getClass().getResource("/").getPath(); //홈디렉 관련이 아니라 클래스파일의 파일 위치 알려
		System.out.println(realPath3);
		
//		this.getClass().getResource("");
//		물리 경로 알아내는것!
				
		
		
		InputStream fis = img.getInputStream();
		OutputStream fos = new FileOutputStream(realPath);
		
		byte[] buf = new byte[1024];
		int size = 0;
		
		while((size = fis.read(buf)) != -1 ){
			fos.write(buf, 0 , size);
		}
		
//		img.transferTo(new File(realPath));
		
		
		
		fis.close();
		fos.close();
		
		}
		
		return "ok";
		
	}
    
    // 함수 이름은 보통 url이 된다.
    @RequestMapping("index")
    public String index(Model model, HttpServletResponse response) 
    		throws UnsupportedEncodingException {
        
        //String data = "Hello Data";
    	
        String data = URLEncoder.encode("cookie 지롱~", "utf-8");
        System.out.println(data);
        String data2 = URLDecoder.decode(data, "utf-8");
        System.out.println(data2);
        
        Cookie cookie = new Cookie("my", data);
        response.addCookie(cookie);
        
        //model에는 addAttribute이다.
        model.addAttribute("data", data);
        
        return "index";
    }
    

}
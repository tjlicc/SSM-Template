package com.example.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;
import com.example.service.inter.UserService;
import com.example.utils.ValidateCode;

@Controller
public class FrameController {
	
	private final Logger LOGGER = Logger.getLogger(FrameController.class);

	@Autowired
	private UserService userService;
	
	@Scheduled(cron = "0/5 * *  * * ? ")
	public void printMsg() {
		System.out.println("scheduled annotation test");
	}

	@RequestMapping(value = "/index")
	public String doIndex() {
		User user = userService.selectByPrimaryKey("1");
		LOGGER.info(">>user info");
		LOGGER.info(">>name: " + user.getName());
		LOGGER.info(">>address: " + user.getAddress());
		return "index";
	}

	@RequestMapping(value = "/getCode")
	public void getCode(HttpServletRequest req, HttpServletResponse res) {
		ValidateCode validateCode = ValidateCode.generateValidateCode();
		String codeStr = validateCode.getCodeStr();
		BufferedImage codeImg = validateCode.getCodeImg();
		
		// 将四位数字的验证码保存到Session中。
		HttpSession session = req.getSession();
		session.setAttribute("code", codeStr);

		// 禁止图像缓存。
		res.setHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);

		res.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos;
		try {
			sos = res.getOutputStream();
			ImageIO.write(codeImg, "jpeg", sos);
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

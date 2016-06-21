package com.example.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ValidateCode {
	private static int width = 90;
	private static int height = 20;
	private static int codeCount = 4;
	private static int xx = 15;
	private static int fontHeight = 18;
	private static int codeY = 16;
	private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private String codeStr;
	private BufferedImage codeImg;

	private ValidateCode(String codeStr, BufferedImage codeImg) {
		this.codeStr = codeStr;
		this.codeImg = codeImg;
	}

	public static ValidateCode generateValidateCode() {
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();

		// 填充背景颜色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);

		// 设置字体
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		gd.setFont(font);

		// 画边框
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);

		// 产生随机验证码
		Random random = new Random();
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		for (int i = 0; i < codeCount; i++) {
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			randomCode.append(code);

			// 每个验证码使用随机产生的颜色
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, (i + 1) * xx, codeY);
		}

		// 随机画40条干扰线
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 40; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		return new ValidateCode(randomCode.toString(), buffImg);
	}

	public String getCodeStr() {
		return codeStr;
	}

	public BufferedImage getCodeImg() {
		return codeImg;
	}

	public static void main(String[] args) throws IOException {
		ValidateCode validateCode = ValidateCode.generateValidateCode();
		String codeStr = validateCode.getCodeStr();
		BufferedImage codeImg = validateCode.getCodeImg();

		System.out.println(codeStr);
		ImageIO.write(codeImg, "jpeg", new File("C:\\Users\\licc\\Desktop\\test.jpeg"));
	}
}

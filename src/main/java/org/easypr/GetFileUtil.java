package org.easypr;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class GetFileUtil {
	/**
	 * 封装操作文件方法， 添加用户 
	 * @param file
	 * @param filePath
	 * @return
	 */
	public static String fileOperate(MultipartFile file,String filePath) {
		String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
		System.out.println("图片原始名称："+originalFileName);
		String newFileName = "mly"+originalFileName;  //新的文件名称
		System.out.println("新的文件名称："+newFileName);
		File targetFile = new File(filePath,newFileName); //创建新文件
		try {
			file.transferTo(targetFile); //把本地文件上传到文件位置 , transferTo() 用于图片上传时，把内存中图片写入磁盘
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
		return newFileName;
	}
}
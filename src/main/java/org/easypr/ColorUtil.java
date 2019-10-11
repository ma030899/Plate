package org.easypr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

	
	public static Integer blueCount=0;
	public static Integer greenCount=0;
	public static Integer yellowCount=0;
	public static Integer unknowCount=0;
	/**
	 * Java正则表达式Pattern和Matcher类
	 * @param blueColor 蓝色车牌
	 * @param allColor  识别中所有车牌颜色
	 * @return 蓝色车牌数量
	 */
	public static int BlueCount(String blueColor, String allColor) {
		Pattern pattern = Pattern.compile(allColor);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(blueColor);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			blueCount++;
		}
		
		//System.out.println("蓝色车牌数量"+blueCount);
		return blueCount;
		
	}
	public static int GreenCount(String greenColor, String allColor) {
		Pattern pattern = Pattern.compile(allColor);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(greenColor);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			greenCount++;
		}
		
		//System.out.println("绿色"+greenCount);
		return greenCount;
		
	}
	public static int YellowCount(String yellowColor, String allColor) {
		Pattern pattern = Pattern.compile(allColor);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(yellowColor);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			yellowCount++;
		}
		
		//System.out.println("黄色"+yellowCount);
		return yellowCount;
		
	}
	public static int UnknowCount(String yellowColor, String allColor) {
		Pattern pattern = Pattern.compile(allColor);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(yellowColor);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			unknowCount++;
		}
		
		///System.out.println(unknowCount);
		return unknowCount;
		
	}
	public static void JudgeColor() {
		
	}
}

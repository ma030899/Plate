package org.easypr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProviceUtil {
	public static Integer JSCount=0;//江苏
	public static Integer BJCount=0;//北京
	public static Integer SHCount=0;//上海
	public static Integer GDCount=0;//广东
	public static Integer OtherCount=0;//其他
	public static int JSCount(String JS, String AllProvice) {
		Pattern pattern = Pattern.compile(AllProvice);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(JS);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			JSCount++;
		}
		
		System.out.println("蓝色车牌数量"+JSCount);
		return JSCount;
		
	}
	public static int BJCount(String BJ, String AllProvice) {
		Pattern pattern = Pattern.compile(AllProvice);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(BJ);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			BJCount++;
		}
		
		System.out.println("蓝色车牌数量"+BJCount);
		return BJCount;
		
	}
	public static int SHCount(String SH, String AllProvice) {
		Pattern pattern = Pattern.compile(AllProvice);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(SH);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			SHCount++;
		}
		
		System.out.println("蓝色车牌数量"+SHCount);
		return SHCount;
		
	}
	public static int GDCount(String GD, String AllProvice) {
		Pattern pattern = Pattern.compile(AllProvice);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(GD);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			GDCount++;
		}
		
		System.out.println("蓝色车牌数量"+GDCount);
		return GDCount;
		
	}
	public static int OtherCount(String Other, String AllProvice) {
		Pattern pattern = Pattern.compile(AllProvice);// 通过静态方法compile(String regex)方法来创建,将给定的正则表达式编译并赋予给Pattern类
		Matcher matcher = pattern.matcher(Other);//
		while (matcher.find()) {// boolean find() 对字符串进行匹配,匹配到的字符串可以在任何位置
			OtherCount++;
		}
		
		System.out.println("蓝色车牌数量"+OtherCount);
		return OtherCount;
		
	}
}

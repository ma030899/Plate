package org.easypr;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;

//百度ai识别工具类- 
public class PlateUtil {
	// 设置APPID/AK/SK
	public static final String APP_ID = "15903303";
	public static final String API_KEY = "ndGqzlHymbHbVlGYtUwlmyZl";
	public static final String SECRET_KEY = "1ZsM0dVa24hQuKXAqNBDws39Zhxs9yxQ";
	public static long carTime;
	public static String GetResult(String path) throws IOException {
		// 初始化一个AipOcr
		
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		//client.setConnectionTimeoutInMillis(2000);// 建立连接的超时时间
		//client.setSocketTimeoutInMillis(60000);// 通过打开的连接传输数据的超时时间
		System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");// 日志打印
		// 参数为二进制数组
		long startTime=System.currentTimeMillis();   //获取开始时间
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("multi_detect", "true");// 是否检测多张车牌，默认为false，当置为true的时候可以对一张图片内的多张车牌进行识别
		
		JSONObject res = client.plateLicense(path, options);
		byte[] file = Util.readFileByBytes(path);
		res = client.plateLicense(file, options);
		System.out.println(res.toString(2));
		long endTime=System.currentTimeMillis(); //获取结束时间
		 carTime=endTime-startTime;
		System.out.println("识别耗时： "+(carTime)+"ms");
		System.out.println(FastJsonUtil.GetCarResult(res.toString(2)));// 调用解析工具类对得到的jiso数据进行解析
		return path;

	}

}

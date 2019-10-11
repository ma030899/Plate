package org.easypr;

import java.util.Iterator;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class FastJsonUtil {
	/**
	 * 解析所获车牌结果
	 * 
	 * @param jsonresult
	 * @return
	 */
	public static String allCarNum = "";// 所有车牌号码
	public static String allCarCor = "";// 所有车牌所对应颜色
	public static String briefprovice="";
	
	public static String GetCarResult(String jsonresult) {
		com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(jsonresult);// json对象
		String words_result = jsonObject.getString("words_result");// 获取存储车牌号和颜色的数组
		JSONArray resultArray = JSON.parseArray(words_result);// 转换为json数组对象
		String ArrayStr = JSONArray.toJSONString(resultArray);
		System.out.println("resultArray====" + ArrayStr);
		System.out.println("——————————————— ———————————————————");
		int count = 0;// 识别个数
		try {
			Iterator<Object> it = resultArray.iterator();// 使用Iterator迭代器
			while (it.hasNext() && true) {
				// 遍历数组

				JSONObject arrayObj = (JSONObject) it.next();// JSONArray中是很多个JSONObject对象(多个车牌组合)
				String car_num = arrayObj.getString("number");// 获取数组中车牌号码
				String car_cor = arrayObj.getString("color");
				System.out.println("car_num==========" + car_num);
				System.out.println("car_cor==========" + car_cor);
				System.out.println(car_num.subSequence(0, 1));
				allCarNum += car_num + "-";
				allCarCor += car_cor + "-";
				if(allCarCor.contains("blue")||allCarCor.contains("green")||allCarCor.contains("yellow")||allCarCor.contains("unknown")) {
					allCarCor=allCarCor.replace("blue", "蓝色");
					allCarCor=allCarCor.replace("green", "绿色");
					allCarCor=allCarCor.replace("yellow", "黄色");
					allCarCor=allCarCor.replace("unknown", "未识别");
				}
				
				//carslocation=BriefCityUtil.TotalPlate(allCarNum);//获取车牌所在地
				briefprovice+=(String) car_num.subSequence(0, 1);
				count++;

				System.out.println("------------------------------------");

			}
			System.out.println("识别车牌数为：" + count);
		} catch (Exception e) {
			System.out.println("图片过大");
		}
		

		return jsonresult;

	}

}

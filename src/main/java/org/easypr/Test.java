package org.easypr;

import java.util.Iterator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {
	@org.junit.Test
	   public void testFastJson() {
	       // json格式的字符串
	       String jsonStr = "{\r\n" + 
	       		"  \"log_id\": 3645497268940720602,\r\n" + 
	       		"  \"words_result\": [\r\n" + 
	       		"    {\r\n" + 
	       		"      \"number\": \"赣A82F36\",\r\n" + 
	       		"      \"vertexes_location\": [\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 605,\r\n" + 
	       		"          \"y\": 717\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 768,\r\n" + 
	       		"          \"y\": 711\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 770,\r\n" + 
	       		"          \"y\": 760\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 607,\r\n" + 
	       		"          \"y\": 766\r\n" + 
	       		"        }\r\n" + 
	       		"      ],\r\n" + 
	       		"      \"color\": \"blue\",\r\n" + 
	       		"      \"probability\": [\r\n" + 
	       		"        0.9999921321868896,\r\n" + 
	       		"        0.9999786615371704,\r\n" + 
	       		"        0.9998693466186523,\r\n" + 
	       		"        0.9998533725738525,\r\n" + 
	       		"        0.9998482465744019,\r\n" + 
	       		"        0.9998363256454468,\r\n" + 
	       		"        0.999405562877655\r\n" + 
	       		"      ]\r\n" + 
	       		"    },\r\n" + 
	       		"    {\r\n" + 
	       		"      \"number\": \"湘AB148G\",\r\n" + 
	       		"      \"vertexes_location\": [\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 211,\r\n" + 
	       		"          \"y\": 618\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 327,\r\n" + 
	       		"          \"y\": 611\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 329,\r\n" + 
	       		"          \"y\": 647\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 213,\r\n" + 
	       		"          \"y\": 654\r\n" + 
	       		"        }\r\n" + 
	       		"      ],\r\n" + 
	       		"      \"color\": \"blue\",\r\n" + 
	       		"      \"probability\": [\r\n" + 
	       		"        0.9998096823692322,\r\n" + 
	       		"        0.999453067779541,\r\n" + 
	       		"        0.9994115829467773,\r\n" + 
	       		"        0.9992660284042358,\r\n" + 
	       		"        0.999235987663269,\r\n" + 
	       		"        0.9990423321723938,\r\n" + 
	       		"        0.9990394711494446\r\n" + 
	       		"      ]\r\n" + 
	       		"    },\r\n" + 
	       		"    {\r\n" + 
	       		"      \"number\": \"湘AED855\",\r\n" + 
	       		"      \"vertexes_location\": [\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 1251,\r\n" + 
	       		"          \"y\": 527\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 1352,\r\n" + 
	       		"          \"y\": 523\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 1353,\r\n" + 
	       		"          \"y\": 553\r\n" + 
	       		"        },\r\n" + 
	       		"        {\r\n" + 
	       		"          \"x\": 1252,\r\n" + 
	       		"          \"y\": 557\r\n" + 
	       		"        }\r\n" + 
	       		"      ],\r\n" + 
	       		"      \"color\": \"unknown\",\r\n" + 
	       		"      \"probability\": [\r\n" + 
	       		"        0.999998927116394,\r\n" + 
	       		"        0.9999833106994629,\r\n" + 
	       		"        0.9999438524246216,\r\n" + 
	       		"        0.9997561573982239,\r\n" + 
	       		"        0.9970873594284058,\r\n" + 
	       		"        0.9970768690109253,\r\n" + 
	       		"        0.9970569610595703\r\n" + 
	       		"      ]\r\n" + 
	       		"    }\r\n" + 
	       		"  ]\r\n" + 
	       		"}";


	       JSONObject jsonObject = JSON.parseObject(jsonStr);// json对象


	       String words_result = jsonObject.getString("words_result");//获取存储车牌号和颜色的数组
	       JSONArray resultArray = JSON.parseArray(words_result);// 转换为json数组对象
	       String ArrayStr=JSONArray.toJSONString(resultArray);
	       System.out.println("resultArray====" + ArrayStr);
	       System.out.println("——————————————————————————————————");
	       int count = 0;//识别个数
	       Iterator<Object> it = resultArray.iterator();// 使用Iterator迭代器
	       while (it.hasNext()) {
	           // 遍历数组
	           JSONObject arrayObj = (JSONObject) it.next();// JSONArray中是很多个JSONObject对象
	           String car_num = arrayObj.getString("number");//获取数组中车牌号码
	           String car_cor = arrayObj.getString("color");//获取数组中车牌颜色
	           count++;
	           System.out.println("car_num==========" + car_num);
	           System.out.println("car_cor==========" + car_cor);
	           System.out.println("------------------------------------");
	       }
	       System.out.println("识别车牌数为：" + count);
	   }
	}
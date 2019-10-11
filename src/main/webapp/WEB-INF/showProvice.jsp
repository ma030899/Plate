<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>- 各时间段车牌颜色数量变化 -</title>
</head>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="static/echarts/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="static/echarts/echarts.js"></script>

	<body>

		<!-- 显示Echarts图表 -->
		<div style="height:600px;min-height:100px;margin:0 auto;" id="main"></div>						
            		
  	
  
		<script type="text/javascript">
			
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {	//图表标题
                text: '各车牌颜色变化统计表'
            },
            tooltip: {
                trigger: 'axis', //坐标轴触发提示框，多用于柱状、折线图中
                /*
 				控制提示框内容输出格式
                formatter: '{b0}<br/><font color=#FF3333>&nbsp;●&nbsp;</font>{a0} : {c0} ℃ ' + 
               				'<br/><font color=#53FF53>●&nbsp;</font>{a1} : {c1} % ' +          
               				'<br/><font color=#68CFE8>&nbsp;●&nbsp;</font>{a3} : {c3} mm ' +
               				'<br/><font color=#FFDC35>&nbsp;●&nbsp;</font>{a4} : {c4} m/s ' +
               				'<br/><font color=#B15BFF>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;</font>{a2} : {c2} hPa ' 
                */
            },
            dataZoom: [
                 {
                     type: 'slider',	//支持鼠标滚轮缩放
                     start: 0,			//默认数据初始缩放范围为10%到90%
                     end: 100
                 },
                 {
                     type: 'inside',	//支持单独的滑动条缩放
                     start: 0,			//默认数据初始缩放范围为10%到90%
                     end: 100
                 }
            ],
            legend: {	//图表上方的类别显示           	
            	show:true,
            	data:['JS（江苏）','BJ（北京）','SH（上海）','GD（广东）','Other（其他）']
            },
            color:[
                   'blue',	//蓝色曲线颜色
                   'green',	//绿色曲线颜色
                   'yellow',//黄色车牌曲线颜色
                   'red',	//未知车牌曲线颜色
                   'black'	//未知车牌曲线颜色
                   ],
           toolbox: {
               feature: {
                 dataView: {show: true, readOnly: false},
                 magicType: {show: true, type: ['line', 'bar']},
                 restore: {show: true},
                 saveAsImage: {show: true}
               }
             },
            xAxis:  {	//X轴       	
                type : 'category',
                data : []	//先设置数据值为空，后面用Ajax获取动态数据填入
            },
            yAxis : [	//Y轴（这里我设置了两个Y轴，左右各一个）
						{
            				//第一个（左边）Y轴，yAxisIndex为0
	                         type : 'value',
	                         name : '总辆数',
	                         max:200,
	                         min:0,
	                         splitNumber:10,
	                         axisLabel : {
	                             formatter: '{value} 辆'	//控制输出格式(单位)
	                         }
	                     }
	                    /*   {
	                    	//第二个（右边）Y轴，yAxisIndex为1
	                         type : 'value',
	                         name : '单个',
	                         scale: true,
	                         max:10,
	                         min:0,
	                         splitNumber:10,
	                         axisLabel : {
	                             formatter: '{value} 辆'
	                         }
	                     }  */
	                 
            ],
            series : [	//系列（内容）列表                      
						{
		                    name:'江苏（blue）',
		                    type:'line',	//折线图表示（生成曲线）
		                    symbol:'emptycircle',	//设置折线图中表示每个坐标点的符号；emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形（图像可能会重叠，数据较少）	                    
		                    data:[]		//数据值通过Ajax动态获取
		                },
		                
		                {
		                    name:'北京（green）',
		                    type:'line',
		                    symbol:'emptyrect',
		                    data:[]
		                },
		                
		                {
		                    name:'上海（yellow）',
		                    type:'line',
		                    symbol:'circle',	
		                    /* yAxisIndex: 1, */		//与第二y轴有关
		                    data:[]
		                },
		                {
		                    name:'广东（red）',
		                    type:'line',
		                    symbol:'circle',	
		                    /* yAxisIndex: 1, */		//与第二y轴有关
		                    data:[]
		                },
		                
		                {
		                    name:'其他（unknow）',
		                    type:'bar',		//柱状图表示
		                    /* barMinHeight: 20, */	//柱条最小高度，可用于防止某数据项的值过小而影响交互
		                     label: {	//显示值
		                        normal: {
		                            show: true,
		                            position: 'center'
		                        }
		                    }, 
		                    data:[]
		                }
		                
		                        
            ]
        };
		 
		myChart.showLoading();	//数据加载完之前先显示一段简单的loading动画
		 
		 var JS=[];		//蓝色车牌数组
		 var BJ=[];		//绿色车牌数组
		 var SH=[];		//黄色车牌数组
		 var GD=[];		//未知车牌数组
		 var Others=[];		//未知车牌数组
		
		 var dates=[];		//时间数组
		 
         $.ajax({	//使用JQuery内置的Ajax方法
         type : "post",		//post请求方式
         async : true,		//异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url : "proviceRecord.action",	//请求发送到ShowInfoIndexServlet处
                 /* 一个固定的name */
         data : {name:"MLY"},		//请求内包含一个key为统一的name，value为A0001的参数；服务器接收到客户端请求时通过request.getParameter方法获取该参数值
         dataType : "json",		//返回数据形式为json
         success : function(result) {
        	 //请求成功时执行该函数内容，result即为服务器返回的json对象
	         if (result != null && result.length > 0) {
	                for(var i=0;i<result.length;i++){       
	                	JS.push(result[i].jiangsu);		//分别取出蓝色、绿色、黄色和未知颜色车牌等值并填入前面声明的各个颜色车牌相对应的数组
	                	BJ.push(result[i].beijing);
	                	SH.push(result[i].shanghai);
	                	GD.push(result[i].guangdong);
	                	Others.push(result[i].other)
	                 
	                   dates.push(result[i].date);
	                }
	                myChart.hideLoading();	//隐藏加载动画
	                
	                myChart.setOption({		//载入数据
	   		         xAxis: {
	   		             data: dates	//填入X轴数据
	   		         },
	   		         series: [	//填入系列（内容）数据
	   		               		{
			   		             // 根据名字对应到相应的系列
			   		             name: '江苏',
			   		             data: JS
	   		         		},
	   		               		{
			   		             name: '北京',
			   		             data: BJ
	   		         		},
	   		         			{
			   		             name: '上海',
			   		             data: SH
	   		         		},
	   		         			{
			   		             name: '广东',
			   		             data: GD
	   		         		},
	   		         			{
			   		             name: '其他',
			   		             data: Others
	   		         		}
	   		         		
	   		        ]
	   		     });
	                
	         }
	         else {
	        	 //返回的数据为空时显示提示信息
	        	 alert("图表请求数据为空，可能服务器暂未录入近五天的观测数据，您可以稍后再试！");
	          	 myChart.hideLoading();
	         }
         
		},
     	error : function(errorMsg) {
     		//请求失败时执行该函数
         	alert("图表请求数据失败，可能是服务器开小差了");
         	myChart.hideLoading();    	
     	}
    })

    myChart.setOption(option);	//载入图表
		 
    </script>
		
	</body>
</html>
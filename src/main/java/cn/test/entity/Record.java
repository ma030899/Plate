package cn.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 车牌颜色数量
 * 
 * @author mly
 *
 */
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;// 使用人姓名
	private Integer blue_count;// 蓝色车牌数量
	private Integer green_count;
	private Integer yellow_count;
	private Integer unknow_count;
	// 该注解加在实体类中的日期类型上，可以将返回的Json字符串中的时间戳转换为具体时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp dateStr;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBlue_count() {
		return blue_count;
	}

	public void setBlue_count(Integer blue_count) {
		this.blue_count = blue_count;
	}

	public Integer getGreen_count() {
		return green_count;
	}

	public void setGreen_count(Integer green_count) {
		this.green_count = green_count;
	}

	public Integer getYellow_count() {
		return yellow_count;
	}

	public void setYellow_count(Integer yellow_count) {
		this.yellow_count = yellow_count;
	}

	public Integer getUnknow_count() {
		return unknow_count;
	}

	public void setUnknow_count(Integer unknow_count) {
		this.unknow_count = unknow_count;
	}

	public Timestamp getDateStr() {
		return dateStr;
	}

	public void setDateStr(Timestamp dateStr) {
		this.dateStr = dateStr;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Record [name=" + name + ", blue_count=" + blue_count + ", green_count=" + green_count
				+ ", yellow_count=" + yellow_count + ", unknow_count=" + unknow_count + ", dateStr=" + dateStr
				+ ", date=" + date + "]";
	}

}

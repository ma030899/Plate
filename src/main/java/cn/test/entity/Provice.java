package cn.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Provice implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer provice_id;
	private String name;
	private Integer jiangsu;
	private Integer beijing;
	private Integer shanghai;
	private Integer guangdong;
	private Integer other;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp dateStr;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp date;
	
	public Integer getProvice_id() {
		return provice_id;
	}

	public void setProvice_id(Integer provice_id) {
		this.provice_id = provice_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getJiangsu() {
		return jiangsu;
	}

	public void setJiangsu(Integer jiangsu) {
		this.jiangsu = jiangsu;
	}

	public Integer getBeijing() {
		return beijing;
	}

	public void setBeijing(Integer beijing) {
		this.beijing = beijing;
	}

	public Integer getShanghai() {
		return shanghai;
	}

	public void setShanghai(Integer shanghai) {
		this.shanghai = shanghai;
	}

	public Integer getGuangdong() {
		return guangdong;
	}

	public void setGuangdong(Integer guangdong) {
		this.guangdong = guangdong;
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

	public Integer getOther() {
		return other;
	}

	public void setOther(Integer other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Provice [provice_id=" + provice_id + ", name=" + name + ", jiangsu=" + jiangsu + ", beijing=" + beijing
				+ ", shanghai=" + shanghai + ", guangdong=" + guangdong + ", dateStr=" + dateStr + ", date=" + date
				+ "]";
	}
	
	

}

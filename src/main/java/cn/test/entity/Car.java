package cn.test.entity;

import java.io.Serializable;

public class Car implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer carId;//编号
	private Integer userId;//
	private String allCarNum;//车牌号码
	private String allCarCor;//车牌颜色
	private String carLocation;//车辆所属地
	private long carTime;//识别耗时
	private Integer blueCount;
	private Integer greenCount;
	private Integer yellowCount;
	private Integer unknowCount;
	
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAllCarNum() {
		return allCarNum;
	}
	public void setAllCarNum(String allCarNum) {
		this.allCarNum = allCarNum;
	}
	public String getAllCarCor() {
		return allCarCor;
	}
	public void setAllCarCor(String allCarCor) {
		this.allCarCor = allCarCor;
	}
	public String getCarLocation() {
		return carLocation;
	}
	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}
	public long getCarTime() {
		return carTime;
	}
	public void setCarTime(long carTime) {
		this.carTime = carTime;
	}
	public Integer getBlueCount() {
		return blueCount;
	}
	public void setBlueCount(Integer blueCount) {
		this.blueCount = blueCount;
	}
	public Integer getGreenCount() {
		return greenCount;
	}
	public void setGreenCount(Integer greenCount) {
		this.greenCount = greenCount;
	}
	public Integer getYellowCount() {
		return yellowCount;
	}
	public void setYellowCount(Integer yellowCount) {
		this.yellowCount = yellowCount;
	}
	public Integer getUnknowCount() {
		return unknowCount;
	}
	public void setUnknowCount(Integer unknowCount) {
		this.unknowCount = unknowCount;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", userId=" + userId + ", allCarNum=" + allCarNum + ", allCarCor=" + allCarCor
				+ ", carLocation=" + carLocation + ", carTime=" + carTime + ", blueCount=" + blueCount + ", greenCount="
				+ greenCount + ", yellowCount=" + yellowCount + ", unknowCount=" + unknowCount + "]";
	}
	
	
	
	
}

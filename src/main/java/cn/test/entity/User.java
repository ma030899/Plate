package cn.test.entity;

import java.util.List;

public class User {

	private Integer id;
	private String userName;//车主姓名
	private String userImg;//车主车辆图片
	private String imgUrl;//图片地址
	private String carNum;//车牌号
	private String carCor;//车牌颜色
	private List<Car> cars;//关联属性
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarCor() {
		return carCor;
	}
	public void setCarCor(String carCor) {
		this.carCor = carCor;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userImg=" + userImg + ", imgUrl=" + imgUrl + ", carNum="
				+ carNum + ", carCor=" + carCor + "]";
	}
	
	
}

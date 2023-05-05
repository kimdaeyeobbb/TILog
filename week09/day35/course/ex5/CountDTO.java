package com.example.springedu.domain;

public class CountDTO {
	private int countNum;  // 누적 값을 저장
	public CountDTO() {
		System.out.println("CountVO 객체 생성!!");
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		// 기존값에 새로운 값을 누적
		this.countNum += countNum;
	}
}

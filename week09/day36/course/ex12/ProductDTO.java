package com.example.springedu.domain;
public class ProductDTO {  // SETTER와 GETTER 모두 있으면 DTO, GETTER만있으면 VO
	private int apple;
	private int banana;
	private int halabong;
	public int getApple() {
		return apple;
	}
	public void setApple(int apple) {
		this.apple += apple;
	}
	public int getBanana() {
		return banana;
	}
	public void setBanana(int banana) {
		this.banana += banana;
	}
	public int getHalabong() {
		return halabong;
	}
	public void setHalabong(int halabong) {
		this.halabong += halabong;
	}
}

// 이러한 도메인 객체는 VO대신 DTO를 붙여야 함 (한 번 생성 후 변경할 일이 없다면 VO로 설정)
package model.domain;
public class ProductDTO {
	private int apple;
	private int banana;
	private int halabong;
	public int getApple() {
		return apple;
	}

	// setter 메서드를 이용해서 현재 값만큼 증가
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

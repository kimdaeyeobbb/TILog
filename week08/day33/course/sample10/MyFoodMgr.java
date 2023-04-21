package week08.day33.course.sample10;

//setter, toString()추가
public class MyFoodMgr{
	private Food favoriteFood;
	private Food unFavoriteFood;	
	
	public MyFoodMgr() {}

	// 생성자를 통해 여러개의 객체를 주입할 떄에는 매개변수가 중요함
	// 타입부터 체크 -> 이후에 이름을 체크
	// unFavoriateFood 이름으로 만든 객체인 noodle이 전달됨
	public MyFoodMgr(Food favoriteFood, Food unFavoriteFood) {
		super();
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
		System.out.println("favoriteFood : " + favoriteFood);
		System.out.println("unFavoriteFood : " + unFavoriteFood);
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public void setUnFavoriteFood(Food unFavoriteFood)

	@Override
	public String toString() {
		return "[Food1=" + favoriteFood + ", Food2=" + unFavoriteFood + "]";
	}
}
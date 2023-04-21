package week08.day33.course.sampleno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//컴포넌트 어노테이션만 생략하고 오토와이어드만 쓸 수는 없음 (거꾸로는 가능)
//기본적으로 컴포넌트 어노테이션에 의해 괄호안의 이름으로 객체를 생성
//
@Component("myFood")  //default : myFoodMgr
public class MyFoodMgr{
	@Autowired
	// 멤버변수의 타입과 알맞은 객체를 찾음 -> 없으면 에러
	// required는 default가 true임.
	// 만약에 food 객체 2개 -> 멤버변수와 똑같은 이름의 변수를 대입해줌
	// 따라서 여기서는 bread가 대입됨

//	@Qualifier(value="unFavoriteFood")
	// 이 주석을 풀면 둘다 noodle이 됨 (둘다 unFavoriteFood가 주입되므로)
	private Food favoriteFood;     
	@Autowired
	// 여기서는 noodle이 대입됨 (멤버변수의 이름과 똑같은 이름의 변수 대입)
	private Food unFavoriteFood;
	                 
	
	@Override
	public String toString() {
		return "[favoriteFood=" + favoriteFood + ", unFavoriteFood=" + unFavoriteFood + "]";
	}
}

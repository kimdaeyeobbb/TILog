package com.example.springedu.domain;

import lombok.Getter;
import lombok.Setter;

/* 롬복 */
// 추가 메서드를 직접구현하지 않고 annotation을 이용할 수 있게됨
// VO는 생성자와 GETTER만 존재
// DTO는 GETTER, SETTER 존재
// GETTER, SETTER 모두가 필요한 경우 DTO로 만드는것이 맞다.
// value 객체를 만들고나서 읽는 용도로만 쓸거면 VO로 만드는 것이 맞다.
@Getter
@Setter
public class QueryDTO {
	// VO, DTO 객체로 받곘다는 것은 커멘드 객체로 받겠다는 것 (하나로 합쳐서 받겠다는 것)
	//  추출된 값이 없으면 null, 0, null 꼴로 들어갈 것임
	private String testName;
	private int testAge;
	private String testAddr;
}

const name = "Americano";
const price = 3000;

const coffee = {
  name: name,
  price: price,
};
console.log(coffee); // { name: 'Americano', price: 3000 }

/* key, value명이 같으면 아래와 같이 key(객체의 속성)만 적어줘도 객체가 됨 */
const coffee2 = { name, price }; // 객체 리터럴 반식 사용 -> 변수 name, price의 값을 가져와서 객체의 속성(key)으로 할당하는 것
console.log(coffee2); // { name: 'Americano', price: 3000 }

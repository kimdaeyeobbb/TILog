/* 구조분해할당 */
// 객체가 가진 멤버들을 각각의 변수에 할당할 수 있음
let coffee = {
  name: "Americano",
  price: 3000,
};

let { name: coffeeName, price: coffeePrice } = coffee;

console.log(coffeeName);

console.log(coffeePrice);

let coffee = {
  name: "Americano",
  price: 3000,
};

let { name: coffeeName, caffeine: coffeeCaffeine = 500 } = coffee;
// 기본값을 설정

console.log(coffeeName);

console.log(coffeeCaffeine);

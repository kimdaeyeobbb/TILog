let coffee = {
  name: "Americano",
  price: 3000,
};

let { name: coffeeName, caffeine: coffeeCaffeine } = coffee;

console.log(coffeeName); // Americano

console.log(coffeeCaffeine); // undefined. 없는 멤버를 지정하게되면 해당 변수는 값이 없는 상태로 만들어지게 됨

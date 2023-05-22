const coffee = {
  name: "Americano",
  price: 3000,
};

console.log(coffee);
console.log(coffee.name);
console.log(coffee.price);

const coffee2 = {
  name: "Americano",
  price: 3000,
};

console.log(coffee2);
console.log(coffee2.name);
console.log(coffee2.price);

const coffee3 = {
  name: "Americano",
  price: 3000,
};

console.log(coffee3);
console.log(coffee3.name);
console.log(coffee3.price);

/* 객체의 속성은 정적으로 정의되어있음 */
const key1 = "name";
const key2 = "price";

const coffee4 = {
  key1: "Americano",
  key2: 3000,
};

console.log("커피4");
console.log(coffee4);
console.log(coffee4.name); // undefined
console.log(coffee4.price); // undefined
console.log(coffee4.key1); // Americano
console.log(coffee4.key2); // 3000

/* 객체 속성의 이름으로 변수 key1, key2의 값이 사용되므로 해당 변수의 값에 따라 동적으로 속성에 접근할 수 있음 */
const coffee5 = {
  [key1]: "Americano",
  [key2]: 3000,
};

console.log(coffee5);
console.log(coffee5.name); // Americano
console.log(coffee5.price); // 3000
console.log(coffee5.key1); // undefined
console.log(coffee5.key2); // undefined

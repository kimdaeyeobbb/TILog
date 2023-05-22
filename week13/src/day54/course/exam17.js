const colorArray = ["red", "green", "blue"];
const newColorArray = [...colorArray, "orange"];

console.log(colorArray);
console.log(newColorArray); // [ 'red', 'green', 'blue', 'orange' ]

const numArray = [2, 3, 4];
const newNumArray = [1, ...numArray, 5];

console.log(numArray);
console.log(newNumArray); // [ 1, 2, 3, 4, 5 ]

function myPrint(a, b, c) {
  console.log(a);
  console.log(b);
  console.log(c);
}

const array = [1, 2, 3];

console.log(array);

myPrint(...array); // 1 2 3

console.log();

const stringArray = [..."xyz"];

console.log(stringArray);

myPrint(...stringArray);

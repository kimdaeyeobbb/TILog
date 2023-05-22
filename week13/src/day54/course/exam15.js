function add(a, b, ...args) {
  console.log(a, b, args);
  let sum = a + b;
  for (let i = 0; i < args.length; i++) {
    sum += args[i];
  }
  return sum;
}
let sum = add(1, 2, 3, 4, 5);
console.log("첫 add함수의 sum: " + sum);

function add2(...args) {
  console.log("add2의 args: " + args);
  let sum = 0;
  for (let i = 0; i < args.length; i++) {
    sum += args[i];
  }
  return sum;
}
sum = add2(1, 2, 3, 4, 5);
console.log("add2의 sum: " + sum);

function add(a, b = 10) {
  console.log("a = " + a);
  console.log("b = " + b);
  return a + b;
}

sum = add(1);
console.log(sum);

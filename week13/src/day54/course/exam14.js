let fruitSet = new Set();
console.log(fruitSet); // Set(0) {size: 0}

fruitSet = new Set(["Apple", "Melon"]);
console.log(fruitSet); // Set(2) {'Apple', 'Melon'}

fruitSet = new Set();
fruitSet.add("Apple");
fruitSet.add("Melon");
console.log(fruitSet); // Set(2) {'Apple', 'Melon'}
console.log(fruitSet.has("Apple")); // true
console.log(fruitSet.has("Melon")); // true

fruitSet.delete("Apple");
console.log(fruitSet.has("Apple")); // false
console.log(fruitSet); // Set(1) {'Melon'}
fruitSet = new Set(["Apple", "Melon", "Apple"]);

var keyIter = fruitSet.keys();

for (var key of keyIter) {
  console.log("키값 : " + key); // Apple Melon
}

var entriyIter = fruitSet.entries();

for (var entry of entriyIter) {
  console.log(entry); // [ 'Apple', 'Apple' ]  [ 'Melon', 'Melon' ]
  console.log("엔트리의 키값: " + entry.key);
  console.log("엔트리의 values: " + entry.values);
}
for (var fruit of fruitSet) {
  console.log(fruit); // Apple Melon
}

fruitSet.forEach(function (value1, value2) {
  console.log(value1 + " : " + value2); // Apple : Apple  Melon : Melon
});

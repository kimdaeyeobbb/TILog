let map = new Map([
  ["Apple", "red"],
  ["Melon", "green"],
]);

console.log(map.size); // 2
console.log(map); // Map(2) {'Apple' => 'red', 'Melon' => 'green'}

map = new Map();

map.set("Apple", "red");
map.set("Melon", "green");

console.log(map.get("Apple")); // red

console.log(map.get("Melon")); // green
console.log(map.has("Apple")); // true

console.log(map.has("Melon")); // true
map.delete("Apple");

console.log(map.has("Apple")); // false

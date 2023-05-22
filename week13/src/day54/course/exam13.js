let map = new Map([
  ["Apple", "red"],
  ["Melon", "green"],
]);

var keyIter = map.keys();

for (var key of keyIter) {
  console.log(key); // Apple Melon
}
var valueIter = map.values();

for (var value of valueIter) {
  console.log(value); // red green
}
var entriyIter = map.entries();

for (var entry of entriyIter) {
  console.log(entry); // (2) ['Apple', 'red']  (2) ['Melon', 'green']
}

map.forEach(function (value, key) {
  console.log(key + " : " + value); //Apple : red  Melon : green
});

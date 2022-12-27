const arr = ['a', 'b', 'a', 'b', 'c'];

const result = {};
arr.forEach((x) => {
  result[x] = (result[x] || 0) + 1;
});

console.log(result);

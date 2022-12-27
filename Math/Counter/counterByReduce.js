// 출처: https://hianna.tistory.com/459

const arr = ['a', 'b', 'a', 'b', 'c'];

const result = arr.reduce((accu, curr) => {
  accu[curr] = (accu[curr] || 0) + 1;
  return accu;
}, {});

console.log(result);

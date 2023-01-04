const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(' ')
  .map((val) => parseInt(val));

const [n, k] = input;

const mySolution = (n, k) => {
  const arr = Array.from({length: n}, (v, i) => i + 1);
  const result = [];

  let cnt = 0;

  while (arr.length) {
    cnt = (cnt + k - 1) % arr.length;
    result.push(arr[cnt]);
    arr.splice(cnt, 1);
  }

  return '<' + result.join(', ') + '>';
};

console.log(mySolution(n, k));

const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input.shift();
const result = [];

for (let i = 0; i < N; i++) {
  let count = 0;

  for (let b of input[i]) {
    count += b === '(' ? 1 : -1;

    if (count < 0) break;
  }
  result.push(count === 0 ? 'YES' : 'NO');
}
console.log(result.join('\n'));

//
//
// 다른 사람 풀이
const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.shift();

let temp;

while (input.length) {
  temp = input.shift();
  const stack = [];
  let result = 'YES';

  for (const b of temp) {
    if (b === '(') stack.push(b);
    else if (b === ')') {
      if (!stack.pop()) {
        result = 'NO';
        break;
      }
    }
  }

  if (stack.length !== 0) result = 'NO';
  console.log(result);
}

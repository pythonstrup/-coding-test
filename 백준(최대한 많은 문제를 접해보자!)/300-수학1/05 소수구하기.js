// 효율성 좋은 풀이
const fs = require('fs');
const [first, second] = fs.readFileSync('/dev/stdin').toString().trim().split(' ');

const temp = Array(+second).fill(true);
temp[0] = false;

for (let i = 0; i < +second; i++) {
  if (!temp[i]) continue;

  const count = i + 1;
  const divided = Math.floor(+second / count);

  for (let j = 2; j <= divided; j++) {
    const index = j * count - 1;

    temp[index] = false;
  }
}

const solution = temp
  .reduce((acc, cur, index) => {
    cur && +first - 1 <= index && acc.push(index + 1);

    return acc;
  }, [])
  .join('\n');

console.log(solution);

//
//
// 효율성 나쁨
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(' ')
  .map((val) => parseInt(val));

const m = input[0];
const n = input[1];

const answer1 = (m, n) => {
  let arr = Array(n + 1).fill(true);

  arr[0] = false;
  arr[1] = false;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (arr[i]) {
      for (let j = i * 2; j <= n; j += i) {
        arr[j] = false;
      }
    }
  }

  for (let i = m; i <= n; i++) {
    if (arr[i]) console.log(i);
  }
};
answer1(m, n);

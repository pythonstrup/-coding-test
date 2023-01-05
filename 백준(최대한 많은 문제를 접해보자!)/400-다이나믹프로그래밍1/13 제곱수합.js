const fs = require('fs');
const input = fs.readFileSync('dev/stdin').toString().split('\n');

let N = Number(input[0]);
let dp = new Array(N + 1).fill(Number.MAX_SAFE_INTEGER);

dp[1] = 1;
let powArr = [1];
for (let i = 2; i <= N; i++) {
  // 1. 제곱 수로 이루어지는 수인지 확인
  let sqrtNum = Math.sqrt(i);
  let floorNum = Math.floor(sqrtNum);
  if (floorNum * floorNum === i) {
    dp[i] = 1;
    powArr.push(floorNum * floorNum);
    continue;
  }

  // 2. 제곱 수들을 이용하여 찾는다.
  for (let j = 0; j < powArr.length; j++) {
    dp[i] = Math.min(dp[i], 1 + dp[i - powArr[j]]);
  }
}
console.log(dp[N]);

//
//
//

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = Number(fs.readFileSync(filePath).toString());
console.log(solution(input));

/**
 * @param {number} input
 */
function solution(input) {
  const cache = new Array(input + 1).fill(0).map((_, index) => index);

  cache[1] = 1;
  for (let i = 1; i <= input; i++) {
    for (let j = 1; j ** 2 <= i; j++) {
      cache[i] = Math.min(cache[i], cache[i - j ** 2] + 1);
    }
  }
  return cache[input];
}

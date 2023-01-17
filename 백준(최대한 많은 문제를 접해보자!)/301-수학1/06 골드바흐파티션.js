// 내풀이 - 효율 300ms
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);

function makePrime(primeArr, size) {
  for (let i = 2; i < Math.sqrt(size); i++) {
    if (primeArr[i]) {
      for (let j = i * 2; j <= size; j += i) {
        primeArr[j] = false;
      }
    }
  }
}

function goldBach(value, primeArr) {
  let answer = 0;
  for (let i = 2; i <= value; i++) {
    const number = value - i;
    if (i > value / 2) break;
    if (primeArr[number] && primeArr[i]) {
      answer += 1;
    }
  }
  console.log(answer);
}

function solution(data) {
  const size = Math.max(...data) + 1;
  const primeArr = Array(size).fill(true).fill(false, 0, 2);
  makePrime(primeArr, size);
  for (const value of data) {
    goldBach(value, primeArr);
  }
}

input.shift();
solution(input);

//
//
// 효율이 50ms정도 더 높았던 풀이
let input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n').map(Number);
input.shift();
let maxNum = Math.max(...input);
let nums = Array(maxNum + 1).fill(true);
let answer = [];

nums.splice(0, 2, false, false);

for (let i = 2; i * i <= maxNum; i++) {
  if (nums[i]) {
    for (let j = i * i; j <= maxNum; j += i) {
      nums[j] = false;
    }
  }
} // 여기까지 소수 구하기.

for (let i = 0; i < input.length; i++) {
  let pick = input[i];
  let count = 0;

  if (pick === 4 || pick === 5) {
    answer.push(1);
    continue;
  }

  for (let j = 3; j <= pick / 2; j += 2) {
    if (nums[j] && nums[pick - j]) {
      count++;
    }
  }
  answer.push(count);
}

console.log(answer.join('\n'));

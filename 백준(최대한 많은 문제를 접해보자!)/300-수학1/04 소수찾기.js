const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = parseInt(input[0]);
const data = input
  .splice(1)[0]
  .split(' ')
  .map((val) => parseInt(val));

const mySolution = (n, nums) => {
  let result = 0;

  for (let num of nums) {
    for (let i = 2; i <= num; i++) {
      if (num % i === 0) {
        if (num === i) result++;
        break;
      }
    }
  }

  return result;
};
console.log(mySolution(n, data));

//
//
// 다른 풀이
const fs = require('fs');
const [n, input] = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const data = input.trim().split(' ');

let sum = 0;
for (let index = 0; index < data.length; index++) {
  const result = isPrime(data[index]);
  sum += result ? 1 : 0;
}

console.log(sum);

function isPrime(n) {
  if (n <= 1) return false;
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      return false;
    }
  }
  return true;
}

//
//
// 또 다른 풀이
const input = require('fs').readFileSync('/dev/stdin').toString().trim();
const [length, nums] = input.split('\n');
const isPrime = (n) => {
  if (n == 1) {
    return false;
  }

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      return false;
    }
  }

  return true;
};
console.log(nums.split(' ').filter((v) => isPrime(v)).length);

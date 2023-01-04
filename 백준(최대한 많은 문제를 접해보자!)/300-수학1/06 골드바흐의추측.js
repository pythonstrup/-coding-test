// 효율 좋음
let fs = require('fs');
let inputString = fs.readFileSync('/dev/stdin').toString().trim();
// const inputString = `8
// 20
// 42
// 0`;

const input = inputString
  .split('\n')
  .slice(0, -1)
  .map((_) => +_);
const primeNumbers = [];
const isPrimeNumber = new Array(1000001).fill(true);

for (let num = 2; num < isPrimeNumber.length; num++) {
  if (!isPrimeNumber[num]) continue;
  if (num % 2 === 1) primeNumbers.push(num);
  for (let k = num + num; k < isPrimeNumber.length; k += num) {
    isPrimeNumber[k] = false;
  }
}

const resultArr = [];
for (let i = 0; i < input.length; i++) {
  const num = input[i];
  let findResult = false;
  for (let j = 0; j < primeNumbers.length; j++) {
    const num1 = primeNumbers[j];
    if (num1 > num / 2) break;
    const num2 = num - num1;
    if (isPrimeNumber[num2]) {
      resultArr.push(`${num} = ${num1} + ${num2}`);
      findResult = true;
      break;
    }
  }
  if (!findResult) {
    console.log("Goldbach's conjecture is wrong.");
    return;
  }
}

console.log(resultArr.join('\n'));

// 효율 좋음2
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);

let answer = '';
let prime = Array(Math.max(...input) + 1)
  .fill(true)
  .fill(false, 0, 2);
for (let i = 2; i < prime.length; i++) {
  for (let j = i * i; j <= prime.length; j += i) {
    prime[j] = false;
  }
}

for (let i = 0; i < input.length; i++) {
  for (let j = 3; j < prime.length; j += 2) {
    if (prime[j] && prime[input[i] - j]) {
      answer += input[i] + ' = ' + j + ' + ' + (input[i] - j) + '\n';
      break;
    }
  }
}
console.log(answer);

// 효율 나쁨
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

function primeNum(n) {
  if (n == 1) return 0;
  for (let i = 2; i * i <= n; i++) if (n % i == 0) return 0;
  return 1;
}

for (let i = 0; i < input.length - 1; i++) {
  a = parseInt(input[i]);
  if (a == 0) break;

  for (let i = 3; i < a; i = i + 2) {
    if (primeNum(i) && primeNum(a - i)) {
      console.log('%d = %d + %d', a, i, a - i);
      i = a;
    }
  }
}

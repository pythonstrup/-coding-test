let fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = +fs.readFileSync(filePath).toString();

let number = BigInt(input);
function factorial(n) {
  if (n === BigInt(0)) return BigInt(1);
  return n * factorial(n - BigInt(1));
}

let num = factorial(number);
let answer = 0;
while (num) {
  if (num % BigInt(10) !== BigInt(0)) break;
  num = num / BigInt(10);
  answer++;
}

console.log(answer);

//
//
//
const fs = require('fs');
const inputs = fs.readFileSync('/dev/stdin').toString();
inputs = Number(inputs);
let answer = 0;
while (inputs >= 5) {
  answer += parseInt(inputs / 5);
  inputs /= 5;
}

console.log(answer);

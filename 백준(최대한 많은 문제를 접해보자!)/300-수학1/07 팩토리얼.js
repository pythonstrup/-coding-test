const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();

const factorial = (num) => {
  if (num < 1) return 1;
  return num * factorial(num - 1);
};

console.log(factorial(Number(input)));

//
//
//
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim();

input = parseInt(input);

const answer1 = (num) => {
  let result = 1;

  for (let i = 1; i <= num; i++) {
    result *= i;
  }

  return result;
};

console.log(answer1(input));

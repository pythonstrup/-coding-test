const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(' ')
  .map((val) => parseInt(val));

const n = input[0];
const m = input[1];

const mySolution = (n, m) => {
  const getCount = (num, k) => {
    cnt = 0;
    while (num) {
      num = parseInt(num / k);
      cnt += num;
    }
    return cnt;
  };

  const twoCnt = getCount(n, 2) - getCount(m, 2) - getCount(n - m, 2);
  const fiveCnt = getCount(n, 5) - getCount(m, 5) - getCount(n - m, 5);

  return Math.min(twoCnt, fiveCnt);
};

console.log(mySolution(n, m));

//
//
//
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const [n, m] = require('fs').readFileSync(filePath).toString().trim().split(' ').map(Number);

function getPower(num, power) {
  let cnt = 0;
  while (num >= power) {
    cnt = cnt + Math.floor(num / power);
    num = num / power;
  }
  return cnt;
}

const two = getPower(n, 2) - getPower(m, 2) - getPower(n - m, 2);
const five = getPower(n, 5) - getPower(m, 5) - getPower(n - m, 5);

console.log(Math.min(two, five));

//
//
//
n = require('fs').readFileSync(0).toString().split(' ');
console.log(s(parseInt(n[0]), parseInt(n[1])));

function w(n, q) {
  cnt = 0;
  d = q;
  while (n >= d) {
    cnt += parseInt(n / d);
    d *= q;
  }
  return cnt;
}
function s(n, m) {
  a = w(n, 5) - w(n - m, 5) - w(m, 5);
  b = w(n, 2) - w(n - m, 2) - w(m, 2);
  return a < b ? a : b;
}

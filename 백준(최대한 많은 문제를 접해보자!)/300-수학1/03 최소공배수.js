// 재귀 사용
const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const T = +input[0];
const A = input.slice(1);
const lcm = [];

const gcd = (a, b) => {
  if (b === 0) return a;
  else return gcd(b, a % b);
};

for (let i = 0; i < T; i++) {
  const [a, b] = A[i].split(' ').map((v) => +v);
  const result = gcd(a, b);
  lcm.push((a * b) / result);
}

console.log(lcm.join('\n'));

//
//
// 반복문
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const iter = Number(input.shift());

let ans = [];

for (let i = 0; i < iter; i++) {
  let [a, b] = input[i].split(' ').map((item) => Number(item));

  let originala = a;
  let originalb = b;

  // 유클리드 호세법
  // while문이 끝나면 최대공약수는 b가 된다.
  while (a % b !== 0) {
    let r = a % b;

    if (r !== 0) {
      a = b;
      b = r;
    }
  }

  // 최소공배수
  // 최소공배수 = 자연수1 * 자연수2 / 최대공약수
  let min = (originala * originalb) / b;
  ans.push(min);
}

console.log(ans.join('\n'));

// 재귀 사용
const input = require('fs').readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

function getGCD(A, B) {
  if (A % B === 0) return B;
  else return getGCD(B, A % B);
}

function getLCM(A, B, GCD) {
  return (A * B) / GCD;
}

const [A, B] = input;
const GCD = getGCD(A, B);
const LCM = getLCM(A, B, GCD);

console.log(`${GCD}\n${LCM}`);

// 반복문 버전
const arr = require('fs').readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

//최대 공약수는 큰 수 부터 찾아야겠다.
//어차피 작은 수 보다는 작은 수가 나와야하니까, 작은 수 기준으로
const smaller = Math.min(...arr);
const bigger = Math.max(...arr);
// console.log(bigger)

for (let i = smaller; i > 0; i--) {
  if (arr[0] % i === 0 && arr[1] % i === 0) {
    console.log(i);
    break;
  }
}

//최소공배수는 큰 수의 배수를 기준으로 구하면 될 듯
let count = 1;
let multiple = 1;

while (true) {
  multiple = bigger * count;
  if (multiple % smaller === 0) {
    console.log(multiple);
    break;
  }
  count++;
  // (bigger * count) % arr[1] === 0
}

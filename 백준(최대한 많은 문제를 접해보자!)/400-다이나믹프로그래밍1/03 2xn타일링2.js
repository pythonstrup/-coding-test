function solution(n) {
  const F = Array.from({length: n + 1}, () => 0);
  F[1] = 1;
  F[2] = 3;

  for (let i = 3; i <= n; i++) {
    F[i] = (F[i - 1] + F[i - 2] * 2) % 10007;
  }

  return F[n];
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const n = Number(input[0]);

console.log(solution(n));

//
//
//
const n = +require('fs').readFileSync('./dev/stdin').toString();
const dp = Array(n + 1).fill(0);
dp[1] = 1;
dp[2] = 3;
for (let i = 3; i <= n; i++) dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
console.log(dp[n]);

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let n = Number(input[0]);
let list = input[1].split(' ').map(Number);
let dp = [0];
for (let i = 1; i <= n; i++) {
  dp[i] = list[i - 1];
  for (let j = 1; j <= i / 2; j++) {
    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
  }
}
console.log(dp[n]);

//
//
//
const [N, cards] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(N);
const cns = cards.split(' ').map((ch) => Number(ch));
const dp = [0, ...cns];

for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= i; j++) {
    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
  }
}

console.log(dp[n]);

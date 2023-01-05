const [N, ...Nums] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(N);
const nums = Nums.map((ch) => Number(ch));
const MOD = 1000000009;
const MAX = 100000;
const dp = Array.from({length: MAX + 1}, () => new Array(4).fill(0));

const logs = [];

dp[1][1] = dp[2][2] = dp[3][3] = dp[3][1] = dp[3][2] = 1;
for (let i = 4; i <= MAX; i++) {
  dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
  dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
  dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
}

for (let i = 0; i < n; i++) {
  const d = nums[i];
  const answer = (dp[d][1] + dp[d][2] + dp[d][3]) % MOD;
  logs.push(answer);
}

console.log(logs.join('\n'));

//
//
//

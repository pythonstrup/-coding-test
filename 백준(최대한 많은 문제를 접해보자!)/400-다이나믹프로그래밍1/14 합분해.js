const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input;
rl.on('line', function (line) {
  input = line;
  rl.close();
}).on('close', function () {
  console.log(solution(input));
  process.exit();
});

const DIVIDER = 1000000000;

function solution(input) {
  const [N, K] = input.split(' ').map((ch) => parseInt(ch));

  const dp = new Array(K + 1);
  for (let i = 0; i < K + 1; i++) {
    const row = new Array(N + 1).fill(1);
    dp[i] = row;
  }
  for (let j = 0; j < N + 1; j++) {
    dp[0][j] = 0;
  }

  for (let k = 2; k <= K; k++) {
    for (let n = 1; n <= N; n++) {
      dp[k][n] = ((dp[k][n - 1] % DIVIDER) + (dp[k - 1][n] % DIVIDER)) % DIVIDER;
    }
  }
  return dp[K][N];
}

//
//
// 위와 시간복잡도 비슷 - 코드는 더 짧다.
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
let n = Number(input[0]);
let k = Number(input[1]);
let dp = new Array(n + k);
(dp[0] = [1]), (dp[1] = [1, 1]);
for (let i = 2; i < n + k; i++) {
  dp[i] = [];
  dp[i][0] = 1;
  dp[i][i] = 1;
  for (let j = 1; j < i; j++) {
    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000000;
  }
}
console.log(dp[n + k - 1][n]);

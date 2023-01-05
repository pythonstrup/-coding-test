const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let num = +fs.readFileSync(filePath).toString();

const dp = {
  1: 1,
  2: 2,
};

for (let i = 3; i <= num; i++) {
  dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
}

console.log(dp[num]);

//
//
//

var fs = require('fs');
var inputs = fs.readFileSync('/dev/stdin').toString().split('\n');
var cases = Number(inputs[0]);
var inputs = inputs[1].split(' ').map((v) => Number(v));
var dp = new Array(cases).fill(0);
for (var i = 0; i < cases; i++) {
  var max = 0;
  for (var j = 0; j < i; j++) {
    if (inputs[i] > inputs[j] && dp[j] > max) {
      max = dp[j];
    }
  }
  dp[i] = max + 1;
}
console.log(Math.max(...dp));

//
//
//
let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
let count = 0;

const N = Number(input[count++]); // 수열 A의 크기
let A = input[count++].split(' ').map(Number); // 수열 A [10, 20, 10, 30, 20 ,50]
let dp = new Array(N + 1).fill(0); //
dp[1] = 1; // [0, 1, 0, 0, 0, 0, 0]

for (let i = 2; i <= N; i++) {
  let max = -Infinity;
  for (let j = i - 1; j > 0; j--) {
    if (A[i - 1] > A[j - 1]) {
      max = Math.max(max, dp[j]);
    }
  }
  dp[i] = max === -Infinity ? 1 : max + 1;
}

console.log(Math.max.apply(null, dp));

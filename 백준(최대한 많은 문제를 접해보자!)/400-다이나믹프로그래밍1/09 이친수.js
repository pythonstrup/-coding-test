let fs = require('fs');
const filePath = process.platform === `linux` ? `/dev/stdin` : `예제.txt`;
let input = fs.readFileSync(filePath).toString().split(' ');
const c = console.log;

n = Number(input[0]);

let dp = [];

dp[0] = 0;
dp[1] = 1;

for (let i = 2; i < 91; i++) {
  dp[i] = BigInt(dp[i - 2]) + BigInt(dp[i - 1]);
}

c(String(dp[n]));

/**
 * 0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.
 * 이친수는 0으로 시작하지 않는다.
 * 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 * 예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.
 *
 * N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 * @see https://www.acmicpc.net/problem/2193
 */

let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();
let n = parseInt(input);
let result = Array.from({length: 91});

let fibo = (num) => {
  if (num === 1 || num === 2) {
    return 1;
  }
  if (result[num] !== undefined) return BigInt(result[num]);
  return (result[num] = BigInt(fibo(num - 1)) + BigInt(fibo(num - 2)));
};

let ans = fibo(n);
console.log(ans.toString());

//
//
//
const fs = require('fs');
const N = parseInt(fs.readFileSync('/dev/stdin').toString().trimRight());

const d = new Array(N + 1).fill(BigInt(0));
d[1] = BigInt(1);
for (let i = 2; i <= N; i++) d[i] = d[i - 1] + d[i - 2];
console.log(d[N].toString());

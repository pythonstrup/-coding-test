const input = require('fs').readFileSync('/dev/stdin').toString();

const num = Number(input);

const DP = new Array(num + 1).fill(0);

for (let i = 2; i <= num; i++) {
  DP[i] = DP[i - 1] + 1;

  if (i % 2 === 0) {
    DP[i] = Math.min(DP[i], DP[i / 2] + 1);
  }

  if (i % 3 === 0) {
    DP[i] = Math.min(DP[i], DP[i / 3] + 1);
  }
}

console.log(DP[num]);

//
//
//
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();

const num = +input;
const cache = [0, 0];

for (let i = 2; i <= num; i++) {
  cache[i] = cache[i - 1] + 1;

  if (i % 6 === 0) {
    cache[i] = Math.min(cache[i], cache[i / 2] + 1, cache[i / 3] + 1);
  } else if (i % 2 === 0) {
    cache[i] = Math.min(cache[i], cache[i / 2] + 1);
  } else if (i % 3 === 0) {
    cache[i] = Math.min(cache[i], cache[i / 3] + 1);
  }
}

console.log(cache[num]);

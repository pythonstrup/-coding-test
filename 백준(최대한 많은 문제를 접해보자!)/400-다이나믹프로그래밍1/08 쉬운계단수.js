var fs = require('fs');
var inputs = fs.readFileSync('/dev/stdin').toString();
inputs = Number(inputs);
var arr = [];
arr[0] = [];
arr[1] = new Array(10).fill(1);
arr[1][0] = 0;
for (var i = 1; i < inputs; i++) {
  arr[i + 1] = new Array(10).fill(0);
  arr[i + 1][1] += arr[i][0] % 1000000000;
  for (var k = 1; k < arr[i].length - 1; k++) {
    arr[i + 1][k - 1] += arr[i][k] % 1000000000;
    arr[i + 1][k + 1] += arr[i][k] % 1000000000;
  }
  arr[i + 1][8] += arr[i][9] % 1000000000;
}
console.log(arr[inputs].reduce((a, v) => a + v, 0) % 1000000000);

//
//
//
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const n = +require('fs').readFileSync(filePath).toString().trim();

const dpArr = Array.from({length: n}, () => new Array(10).fill(1));
dpArr[0][0] = 0;

for (let i = 1; i < n; i++) {
  for (let j = 0; j <= 9; j++) {
    if (j === 0) {
      dpArr[i][j] = dpArr[i - 1][j + 1] % 1000000000;
    } else if (j === 9) {
      dpArr[i][j] = dpArr[i - 1][j - 1] % 1000000000;
    } else {
      dpArr[i][j] = (dpArr[i - 1][j - 1] + dpArr[i - 1][j + 1]) % 1000000000;
    }
  }
}

let answer = 0;
for (let i = 0; i <= 9; i++) {
  answer += dpArr[n - 1][i];
}
console.log(answer % 1000000000);
